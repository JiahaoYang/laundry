package yjh.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String register(User user, Model model, HttpSession session) {
        int cnt = userService.addUser(user);
        if (cnt > 0) {
            session.setAttribute("user", user);
            return "";
        } else {
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

    @RequestMapping("/checkName_")
    @ResponseBody
    public String checkName_(String username, String oldName) {
        User user = userService.getByName(username);
        if (user != null && !(user.getUsername().equals(oldName)))
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
                return "redirect:userHome";
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

    @RequestMapping("userHome")
    public String userHome(Page page, Model model) {
        page.setTotal(10);
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Info> infos = infoService.list();
        int total = (int) new PageInfo<>(infos).getTotal();
        page.setTotal(total);
        model.addAttribute("infos", infos);
        model.addAttribute("page", page);
        return "user/userHome";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.setAttribute("user", null);
        return "redirect:listInfos";
    }

    @RequestMapping("user")
    public String editUserPage(int userId, Model model) {
        User user = userService.getById(userId);
        model.addAttribute("user", user);
        if (user.getUserType().equals("管理员"))
            return "admin/editUser";
        return "user/editUser";
    }

    @RequestMapping("editUser")
    public String editUser(User user, Model model, HttpSession session) {
        userService.updateUser(user);
        model.addAttribute("user", user);
        session.setAttribute("user", user);
        return "redirect:user?userId=" + user.getUserId();
    }

    @RequestMapping("editPassword")
    public String editPassword(String password, String username) {
        userService.updatePassword(username, password);
        return "admin/editUser";
    }

    @RequestMapping("checkPassword")
    @ResponseBody
    public String checkPassword(String username, String password) {
        User user = userService.login(username, password);
        if (user != null)
            return "";
        return "wrong";
    }

    @RequestMapping("listUsers")
    public String listUsers(Model model, Page page) {
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<User> users = userService.list();
        int total = (int) new PageInfo<>(users).getTotal();
        page.setTotal(total);
        model.addAttribute("users", users);
        model.addAttribute("page", page);
        return "admin/listUsers";
    }

    @RequestMapping("checkExist")
    @ResponseBody
    public String checkExist(String username) {
        User user = userService.getByName(username);
        return user == null ? "unknown" : "";
    }
}
