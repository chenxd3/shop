package com.shop.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shop.common.utils.FtpUtil;
import com.shop.common.utils.IDUtils;
import com.shop.service.PictureService;

/**
 * 图片上传服务
 * @author chenxd
 */
@Service
public class PictureServiceImpl implements PictureService {

	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;
	@Value("${FTP_PORT}")
	private int FTP_PORT;
	@Value("${FTP_USERNAME}")
	private String FTP_USERNAME;
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;
	@Value("${FTP_BASE_PATH}")
	private String FTP_BASE_PATH;
	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;
	
	
	
	@Override
	public Map uploadPicture(MultipartFile uploadFile) throws IOException {
		Map resultMap = new HashMap();
		try {
			// 取原文件名
			String oldName = uploadFile.getOriginalFilename();
			//生成新文件名
			String newName = IDUtils.genImageName();
			
			newName = newName + oldName.substring(oldName.lastIndexOf("."));
			
			String imagePath = new DateTime().toString("/yyyy/MM/dd");
			
			boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASE_PATH, imagePath,
					newName, uploadFile.getInputStream());
			
			
			if(!result){
				resultMap.put("error", 1);
				resultMap.put("message", "文件上传失败");
			}
			resultMap.put("error", 0);
			resultMap.put("url", IMAGE_BASE_URL + imagePath + "/" + newName);
			return resultMap;
		} catch (Exception e) {
			resultMap.put("error", 1);
			resultMap.put("message", "文件上传出错");
			return resultMap;
		}
	}

}
