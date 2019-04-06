package yjh.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import yjh.model.Info;
import yjh.service.InfoService;
import yjh.util.Page;

import java.util.List;

@Controller
public class InfoController {

    @Autowired
    private InfoService infoService;

    @RequestMapping("/listInfos")
    public String listInfos(Page page, Model model) {
        page.setCount(10);
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Info> infos = infoService.list();
        int total = (int) new PageInfo<>(infos).getTotal();
        page.setTotal(total);
        model.addAttribute("infos", infos);
        model.addAttribute("page", page);
        return "listInfos";
    }

    @RequestMapping("addInfo")
    public String addInfo(Info info) {
        infoService.addInfo(info);
        return "redirect:adminHome";
    }

    @RequestMapping("deleteInfo")
    public String deleteInfo(int infoId) {
        infoService.deleteById(infoId);
        return "redirect:adminHome";
    }

    @RequestMapping("editInfoPage")
    public String editInfoPage(int infoId, Model model) {
        Info info = infoService.getById(infoId);
        model.addAttribute("info", info);
        return "admin/editInfo";
    }

    @RequestMapping("editInfo")
    public String editInfo(Info info, Model model) {
        infoService.updateById(info);
        model.addAttribute("info", info);
        return "admin/editInfo";
    }
}
