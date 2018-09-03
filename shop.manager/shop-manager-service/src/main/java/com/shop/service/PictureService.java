package com.shop.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface PictureService {
	public Map uploadPicture(MultipartFile uploadFile) throws IOException ;
}
