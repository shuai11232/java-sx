package com.sx.guanli.common;


import com.qcloud.cos.COSClient;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.model.StorageClass;
import com.sx.guanli.pojo.CosClientFactory;
import org.springframework.beans.factory.annotation.Value;


import java.io.IOException;
import java.io.InputStream;

/**
 *   COS对象存储发送工具类
 */


public class CosUtil {
    private static String bucketName;
    @Value("${COS.bucketName}")
    public void setSecretId(String bucketName) {
        CosUtil.bucketName = bucketName;
    }
    public static String upload(InputStream input,String filename) throws IOException {
        COSClient cosClient = CosClientFactory.createCOSClient();
// 存储桶的命名格式为 BucketName-APPID，此处填写的存储桶名称必须为此格式
// 对象键(Key)是对象在存储桶中的唯一标识。
        ObjectMetadata metadata=new ObjectMetadata();
        metadata.setContentLength(input.available());

        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, filename, input,metadata);

        putObjectRequest.setStorageClass(StorageClass.Standard_IA);

        try {
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        } catch (CosServiceException e) {
            e.printStackTrace();
        } catch (CosClientException e) {
            e.printStackTrace();
        }
// 确认本进程不再使用 cosClient 实例之后，关闭即可
        cosClient.shutdown();
        return "System.out.println(putObjectResult.getRequestId());";
    }
}
