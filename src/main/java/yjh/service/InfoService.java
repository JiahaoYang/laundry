package yjh.service;

import org.springframework.stereotype.Service;
import yjh.dao.InfoDAO;
import yjh.model.Info;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InfoService {

    @Resource
    private InfoDAO infoDAO;

    public List<Info> list() {
        return infoDAO.list();
    }

    public int addInfo(Info info) {
        return infoDAO.addInfo(info);
    }

    public int deleteById(int infoId) {
        return infoDAO.deleteById(infoId);
    }


    public int updateById(Info info) {
        return infoDAO.updateById(info);
    }

    public Info getById(int infoId) {
        return infoDAO.getById(infoId);
    }
}
