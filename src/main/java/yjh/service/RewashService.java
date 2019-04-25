package yjh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yjh.dao.RewashDAO;
import yjh.model.Rewash;
import yjh.model.VoucherDetail;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RewashService {

    @Resource
    private RewashDAO rewashDAO;
    @Autowired
    private UserService userService;

    @Autowired
    private VoucherDetailService voucherDetailService;

    @Autowired
    private VoucherService voucherService;

    public int addRewash(Rewash rewash) {
        return rewashDAO.addRewash(rewash);
    }

    public Rewash getById(int id) {
        return rewashDAO.getById(id);
    }

    public int updateRewash(LocalDateTime takeDate, int vdId) {
        return rewashDAO.updateRewash(takeDate, vdId);
    }

    public List<Rewash> list() {
        List<Rewash> rewashList = rewashDAO.list();
        for (Rewash rewash: rewashList) {
            VoucherDetail voucherDetail = voucherDetailService.getById(rewash.getVoucherDetailId());
            rewash.setVoucherDetail(voucherDetail);
            String username = userService.getById(voucherService.getById(voucherDetail.getVoucherId()).getUserId()).getUsername();
            rewash.setUsername(username);
        }
        return rewashList;
    }

}
