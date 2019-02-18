package yjh.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import yjh.model.Info;
import yjh.model.User;

import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDAOTest {

    @Resource
    UserDAO userDAO;

    @Resource
    InfoDAO infoDAO;

    @Test
    public void addUser() {
        User user = new User();
        user.setUsername("yjh2");
        user.setPassword("123");
        user.setAddress("无锡");
        userDAO.addUser(user);
    }

    @Test
    public void getById() {
        User user = userDAO.getById(1);
        System.out.println(user);
    }

    @Test
    public void getByName() {
        User user = userDAO.getByName("yjh");
        System.out.println(user);
    }


    @Test
    public void updateById() {
        User user = new User();
        user.setUserId(1);
        user.setAddress("梁溪");
        user.setBalance(10.0);
        userDAO.updateUser(user);
    }

    @Test
    public void addInfo() {
        Info info = new Info();
        info.setInfoId(3);
        info.setDescription("破洞");
        infoDAO.updateById(info);
    }
}