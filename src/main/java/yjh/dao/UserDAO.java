package yjh.dao;

import org.apache.ibatis.annotations.*;
import yjh.model.User;

import java.util.List;

@Mapper
public interface UserDAO {

    String TABLE_NAME = " user ";
    String INSERT_FIELDS = " username, password, user_type, gender, " +
            "phone, address, balance, total_consume, consume_times, register_date";
    String SELECT_FIELDS = " user_id, " + INSERT_FIELDS;


    @Select({"select " + SELECT_FIELDS + " from " + TABLE_NAME + " where user_id=#{userId}"})
    User getById(int userId);

    @Select({"select " + SELECT_FIELDS + " from " + TABLE_NAME + " where username=#{username}"})
    User getByName(String username);

    int addUser(User user);

    int updateUser(User user);

    @Update(" update user set password=#{password} where username=#{username}" )
    int updatePassword(String username, String password);

    @Select(" select * from user where user_type='会员' ")
    List<User> list();

}
