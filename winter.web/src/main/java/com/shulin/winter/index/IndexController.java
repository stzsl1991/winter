package com.shulin.winter.index;

import com.shulin.winter.common.Result;
import com.shulin.winter.dao.manager.UserDao;
import com.shulin.winter.entity.manager.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 业务：权限验证，登录，登出，注册...
 * Created by shulin on 16/12/21.
 */
@Controller
@Slf4j
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private UserDao userDao;


    /**
     * 跳转到登录界面
     * URL：http://localhost:8083/winter/index
     *
     * @return
     */
    @RequestMapping("")
    public String toLoginPage() {
        return "index";
    }

    @RequestMapping("/test")
    public String teset(Long id, Model model) {
        log.info("id={}", id);
        User user = userDao.selectById(id);
        model.addAttribute("user", user);
        return "showUser";
    }


    @RequestMapping(value = "/login", produces = {"application/json"})
    @ResponseBody
    public Result userLogin(String username, String pwd) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(pwd)) {
            return Result.wrapErrorResult("", "用户名和密码不能为空！");
        }
        Map<String, Object> params = new HashMap<>();
        params.put("userName", username);
        params.put("userPassword", pwd);
        List<User> userList = userDao.select(params);
        if (!CollectionUtils.isEmpty(userList)) {
            return Result.wrapSuccessfulResult("登录成功！");
        }
        return Result.wrapErrorResult("", "登录失败！");
    }

}
