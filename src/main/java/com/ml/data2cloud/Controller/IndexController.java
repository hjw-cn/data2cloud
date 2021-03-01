package com.ml.data2cloud.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hanjiawei
 * @date 2021-03-01
 */
@Controller
public class IndexController {
    @RequestMapping("uploadExcel")
    public String uploadExcel(){
        return "/uploadExcel.html";
    }
}
