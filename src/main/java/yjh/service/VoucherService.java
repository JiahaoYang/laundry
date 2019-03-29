package yjh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yjh.dao.VoucherDAO;
import yjh.model.User;
import yjh.model.Voucher;

import javax.annotation.Resource;
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

    public Voucher getByUser(int userId) {
        return voucherDAO.getByUser(userId);
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

}
