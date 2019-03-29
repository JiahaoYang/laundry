package yjh.service;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import yjh.dao.CompensateDAO;
import yjh.model.Compensate;

import javax.annotation.Resource;

@Service
public class CompensateService {

    @Resource
    private CompensateDAO compensateDAO;


    public int addCompensate(Compensate compensate) {
        return compensateDAO.addCompensate(compensate);
    }

    public Compensate getById(int id) {
        return compensateDAO.getById(id);
    }

}
