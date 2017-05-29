package com.dm.stu.util;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

public class QiNiuPictureUtil {
	private static final String AK = "nri3xSSwXuAUWDs2jbnKx7k0hCRE9weZ_Z1rUc8w";
	private static final String SK = "xoaMNfXv55lD__alvcICR_58gRNxWW-nKVB2v6nU";
	private static final String bucket = "sizhongxia-picture-db-1";
	private static final String DEFAULT_HOST_NAME = "http://oqjd1ddq8.bkt.clouddn.com/";
	private static final String DEFAULT_STYLE = "?imageView2/1/w/520/h/520/q/100|imageslim";

	// FjtK4DhNEMlyJnibC6JpektcQxxb
	public static String getImageUrl(String fileName) {
		return DEFAULT_HOST_NAME + fileName + DEFAULT_STYLE;
	}
	// http://oqjd1ddq8.bkt.clouddn.com/FjtK4DhNEMlyJnibC6JpektcQxxb

	public static void main(String[] args) {
		Auth auth = Auth.create(AK, SK);
		
		String upToken = auth.uploadToken(bucket);
		System.out.println(upToken);
		
		

		Configuration cfg = new Configuration(Zone.zone1());

		UploadManager uploadManager = new UploadManager(cfg);

		String localFilePath = "G:\\照片视频\\个人图片\\IMG_20131006_173200.jpg";

		String key = null;
		try {
			Response response = uploadManager.put(localFilePath, key, upToken);

			DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);

			System.out.println(putRet.hash);
			System.out.println(putRet.key);

		} catch (QiniuException e) {
			e.printStackTrace();
			Response r = e.response;
			System.err.println(r.toString());
			try {
				System.err.println(r.bodyString());
			} catch (QiniuException ex2) {
			}
		}
	}

}
