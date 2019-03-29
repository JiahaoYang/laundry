package yjh.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import yjh.model.*;
import yjh.service.*;
import yjh.util.Page;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class VoucherController {

    @Autowired
    private VoucherService voucherService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private VoucherDetailService voucherDetailService;

    @RequestMapping("listVouchers")
    public String listVouchers(Model model, Page page) {
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Voucher> vouchers = voucherService.list();
        int total = (int) new PageInfo<>(vouchers).getTotal();
        page.setTotal(total);
        model.addAttribute("vouchers", vouchers);
        model.addAttribute("page", page);
        return "admin/listVouchers";
    }

    @RequestMapping("informTakeClothes")
    @Transactional
    public String informTakeClothes(int voucherId, int userId) {
        Message message = new Message();
        message.setUserId(userId);
        message.setMessage("通知取衣");
        messageService.addMessage(message);
        Voucher voucher = new Voucher();
        voucher.setVoucherId(voucherId);
        voucher.setState("洗衣完成");
        voucherService.updateVoucher(voucher);
        return "redirect:listVouchers";
    }

    @RequestMapping("completeVoucher")
    @Transactional
    public String completeVoucher(int voucherId) {
        Voucher voucher = new Voucher();
        voucher.setState("订单完成");
        voucher.setVoucherId(voucherId);
        voucher.setTakeDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        voucherService.updateVoucher(voucher);
        voucherDetailService.updateByVoucher(voucherId);
        return "redirect:listVouchers";
    }

    @RequestMapping("informRewash")
    @Transactional
    public String informRewash(int vdId, int userId) {
        Message message = new Message();
        message.setUserId(userId);
        message.setMessage("重洗完成");
        messageService.addMessage(message);
        VoucherDetail voucherDetail = new VoucherDetail();
        voucherDetail.setIsRewash("重洗完成");
        voucherDetail.setVoucherDetailId(vdId);
        voucherDetailService.updateVoucherDetail(voucherDetail);
        return "redirect:listVouchers";
    }
}
