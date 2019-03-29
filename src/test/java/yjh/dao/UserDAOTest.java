package yjh.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import yjh.model.*;

import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDAOTest {

    @Resource
    UserDAO userDAO;

    @Resource
    InfoDAO infoDAO;

    @Resource
    ClothesDAO clothesDAO;

    @Resource
    VoucherDAO voucherDAO;

    @Resource
    VoucherDetailDAO voucherDetailDAO;


    @Test
    public void addUser() {

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
        Voucher voucher = new Voucher();
    }

}