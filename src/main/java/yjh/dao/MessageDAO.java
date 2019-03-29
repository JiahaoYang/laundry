package yjh.dao;

import org.apache.ibatis.annotations.*;
import yjh.model.Message;

import java.util.List;

@Mapper
public interface MessageDAO {


    @Insert(" insert into message(user_id, message) values(#{userId}, #{message}) ")
    @Options(useGeneratedKeys = true, keyProperty = "messageId")
    int addMessage(Message message);

    @Select(" select * from message where user_id=#{userId} ")
    List<Message> getMine(int userId);

    @Delete(" delete from message where message_id=#{messageId} ")
    int deleteById(int messageId);

    @Select(" select * from message where message_id=#{messageId}")
    Message getById(int messageId);

}
