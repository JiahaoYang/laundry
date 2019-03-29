package yjh.dao;

import org.apache.ibatis.annotations.*;
import yjh.model.Compensate;
import yjh.model.Rewash;

import java.time.LocalDateTime;

@Mapper
public interface CompensateDAO {

    int addCompensate(Compensate compensate);

    @Select(" select * from compensate where voucher_detail_id=#{id} ")
    Compensate getById(int id);

}
