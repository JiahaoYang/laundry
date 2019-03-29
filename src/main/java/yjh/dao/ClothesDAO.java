package yjh.dao;

import org.apache.ibatis.annotations.*;
import yjh.model.Clothes;

@Mapper
public interface ClothesDAO {


    int addClothes(Clothes clothes);

    @Delete(" delete from clothes where clothes_id=#{clothesId} ")
    int deleteById(int clothesId);

    @Select(" select * from clothes where clothes_id=#{clothesId} ")
    Clothes getById(int clothesId);

}
