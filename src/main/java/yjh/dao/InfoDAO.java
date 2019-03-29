package yjh.dao;

import org.apache.ibatis.annotations.*;
import yjh.model.Info;

import java.util.List;

@Mapper
public interface InfoDAO {

    @Select(" select * from info order by info_id desc")
    List<Info> list();

    int addInfo(Info info);

    @Delete(" delete from info where info_id=#{infoId}")
    int deleteById(int infoId);


    int updateById(Info info);

    @Select(" select * from info where info_id=#{infoId}")
    Info getById(int infoId);
}
