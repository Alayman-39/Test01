package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016093000629886";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEwAIBADANBgkqhkiG9w0BAQEFAASCBKowggSmAgEAAoIBAQCIw0/YWJfd+tCFJuYm2zO0sjEqZ9uAl4dLO9VPxOAqOH2oee89VTCvzVsYeVZljvVfm4xoW1Ola0jwg4MIjYGB3uvwsWIxEZfFgRYKRcQXkwXDWoRTD3iiANE5L/YdiLpKmwLq80Zr+zmLvicMrL7ST8H1ayDvYEGHqaNs2VeFY0xkgo8dOTymX0WtrnbYZ23famQpGa+jwRZnmYsG4STPOgiXDv8OYYdg6KhEavmycKtbSuRiUCOToM8ytBB1QYuW+t1XwATA5LzXAdpXbeHLqJJuD2gMrEZQmuShii/lPPQ2K7qLM0hmSwbgobwfRS+4OcXJYv3UKo3VbCh/7IbjAgMBAAECggEBAIe0/trX9kJvqlAl7ETsSF9qXj0M95OfSMIPqjhQTHu4uH/gFtROX1RjOpyLcn6uH69yQx4eWV8QmT0H0pM/Dx5WnNqmuZ+lLGvwDnW9Crq1ygcyH5HoDTT8CKBthhOCZBC5xmhrZBqsHEsdMdRy6Zr5R6aGWhUN95htbVwKQr149Gk6VPiVMrnkbHxQjuJ6cps3QunF8bYRKSsKN/PU50YoVISiACzrXlS5uGqB49BoFkuY0ip7d9kUUc3JTAPSeeDIRS+5wgL7DIzfiZWaIf5APstCJvioxVHRbuMF6XOJWm0R5Awq/LuJol8yeA3ff62G+JrcFDDHOaxw6eOk8MkCgYEA4Nnacf3a9U1X2L6w964TGWgT4vVABMpNPRxxTTwvedm+ymNrt4LT4/BaRSZ+jSfgNExFRo70f6fUBVdphnJRJEM/ZR0c5jMR6N6Qt3qbOV3fMEA3IuXIPX9GVPZAoO+fhQFcDnlXTdmO1Ees7uYr7bUTetCi/u6cq6Papbh+0zUCgYEAm7V93pcZS/YKAKOfyBkqIyZj9Jt4NyAodFTK3Jfnn0llK/y+eWHyBDNWkt/nxw3Re51TNyN9E4x0ieL+onoU8LN3K4dWeqG5BYhJztLnX7Lui3C8RrMh8PWtgm22SvsRYvpD3Sii4ADX30fEzkrdwRTJb6pNkBwnLCC/vqb63LcCgYEAz3dz3bYzsB9bLPxWYVJXARxNLR7JoSHgvsBdsrwTukS1jBzMKRkn1avSPvfT0P64Gsk9KmuBIcCDGyKalZkpUWJTPkLshWMd5VZnBUS1sOryopy9ww9uAYBMLtzAqT4wXBLzE8/WRFi3NxujbxMl+UEY5jtYCg20tZKMjlh7fPkCgYEAifJfge0hZy+hqvFLJE5PC3b+hP2bolLmJDHey1H0zSSL8k1nPkhszhXhdBvTzoDKfxZhW+8f50q/EE2/Q5iepqSIRlMPZXOTZHha01X7z8fJGFYXJxeaUUyGnI+wOXt26tZHe05+BbAZj+GYVR70mRNeZoRdVPfsKGcXGMP8ab8CgYEAvjy7Nwal8qNm9pRLGe6jQaVERrM23/jxnSNyQ1XyRW/Mxbc/2ClfRE5B0Bin0lZuQikUd9qxLJwW9Tn1r+q+CgpBqo5fhRkRPHEuhZTEOkR4rNl32RDGZ8fYG6982ciCoNUEh0uOlfLd9W4t1/KR4Cs0n0Vww7uE/67qNg3G+Gc=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA8wXWugB/PS+1fB2kjUuTbOd42CX5gz35k2rS4fsyT5dN/YIx2BUB2PX49nylWX0PkF9wUa3GqjclksIqzczsIb/Dn+95RZpGAzeOfcg1F0EnytCIvTI8L7jASZeAF2vKkatvC8WSV2tzVLWND/iwXpcrpYBLtvjrTxxy001BRaQK9kz1jKxSQHiH0AfU4JAxN21OqNirrcugcDGZ5PDYWW3BiGtMUY5n14GMzQDOju8ED4cPXlaNvbpmF97KNOcVgOXQsPyf/njwspjBweDlnizS3ainaeU7zIggX0d+mZg/Y26rvabOgXOLT8iUv6/XZ+zv2Ej4qAyEoVuXwAAT1QIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://www.hujiatai.cn/hotel/order?method=updateStatus";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://www.hujiatai.cn/hotel/order?method=updateStatus";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "E:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

