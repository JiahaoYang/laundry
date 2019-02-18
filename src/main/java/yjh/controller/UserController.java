package yjh.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;
import yjh.model.Info;
import yjh.model.User;
import yjh.service.InfoService;
import yjh.service.UserService;
import yjh.util.Page;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private InfoService infoService;

    @RequestMapping({"/registerPage", "/loginPage"})
    public String loginPage() {
        return "loginPage";
    }


    @RequestMapping("/register")
    public String register(User user, Model model) {
        int cnt = userService.addUser(user);
        if (cnt > 0) {
            return "";
        }
        else {
            model.addAttribute("user", null);
            return "loginPage";
        }
    }


    @RequestMapping("/checkName")
    @ResponseBody
    public String checkName(String username) {
        boolean exist = userService.isExist(username);
        if (exist)
            return "exist";
        return "";
    }


    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session, Model model) {
        username = HtmlUtils.htmlEscape(username);
        password = HtmlUtils.htmlEscape(password);
        User user = userService.login(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            if (user.getUserType().equals("会员"))
                return "";
            else
                return "redirect:adminHome";
        }
        model.addAttribute("msg", "用户名或密码错误");
        return "loginPage";
    }

    @SuppressWarnings("Duplicates")
    @RequestMapping("/adminHome")
    public String adminHome(Page page, Model model) {
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Info> infos = infoService.list();
        int total = (int) new PageInfo<>(infos).getTotal();
        page.setTotal(total);
        model.addAttribute("infos", infos);
        model.addAttribute("page", page);
        return "admin/listInfos";
    }

}
