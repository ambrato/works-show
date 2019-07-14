package top.ambrat.ws.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class Upload {

	/** 处理上传的方法 **/
    public static String saveFile(MultipartFile multipartFile,String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String originFileName = multipartFile.getOriginalFilename();   
        //System.out.println(originFileName);
        String exName = originFileName.split("\\.")[1];
        //System.out.println(exName);
        FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
        String fileName = UUID.randomUUID().toString() + "." + exName;
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + File.separator + fileName));
        byte[] bs = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bs)) != -1) {
            bos.write(bs, 0, len);
        }
        bos.flush();
        bos.close();
        return fileName;
    }
    
    
    public static WsResult upload(MultipartFile multipartFile, String location) {
    	WsResult result = new WsResult();
		if (multipartFile.isEmpty() || StringUtils.isEmpty(multipartFile.getOriginalFilename())) {
				result.setStatus(1);
				result.setMsg(WsConstant.UPDATE_IMG_ERROR1_MSG);
				return result;
	    }
        String contentType = multipartFile.getContentType();
        if (!contentType.contains("")) {
        	result.setStatus(2);
			result.setMsg(WsConstant.UPDATE_IMG_ERROR1_MSG);
			return result;
        }
        
        //String root_fileName = multipartFile.getOriginalFilename();
        //System.out.println(root_fileName);
        
        //logger.info("上传图片:name={},type={}", root_fileName, contentType);
        //处理图片
        //User currentUser = mapper.selectNkNameAndImageByPrimaryKey(userId);
        //获取路径
       
        
        String file_name = null;
       
        try {
            file_name = saveFile(multipartFile, location);
           
            if(StringUtils.isEmpty(file_name)){
            	result.setStatus(3);
            	result.setMsg(WsConstant.UPDATE_IMG_ERROR1_MSG);
            	return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    result.setStatus(WsConstant.SUCCESS);
	result.setMsg("上传成功");
	result.setData(file_name);
	return result;
	}
    
}
