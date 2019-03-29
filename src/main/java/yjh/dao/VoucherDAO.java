package yjh.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import yjh.model.Voucher;

import java.util.List;

@Mapper
public interface VoucherDAO {

    int addVoucher(Voucher voucher);

    int updateVoucher(Voucher voucher);

    @Select(" select * from voucher where voucher_id=#{voucherId} ")
    Voucher getById(int voucherId);

    @Select(" select * from voucher where user_id=#{userId} ")
    Voucher getByUser(int userId);

    @Select(" select * from voucher ")
    List<Voucher> list();
    
}
