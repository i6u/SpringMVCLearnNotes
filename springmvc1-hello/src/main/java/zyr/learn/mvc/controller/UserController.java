package zyr.learn.mvc.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zyr.learn.mvc.model.User;
import zyr.learn.mvc.model.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhouweitao on 2016/11/19.
 */

@Controller
@RequestMapping("/user")
public class UserController {
    private Map<String, User> users = new HashMap<>();

    public UserController() {
        users.put("1", new User(1, "zhao", "123456", "zhao@china.cn"));
        users.put("2", new User(2, "qian", "123456", "qian@china.cn"));
        users.put("3", new User(3, "song", "123456", "song@china.cn"));
        users.put("4", new User(4, "li", "123456", "li@china.cn"));
        users.put("5", new User(5, "wang", "123456", "wang@china.cn"));
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("users", users);
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
            //System.out.println("getName:"+attachs.getName());
            //System.out.println("getContentType:"+attachs.getContentType());
            //System.out.println("getOriginalFilename:"+attachs.getOriginalFilename());
            //System.out.println("getSize:"+attachs.getSize());

            String realPath = request.getSession().getServletContext().getRealPath("/upload");
            for (MultipartFile attach : attachs) {
                if (attach.isEmpty()) continue;
                File file = new File(realPath + "/" + attach.getOriginalFilename());
                FileUtils.copyInputStreamToFile(attach.getInputStream(), file);
            }
            int count = users.size();
            user.setId(count + 1);
            users.put(String.valueOf(count + 1), user);
            return "redirect:list";
        }
    }

    /**
     *
     * spring mvc中使用@PathVariable使参数可以作为请求地址的一部分
     * */
    @RequestMapping(value = "/{uid}", method = RequestMethod.GET)
    public String show(@PathVariable String uid, Model model) {
        model.addAttribute(users.get(uid));
        return "user/show";
    }


    /**
     * spring mvc 返回json数据
     */

    @RequestMapping(value = "/{uid}", method = RequestMethod.GET, params = "json")
    @ResponseBody
    public User show(@PathVariable String uid) {
        return users.get(uid);
    }


    @RequestMapping(value = "/{uid}/update", method = RequestMethod.GET)
    public String update(@PathVariable String uid, Model model) {
        model.addAttribute(users.get(uid));
        return "user/update";
    }

    @RequestMapping(value = "/{uid}/update", method = RequestMethod.POST)
    public String update(@Validated User user, BindingResult br, @PathVariable String uid) {
        if (br.hasErrors()) {
            return "user/update";
        } else {
            users.remove(uid, user);
            System.out.println(uid);
            users.put(uid, user);
            return "redirect:/user/list";
        }
    }

    @RequestMapping(value = "/delete/{uid}", method = RequestMethod.GET)
    public String delete(@PathVariable String uid) {
        users.remove(uid);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password, HttpSession session) {
        User user = null;
        for (Object o : users.keySet()) {
            if (username.equals(users.get(o).getUsername())) {
                user = users.get(o);
            }
        }
        if (user == null) {
            throw new UserException("用户不存在");
        }
        if (!password.equals(user.getPassword())) {
            throw new UserException("用户密码错误");
        }
        session.setAttribute("loginUser", user);
        return "redirect:/user/list";
    }


    /**
     *
     * 处理本内中的异常
     * */
    //
    //@ExceptionHandler(UserException.class)
    //public String handlerException(UserException e, HttpServletRequest request) {
    //    request.setAttribute("e", e);
    //    return "error";
    //}
}
