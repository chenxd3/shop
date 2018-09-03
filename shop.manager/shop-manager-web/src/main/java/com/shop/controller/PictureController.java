package com.shop.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shop.service.PictureService;

@Controller
@RequestMapping("/pic")
public class PictureController {
	
	@Autowired
	private PictureService pictureService;

	@RequestMapping("/upload")
	@ResponseBody
	public Map uploda(MultipartFile uploadFile) throws Exception {
		//调用service上传图片
		//PictureResult pictureResult = (PictureResult) pictureService.uploadPicture(uploadFile);
		Map result =  pictureService.uploadPicture(uploadFile);
		//返回上传结果
		return result;
		
	}
}

