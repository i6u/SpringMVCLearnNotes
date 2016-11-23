package zyr.learn.springmvc.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zyr.learn.springmvc.exception.UserException;
import zyr.learn.springmvc.model.User;
import zyr.learn.springmvc.service.IUserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * Created by zhouweitao on 2016/11/22.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("users", userService.queryUser());
        return "user/list";
    }


    /**
     * 因为要跳转的页面使用到了spring form标签，需要对数据进行提前绑定
     * <p>
     * 1.在参数中添加 @ModelAttribute User user
     * 2.直接在参数中 添加 User user
     * 3.在参数中添加 Model model，通过model.addAttribute(new User())
     * Neither BindingResult nor plain target object for bean name 'user' available as request attribute
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(@ModelAttribute User user) {
        return "user/add";
    }

    /**
     *
     * spring mvc中使用@Validated
     *
     *
     * 当需要一次上传多个文件的时候，需要使用@RequestParam对参数进行声明，不然回报NoSuchMethodException异常，应为参数使用了数组，spring不能自动进行转换
     * */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@Validated User user, BindingResult br, @RequestParam MultipartFile[] attachs, HttpServletRequest request) throws IOException {
        if (br.hasErrors()) {
            return "user/add";
        } else {
            String realPath = request.getSession().getServletContext().getRealPath("/upload");
            for (MultipartFile attach : attachs) {
                if (attach.isEmpty()) continue;
                File file = new File(realPath + "/" + attach.getOriginalFilename());
                FileUtils.copyInputStreamToFile(attach.getInputStream(), file);
            }
            userService.create(user);
            return "redirect:list";
        }
    }

    /**
     *
     * spring mvc中使用@PathVariable使参数可以作为请求地址的一部分
     * */
    @RequestMapping(value = "/{uid}", method = RequestMethod.GET)
    public String show(@PathVariable String uid, Model model) {
        model.addAttribute(userService.queryById(uid));
        return "user/show";
    }


    /**
     * spring mvc 返回json数据
     */

    @RequestMapping(value = "/{uid}", method = RequestMethod.GET, params = "json")
    @ResponseBody
    public User show(@PathVariable String uid) {
        return userService.queryById(uid);
    }


    @RequestMapping(value = "/{uid}/update", method = RequestMethod.GET)
    public String update(@PathVariable String uid, Model model) {
        model.addAttribute(userService.queryById(uid));
        return "user/update";
    }

    @RequestMapping(value = "/{uid}/update", method = RequestMethod.POST)
    public String update(@Validated User user, BindingResult br, @PathVariable String uid) {
        if (br.hasErrors()) {
            return "user/update";
        } else {
            userService.update(user);
            return "redirect:/user/list";
        }
    }

    @RequestMapping(value = "/delete/{uid}", method = RequestMethod.GET)
    public String delete(@PathVariable String uid) {
        userService.delete(uid);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password, HttpSession session) {
        User user = userService.login(username, password);
        if (user != null) {
            session.setAttribute("loginUser", user);
        } else {
            throw new UserException("用户不存在");
        }
        return "redirect:/user/list";
    }

}