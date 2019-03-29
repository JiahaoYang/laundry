package yjh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yjh.dao.VoucherDetailDAO;
import yjh.model.*;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VoucherDetailService {

    @Resource
    private VoucherDetailDAO voucherDetailDAO;

    @Autowired
    private ClothesService clothesService;

    public int addVoucherDetail(VoucherDetail voucherDetail) {
        return voucherDetailDAO.addVoucherDetail(voucherDetail);
    }

    public int updateVoucherDetail(VoucherDetail voucherDetail) {
        return voucherDetailDAO.updateVoucherDetail(voucherDetail);
    }

    public VoucherDetail getById(int voucherDetailId) {
        return voucherDetailDAO.getById(voucherDetailId);
    }

    public List<VoucherDetail> getByVoucherId(int voucherId) {
        return voucherDetailDAO.getByVoucherId(voucherId);
    }

    public VoucherDetail getByClothesId(int clothesId) {
        return voucherDetailDAO.getByClothesId(clothesId);
    }

    public void fillVouchers(List<Voucher> vouchers) {
        for (Voucher voucher: vouchers)
            fill(voucher);
    }

    private void fill(Voucher voucher) {
        List<VoucherDetail> voucherDetails = voucherDetailDAO.getByVoucherId(voucher.getVoucherId());
        for (VoucherDetail voucherDetail: voucherDetails) {
            Clothes clothes = clothesService.getById(voucherDetail.getClothesId());
            voucherDetail.setClothes(clothes);
        }
        voucher.setVoucherDetailList(voucherDetails);
    }

    public int updateByVoucher(int voucherId) {
        return voucherDetailDAO.updateByVoucher(voucherId);
    }
}
