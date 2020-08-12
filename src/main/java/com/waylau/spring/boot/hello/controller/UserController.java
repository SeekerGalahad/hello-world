package com.waylau.spring.boot.hello.controller;

import com.waylau.spring.boot.hello.domain.User;
import com.waylau.spring.boot.hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Wagic
 * @date : 2020/8/11 23:53
 **/
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户列表
     * @return
     */
    private List<User> getUserList() {
        return userService.listAllUsers();
    }

    /**
     * 查询所有用户
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView list(Model model) {
        model.addAttribute("userList", getUserList());
        model.addAttribute("title", "用户管理");
        return new ModelAndView("users/list", "userModel", model);
    }

    /**
     * 根据id查询用户
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getByUserId(id));
        model.addAttribute("title", "查看用户");
        return new ModelAndView("users/view", "userModel", model);
    }

    /**
     * 创建用户表格页面
     * @param model
     * @return
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form", "userModel", model    );
    }

    /**
     * 创建用户，跳转到用户列表
     * @param user
     * @return
     */
    @PostMapping
    public ModelAndView create(User user) {
        user = userService.saveOrUpdateUser(user);
        return new ModelAndView("redirect:/users");
    }

    /**
     * 删除指定用户
     * @param userId
     * @param model
     * @return
     */
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long userId, Model model) {
        userService.deleteUser(userId);
        model.addAttribute("userList", getUserList());
        model.addAttribute("title", "删除用户");
        return new ModelAndView("users/list", "userModel", model);
    }

    /**
     * 修改用户
     * @param userId
     * @param model
     * @return
     */
    @GetMapping("/modify/{id}")
    public ModelAndView modifyForm(@PathVariable("id") Long userId, Model model) {
        User user = userService.getByUserId(userId);
        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("users/form", "userModel", model);
    }

}
