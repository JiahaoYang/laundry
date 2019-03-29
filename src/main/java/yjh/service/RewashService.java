package yjh.service;

import org.springframework.stereotype.Service;
import yjh.dao.RewashDAO;
import yjh.model.Rewash;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Service
public class RewashService {

    @Resource
    private RewashDAO rewashDAO;

    public int addRewash(Rewash rewash) {
        return rewashDAO.addRewash(rewash);
    }

    public Rewash getById(int id) {
        return rewashDAO.getById(id);
    }

    public int updateRewash(LocalDateTime takeDate, int vdId) {
        return rewashDAO.updateRewash(takeDate, vdId);
    }

}
