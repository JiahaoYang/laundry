package yjh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import yjh.dao.VoucherDAO;
import yjh.dto.IncomeDTO;
import yjh.model.User;
import yjh.model.Voucher;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class VoucherService {

    @Resource
    private VoucherDAO voucherDAO;

    @Autowired
    private UserService userService;

    @Autowired
    private VoucherDetailService voucherDetailService;

    public int addVoucher(Voucher voucher) {
        return voucherDAO.addVoucher(voucher);
    }

    public int updateVoucher(Voucher voucher) {
        return voucherDAO.updateVoucher(voucher);
    }

    public Voucher getById(int voucherId) {
        return voucherDAO.getById(voucherId);
    }

    public List<Voucher> getByUser(int userId) {
        List<Voucher> vouchers = voucherDAO.getByUser(userId);
        voucherDetailService.fillVouchers(vouchers);
        return vouchers;
    }

    public List<Voucher> list() {
        List<Voucher> vouchers = voucherDAO.list();
        voucherDetailService.fillVouchers(vouchers);
        for (Voucher voucher: vouchers) {
            User user = userService.getById(voucher.getUserId());
            voucher.setUser(user);
        }
        return vouchers;
    }

    public List<IncomeDTO> listByMonth(String month) {
        List<Voucher> vouchers = voucherDAO.listByMonth(month);
        List<IncomeDTO> list = new ArrayList<>();
        for (Voucher voucher: vouchers) {
            String date = voucher.getGetDate().substring(5, 10);
            double price = voucher.getPrice();
            if (list.size() > 0 && list.get(list.size() - 1).getDate().equals(date)) {
                IncomeDTO last = list.get(list.size() - 1 );
                last.setIncome(last.getIncome() + price);
            } else {
                IncomeDTO incomeDTO = new IncomeDTO();
                incomeDTO.setIncome(price);
                incomeDTO.setDate(date);
                list.add(incomeDTO);
            }
        }
        return list;
    }

    public List<String> listMonths() {
        List<Voucher> vouchers = voucherDAO.list1();
        List<String> months = new ArrayList<>();
        for (Voucher voucher: vouchers) {
            String month = voucher.getGetDate().substring(0, 7);
            if (months.size() > 0 && months.get(months.size() - 1).equals(month))
                continue;
            months.add(month);
        }
        return months;
    }
}
