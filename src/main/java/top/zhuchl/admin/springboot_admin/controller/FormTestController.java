package top.zhuchl.admin.springboot_admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Author AlphaZcl
 * @Date 2021/10/28
 **/
@Controller
@RequestMapping("admin")
@Slf4j
public class FormTestController {

    @GetMapping("getFormLayouts")
    public String formLayouts(){
        return "form/form_layouts";
    }

    @RequestMapping("upload")
    public String uploadFile(@RequestParam String email,
                             @RequestParam String username,
                             @RequestPart("headImg") MultipartFile file,
                             @RequestParam("lives") MultipartFile[] mFiles) throws IOException {
        log.info("上传的信息：email:{},username:{},headImg:{},mFiles:{}",email,username,file.getSize(),mFiles.length);
        if(!file.isEmpty()){
            String filename = file.getOriginalFilename();
            file.transferTo(new File("E:\\zcl_work\\testLocalFile\\"+filename));
        }

        if(mFiles.length>0){
            for (MultipartFile mf: mFiles) {
                if(!mf.isEmpty()){
                    String originalFilename = mf.getOriginalFilename();
                    mf.transferTo(new File("E:\\zcl_work\\testLocalFile\\"+originalFilename));
                }
            }
        }
        return "main";
    }
}
