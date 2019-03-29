package yjh.dao;

import org.apache.ibatis.annotations.*;
import yjh.model.VoucherDetail;

import java.util.List;

@Mapper
public interface VoucherDetailDAO {


    int addVoucherDetail(VoucherDetail voucherDetail);

    int updateVoucherDetail(VoucherDetail voucherDetail);

    @Select(" select * from voucher_detail where voucher_detail_id=#{voucherDetailId} ")
    VoucherDetail getById(int voucherDetailId);

    @Select(" select * from voucher_detail where voucher_id=#{voucherId} ")
    List<VoucherDetail> getByVoucherId(int voucherId);

    @Select(" select * from voucher_detail where clothes_id=#{clothesId} ")
    VoucherDetail getByClothesId(int clothesId);

    @Update(" update voucher_detail set is_taken='已取走' where voucher_id=#{voucherId}")
    int updateByVoucher(int voucherId);

}
