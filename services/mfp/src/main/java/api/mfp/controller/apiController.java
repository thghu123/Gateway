package api.mfp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class apiController {

    @GetMapping(value="/mfp/rtm/slowquery")
    public HashMap<String, String> slowQueryApi(){
        HashMap<String, String> map = new HashMap<>();

        map.put("query","select * from USERROLE");
        map.put("pid","489");

        return map;
    }

}
