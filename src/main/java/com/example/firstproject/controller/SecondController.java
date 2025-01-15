package com.example.firstproject.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SecondController {
    @GetMapping("/random-quote")
    public String randomQuote(Model model) {
        String[] quotes = {
                "행복은 습관이다. 그것을 몸에 지니라." +
                        "-허버드-",
                "고개를 숙이지마세요, 세상을 똑바로 정면으로 " +
                        "바라보십시오. - 헬렌 켈러-",
                "작은 기회로부터 종종 위대한 업적이 시작된다. " +
                        "-데모스테네스-"
        };
        int randInt = (int) (Math.random() * quotes.length);
        model.addAttribute("randomQuote", quotes[randInt]);
        return "quote";
    }
}
