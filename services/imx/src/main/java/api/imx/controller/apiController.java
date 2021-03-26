package api.imx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class apiController {

    @GetMapping(value="/imx/rtm/slowquery")
    public HashMap<String, String> slowQueryApi(){
        HashMap<String, String> map = new HashMap<>();

        map.put("query","select * from user");
        map.put("pid","536");

        return map;
    }

}
