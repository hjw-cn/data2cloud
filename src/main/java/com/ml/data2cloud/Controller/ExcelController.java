package com.ml.data2cloud.Controller;

import com.ml.data2cloud.pojo.Test;
import com.ml.data2cloud.service.TestService;
import com.ml.data2cloud.util.ParseExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.transform.Result;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @author hanjiawei
 * @date 2021-03-01
 */
@RestController
public class ExcelController {

    @Autowired
    TestService testService;

    @GetMapping("hello")
    private String hello() {
        return "hello";
    }

    @PostMapping("/upload")
    public Result importAlumnis(@RequestParam(value = "alumniData") MultipartFile file) throws IOException {
        InputStream inputStream = null;
        try {
            //输入流
            inputStream = file.getInputStream();
            //原始文件名
            String originalFilename = file.getOriginalFilename();
            //文件后缀
            String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            System.out.println("suffix = " + suffix);
            ParseExcel parser = new ParseExcel();
            //第三行开始读取
            int startRow = 0;
            List<String[]> result = parser.parseExcel(inputStream, suffix, startRow);
            System.out.println("result" + result.toString());
            Test test = null;
            int count = 0;
            for (String[] ss : result) {
                System.out.println(Arrays.toString(ss));

                test = new Test();
                test.setA(ss[0]);
                test.setB(ss[1]);

                //导入校友信息进入数据库
//                int i = testService.addTestData(test);
//                if(i==1){
//                    count++;
//                }
                System.out.println("===============================");
                System.out.println(test.toString());
                System.out.println("===============================");
            }

//            if(count==result.size()){
//                //全部数据导入成功
//                return Result.ok("全部数据导入成功");
//            }
//            return Result.ok("部分数据导入成功");

        } catch (IOException e) {
            e.printStackTrace();
//            return Result.error("导入数据失败");
        } finally {
            //关闭流
            inputStream.close();
        }
        return null;
    }

}
