package yjh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import yjh.model.*;
import yjh.service.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ClothesController {

    @Autowired
    private ClothesService clothesService;
    @Autowired
    private UserService userService;
    @Autowired
    private VoucherService voucherService;
    @Autowired
    private VoucherDetailService voucherDetailService;

    @RequestMapping("getClothesPage")
    public String getClothesPage(int num, Model model) {
        model.addAttribute("num", num);
        return "admin/getClothesPage";
    }

    @RequestMapping("getClothes")
    @Transactional
    public String getClothes(String username, String[] clothesName, String[] brand, String[] color, String[] flaw, String[] serverName, Double[] washPrice) {
        List<Clothes> clothes = new ArrayList<>();
        List<VoucherDetail> voucherDetails = new ArrayList<>();
        Voucher voucher = new Voucher();
        User user = userService.getByName(username);
        voucher.setUserId(user.getUserId());
        voucherService.addVoucher(voucher);
        double totalPrice = 0;
        for (int i = 0; i < clothesName.length; ++i) {
            Clothes c = new Clothes();
            VoucherDetail v = new VoucherDetail();
            c.setClothesName(clothesName[i]);
            c.setBrand(brand != null && brand.length > 0 ? brand[i] : "");
            c.setColor(color != null && color.length > 0 ? color[i] : "");
            c.setFlaw(flaw[i]);
            clothesService.addClothes(c);
            v.setWashPrice(washPrice[i]);
            v.setServerName(serverName[i]);
            v.setClothesId(c.getClothesId());
            v.setVoucherId(voucher.getVoucherId());
            voucherDetailService.addVoucherDetail(v);
            totalPrice += washPrice[i];
        }
        user.setConsumeTimes(user.getConsumeTimes() + 1);
        user.setTotalConsume(user.getTotalConsume() + totalPrice);
        userService.updateUser(user);
        voucher.setPrice(totalPrice);
        voucherService.updateVoucher(voucher);
        return "redirect:listVouchers";
    }


}
