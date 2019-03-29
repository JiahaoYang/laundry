package yjh.dao;

import org.apache.ibatis.annotations.*;
import yjh.model.Rewash;

import java.time.LocalDateTime;

@Mapper
public interface RewashDAO {

    int addRewash(Rewash rewash);

    @Select(" select * from rewash where voucher_detail_id=#{id} ")
    Rewash getById(int id);

    @Update(" update rewash set take_date=#{takeDate} where voucher_detail_id=#{vdId} ")
    int updateRewash(LocalDateTime takeDate, int vdId);

}
