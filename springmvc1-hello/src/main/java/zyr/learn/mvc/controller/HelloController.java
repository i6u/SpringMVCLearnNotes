package zyr.learn.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by zhouweitao on 2016/11/19.
 */
@Controller
public class HelloController {


    /**
     * @RequestParam 值验证，意思是此参数必须存在，如果这个请求没有这个值回报400错误
     * */
    @RequestMapping({"hello","abc"})
    public String hello(@RequestParam String name, Map<String,Object> context, Model model) {
        System.out.println("hello controller..."+name);
        model.addAttribute("model", name);
        context.put("username", name);
        return "hello";
    }

    @RequestMapping("")
    public String param() {
        return "hello";
    }
}
