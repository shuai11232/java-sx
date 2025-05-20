package com.sx.guanli.pojo;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 远程COS对象存储客户端工厂类
 */
@Component
public class CosClientFactory {

    private static String secretId;
    private static String secretKey;
    private static String region;

    @Value("${COS.secretId}")
    public void setSecretId(String secretId) {
        CosClientFactory.secretId = secretId;
    }

    @Value("${COS.secretKey}")
    public void setSecretKey(String secretKey) {
        CosClientFactory.secretKey = secretKey;
    }

    @Value("${COS.region}")
    public void setRegion(String region) {
        CosClientFactory.region = region;
    }

    // 创建 COSClient 实例
    public static COSClient createCOSClient() {
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.setRegion(new Region(region));
        return new COSClient(cred, clientConfig);
    }
}