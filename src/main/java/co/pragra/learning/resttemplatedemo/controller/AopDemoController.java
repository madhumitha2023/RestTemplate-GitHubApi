package co.pragra.learning.resttemplatedemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AopDemoController {
    @GetMapping("/aop")
    public String getStatus(){
        log.info("AopDemoController::getStatus");
        return "Success";
    }
}
