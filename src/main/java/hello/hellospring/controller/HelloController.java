package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // 처음 사용해본거
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc") // 소스가 전부 넘어간다.
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
    @GetMapping("hello-string") // 문자가 그대로 , 즉 데이터를 그대로 전달한다.
    @ResponseBody // < - 이걸 사용한다
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // "hello minhyuuk"
    }
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name); // 파라미터 값 넘기기
        return hello; // 객체 넘기기

        // 실행결과, {"name" : "spring!!!!"} < - json 방식
        // json 방식 : key value
        // 객체를 적고 responsebody를 적으면 그냥 기본으로 json 방식으로 진행된다고 한다.

    }
    static class Hello{ // 게터 세터, 프로퍼티 접근 방식이라고도 한당
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

