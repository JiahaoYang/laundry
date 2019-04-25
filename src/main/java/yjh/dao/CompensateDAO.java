package yjh.dao;

import org.apache.ibatis.annotations.*;
import yjh.model.Compensate;
import yjh.model.Rewash;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface CompensateDAO {

    int addCompensate(Compensate compensate);

    @Select(" select * from compensate where voucher_detail_id=#{id} ")
    Compensate getById(int id);

    @Select(" select * from compensate order by compensate_date desc ")
    List<Compensate> list();

}
