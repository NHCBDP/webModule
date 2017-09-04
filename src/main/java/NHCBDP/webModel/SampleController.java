package NHCBDP.webModel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wbliu
 * @create 2017-09-01 16:01
 **/


@Controller
@EnableAutoConfiguration
public class SampleController {



    @RequestMapping("/test")
    @ResponseBody
    String home() {
        return "this is my  spring-boot project!";
    }


   /* public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }*/
}