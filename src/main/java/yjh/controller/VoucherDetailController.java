package yjh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import yjh.model.*;
import yjh.service.*;

@Controller
public class VoucherDetailController {

    @Autowired
    private VoucherDetailService voucherDetailService;

    @Autowired
    private CompensateService compensateService;

    @Autowired
    private RewashService rewashService;

    @RequestMapping("rewash")
    @Transactional
    public String rewash(int vdId, int uid) {
        Rewash rewash = new Rewash();
        rewash.setVoucherDetailId(vdId);
        rewash.setUserId(uid);
        rewashService.addRewash(rewash);
        VoucherDetail voucherDetail = new VoucherDetail();
        voucherDetail.setVoucherDetailId(vdId);
        voucherDetail.setIsRewash("正在重洗");
        voucherDetailService.updateVoucherDetail(voucherDetail);
        return "redirect:listVouchers";
    }

    @RequestMapping("compensate")
    @Transactional
    public String compensate(int vdId, int uid) {
        Compensate compensate = new Compensate();
        compensate.setUserId(uid);
        compensate.setVoucherDetailId(vdId);
        compensateService.addCompensate(compensate);
        VoucherDetail voucherDetail = new VoucherDetail();
        voucherDetail.setVoucherDetailId(vdId);
        voucherDetail.setIsCompensate("已赔偿");
        voucherDetailService.updateVoucherDetail(voucherDetail);
        return "redirect:listVouchers";
    }
}
