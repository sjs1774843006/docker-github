package com.alipay.demo.config;

/**
 * 沙箱测试
 * @author administrato
 */
public class AlipayConfig {

	//商户appid
	public static String APPID = "2016092900627142";
	// 请求网关地址
	public static String URL = "https://openapi.alipaydev.com/gateway.do";
	// 私钥 pkcs8格式的
	public static String RSA_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCYR8hEtevMwPZU7S+dw9DWoC1yA3xtQxHv3iAIPJX+XxwbgrhlihYwI6fNvFU5M8QuuMZAKV0Cv1zxKfP8cMGxZji8cNPXuxIZpsdoOMScjfIa8X+Lh40XFIBRicv5SMGeIsRHY6wzNoyw0lyaEUj/vqKFAQfZC1h2ZEgLv12XndgJIhtvHKPwxfuC2p+W/r8mavemvJCez7PU+wKMu1vUWy54xh8kIyMcj89Y1pKSoppysFzjoJ/Xx+G3EAjGw3GvJivF8i1uAAj/ecIdghPRT5xZVdxZErouOGUD4y4iLYtJ24WckGTiN2LiHH7AMzjwu8IFUlW5Ls9EKLB6raCrAgMBAAECggEAXfvvnnipD7YIUmIRAU3Zlp1Fbxi3sreyWli9bFf4OwZ4UoJbTE/tYcifyFp0Ptm0OyHPOcpNnWR9+FnsO+FbqiFs4uC/3mWWxj4o1Co1LmptAjQKhBMlARmmGKzzNuewl+jdOzJJFVKVgoxSmsQQScdehrgcH9jgwDEkRhvVp7zNptIAg8LKCSF9bf1OVCi1rA1GyDlNw4JWPf+vWlqIPbOA60QescvXzS8jBF9dHaFe2figMIYLlNUD0NvTIPgW8Dsnizq3h5DY/84qpW0N1jw0XjeABa6qScNiKbM7MkOwahYgjNG2ePUNCP9syW3NkLHlbLhQxcODsIXaIGYQAQKBgQDh/xK8hoavHETsVO/Zbb/XN5iGcx1xGZ66s7GfXH10vt73WccvljDIYiXK7OOrIJQY2mSaPRb7T0zZxm70wHWPOUC2dsfHJRgQYEswGYMLLdZm801mEY5XLDwcFW5/j2C6yhFWHmgxBswAZC66mwnxZjVxpAPGxROOPsUwewAzjwKBgQCsf1P7h8E1+Ed/sGF7HSaKO1w/PicV0aV36ad67CDsmffEss/iqAGvohEA2uvOWcMvzTXshEU2L5C/mVchAccMvKr6iN9yBGW9YI3liYRhU5zJfAis+xHa9FRPiD6TMmbskFshf90+ue3G9b+nVGKnJUMi0bnqgo9yg7VBYHyDJQKBgQCNB0Do9sYbhneYR1S5iVxa8G21EScBSiycc8BXIz+C2A2Jq7O6BW6BzYWqAXP9eUIR1E9NVOv/fbgGemcJQwTZkK/KbYszwfknVv/0jycQldUiv5fAJxp9WbRVDia7YXzKc4ioBiec2JH7eIkUl+V3iAG33dMheiA+9vrUyx0QDwKBgF/iz35Mcjxb7PKvyyAyjg/c+2Q0WmmohgBoI68SvyKGW9I9S43Esls9DZKaHuYvw2449japOAfs3NuEk4hHgqwz3B80InEwvJVOrNHhZXLslYTyq6fsUHqTwqILLC2KoOfzPpUajJOnquMkDAspv0UGU5FxX5VaSf7v87uJtOz5AoGBAJtVxmo1Wm267x7KfmgRcZc8cr8W4vja8CEyyu1fGxKqThugoAesW/rGOwgb+70bg1KkKemGEIJ75N5f5LcpLEIuS1rM69ijp6xJBrjSjMeJ27+CW0Ouvu8AT8B6DmQyQoiJeB6yFmqQQteA+7R8AasC3hxd0OhUUH46QYkC5tci";
	// 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//	public static String notify_url = "http://商户网关地址/alipay.trade.wap.pay-JAVA-UTF-8/notify_url.jsp";
	public static String notify_url = "  http://whkk6f.natappfree.cc/notifyUrl";
	// 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
//	public static String return_url = "http://商户网关地址/alipay.trade.wap.pay-JAVA-UTF-8/return_url.jsp";
	public static String return_url = "  http://whkk6f.natappfree.cc/returnUrl";

	// 编码
	public static String CHARSET = "UTF-8";
	// 返回格式
	public static String FORMAT = "json";
	// 支付宝公钥
	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwZZGPz10tb42qFwKMyqS8fpNkhiyVs4FM8+xUs9DQQS19fvOwI8BVE7HWj4XwgfWBRjIbkFcq7Db/db76BsMLnqOTpg205m5IGvzdvfw2s+h30JjLh95Q5kwRqWmvl7xFYB0GDZx4IwTevHhU7KmHejyVT93wSL1YaGSDXzmdRgUhjD9J22/vrqggjeCI6ODytE+mr/0UMNFbZokpx5w4Iv+ruDDE2JZZHPFO/v3vYKfgANAX4sMXC0ulbdYxOLgW0a3/n3YutknbhHEs1+jANAW4c8ZoyI3yC93Vfe2LhloAB1WLqIfGS4LUtyCZKtLkhBe8UjoAq3vGs59h0yNcQIDAQAB";
	// 日志记录目录
	public static String log_path = "/log";
	// RSA2
	public static String SIGNTYPE = "RSA2";
}
