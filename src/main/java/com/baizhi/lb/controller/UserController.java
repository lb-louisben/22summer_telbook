package com.baizhi.lb.controller;


import com.baizhi.lb.entity.User;
import com.baizhi.lb.service.UserService;
import com.baizhi.lb.util.SecurityCode;
import com.baizhi.lb.util.SecurityImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public String signIn(String username, String password, String clientCode, HttpSession session) {
        String code = session.getAttribute("code").toString();

        if (clientCode.equals(code)) {
            User user = userService.queryByName(username);
            if (user == null) {
                // 用户不存在
                return "redirect:/login.jsp";
            } else {
                if (password.equals(user.getPassword())) {
                    // 密码正确
                    session.setAttribute("user", user);
                    return "redirect:/main/main.jsp";
                } else
                    // 密码不正确
                    return "redirect:/login.jsp";
            }
//            return "forward:/main/main.jsp";
        } else {
            // 验证码不正确
            return "redirect:/login.jsp";
        }
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        // 清空 Session

        session.removeAttribute("user");

        return "redirect:/login.jsp";
    }

    @RequestMapping("createImg")
    public void createImg(HttpServletResponse response, HttpSession session) throws Exception {
        String code = SecurityCode.getSecurityCode();
        session.setAttribute("code", code);
        System.out.println(code);
        // 生成缓冲区
        BufferedImage bufferedImage = SecurityImage.createImage(code);
        // 输出到client
        ImageIO.write(bufferedImage, "png", response.getOutputStream());
    }
}

