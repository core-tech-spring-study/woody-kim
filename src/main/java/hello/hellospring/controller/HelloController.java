package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello/*")
public class HelloController {
    /* hello */
    @GetMapping(path = "test1")
    public String hello(Model model) {
        model.addAttribute("data", "hello1");

        return "hello";
    }

    /* hello mvc */
    @GetMapping(path = "test2")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("data", name);

        return "helloMvc";
    }

    @GetMapping(path = "test3")
    @ResponseBody
    public String helloString(@RequestParam String name, Model model)
    {
        return "hello" + name;
    }

    @GetMapping(path="/test4")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name)
    {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}

