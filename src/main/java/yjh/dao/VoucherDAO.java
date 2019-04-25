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

    @Select(" select * from voucher where user_id=#{userId} order by get_date")
    List<Voucher> getByUser(int userId);

    @Select(" select * from voucher order by get_date desc")
    List<Voucher> list();


    @Select(" select * from voucher order by get_date")
    List<Voucher> list1();

    @Select(" select * from voucher where date_format(get_date, '%Y-%m')=#{month} order by get_date ")
    List<Voucher> listByMonth(String month);
    
}
