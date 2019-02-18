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
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Info> infos = infoService.list();
        int total = (int) new PageInfo<>(infos).getTotal();
        page.setTotal(total);
        model.addAttribute("infos", infos);
        model.addAttribute("page", page);
        return "listInfos";
    }
}
