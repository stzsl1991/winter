package com.shulin.winter.login;

import com.shulin.winter.dao.manager.UserDao;
import com.shulin.winter.entity.manager.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by shulin on 16/12/21.
 */
@Controller
@Slf4j
@RequestMapping("/winter")
public class LoginController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/login")
    public String teset(Long id, Model model) {
        User user = userDao.selectById(id);
        model.addAttribute("user", user);
        return "showUser";
    }

}
