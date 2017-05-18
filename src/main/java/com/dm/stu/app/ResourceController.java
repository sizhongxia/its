package com.dm.stu.app;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dm.stu.model.MapResult;

@Controller
@RequestMapping("r.f")
public class ResourceController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	final Logger logger = LoggerFactory.getLogger(ResourceController.class);

	@ResponseBody
	@PostMapping("upload")
	public MapResult upload(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			return new MapResult(1, "未选择文件");
		}
		String fileOriginalName = file.getOriginalFilename();
		logger.info(fileOriginalName);
		long fileSize = file.getSize();
		logger.info(fileSize + "");
		String fileContentType = file.getContentType();
		logger.info(fileContentType);
		String suffixName = fileOriginalName.substring(fileOriginalName.lastIndexOf("."));
		logger.info(suffixName);

		return new MapResult(0, "上传成功", null);
	}

}
