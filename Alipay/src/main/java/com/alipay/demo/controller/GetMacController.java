package com.alipay.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alipay.demo.utils.SystemUtils;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ：WenYuQi
 * @date ： 2019/10/10 15:00
 */
@RestController
@AllArgsConstructor
@Api(value = "获取Mac地址",tags = "获取本机MAC地址")
public class GetMacController {

    private static Log log = LogFactory.getLog(GetMacController.class);

        /**
         * 获取本机MAC地址
         *
         * @return
         */
        @RequestMapping("/getmac")
        public  void getLocalMac(HttpServletRequest request, HttpServletResponse response)throws Exception {
            String localMac = null;
                InetAddress inetAddress = InetAddress.getLocalHost();
                /**
                 * 获取电脑网卡的AMC地址
                 * 返回包含硬件地址的 byte 数组；如果地址不存在或不可访问，则返回 null
                 * 如果电脑因为网卡被禁用，则这里获取会返回 null
                 */
                byte[] mac = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
                if (mac == null) {
                    log.info("获取网卡 MAC 地址失败，网卡可能被禁用...");
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer("");
                for (int i = 0; i < mac.length; i++) {
                    if (i != 0) {
                        stringBuffer.append("-");
                    }
                    /**
                     * 转换mac的字节数组
                     */
                    int temp = mac[i] & 0xff;
                    String str = Integer.toHexString(temp);
                    if (str.length() == 1) {
                        stringBuffer.append("0" + str);
                    } else {
                        stringBuffer.append(str);
                    }
                }
                localMac = stringBuffer.toString().toUpperCase();
                response.setCharacterEncoding("utf8");
                response.getWriter().write(JSON.toJSONString(localMac));
        }



    public  static  String what(String ip) {
        StringBuffer sb = null;
        try {
            NetworkInterface ne=NetworkInterface.getByInetAddress(InetAddress.getByName(ip));
            byte[]mac=ne.getHardwareAddress();
            sb = new StringBuffer("");
            for(int i=0; i<mac.length; i++) {
                if(i!=0) {
                    sb.append("-");
                }
                //字节转换为整数
                int temp = mac[i]&0xff;
                String str = Integer.toHexString(temp);
//                System.out.println("每8位:"+str);
                if(str.length()==1) {
                    sb.append("0"+str);
                }else {
                    sb.append(str);
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return sb.toString().toUpperCase();
    }

    @RequestMapping("/testone")
    public void  getIpAddress(HttpServletRequest request) {
        log.info("================"+request.getRemoteAddr());
        log.info("================"+request.getCookies());
        log.info("================"+ request.getRemoteHost());
        log.info("================"+ request.getHeader("Host"));
        String ip = SystemUtils.getIpAddr(request);
        log.info("###############"+ip);
    }

/*    public static void main(String[] args) {
        String ip = "117.136.24.186";
        String ip1 = "10.10.2.227";
        String ip2 = "10.0.75.1";
        String mac = what(ip);
//        String mac2 = what(ip1);
//        String mac3 = what(ip2);
        log.info(mac);
//        log.info(mac2);
//        log.info(mac3);
    }*/


}


