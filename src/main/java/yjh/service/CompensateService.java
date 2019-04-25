package yjh.service;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yjh.dao.CompensateDAO;
import yjh.model.*;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompensateService {

    @Resource
    private CompensateDAO compensateDAO;
    @Autowired
    private VoucherDetailService voucherDetailService;
    @Autowired
    private UserService userService;
    @Autowired
    private VoucherService voucherService;


    public int addCompensate(Compensate compensate) {
        return compensateDAO.addCompensate(compensate);
    }

    public Compensate getById(int id) {
        return compensateDAO.getById(id);
    }

    public List<Compensate> list() {
        List<Compensate> compensateList = compensateDAO.list();
        for (Compensate compensate: compensateList) {
            VoucherDetail voucherDetail = voucherDetailService.getById(compensate.getVoucherDetailId());
            compensate.setVoucherDetail(voucherDetail);
            String username = userService.getById(voucherService.getById(voucherDetail.getVoucherId()).getUserId()).getUsername();
            compensate.setUsername(username);
        }
        return compensateList;
    }

}
