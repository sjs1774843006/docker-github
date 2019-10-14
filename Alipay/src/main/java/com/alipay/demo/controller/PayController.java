package com.alipay.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeCreateRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.demo.config.AlipayConfig;
import com.alipay.demo.formbody.PayFormBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：WenYuQi
 * @date ： 2019/9/24 17:26
 */
@RestController
@AllArgsConstructor
@Api(value = "支付接口",tags = "支付宝沙箱测试")
public class PayController {

    @ApiOperation(value = "订单支付", notes = "支付宝")
    @PostMapping(value = "/AlipayDev")
    public  void  AliPay(@RequestBody PayFormBody payFormBody,HttpServletRequest request, HttpServletResponse response) throws  Exception{
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL,AlipayConfig.APPID,AlipayConfig.RSA_PRIVATE_KEY,AlipayConfig.FORMAT,AlipayConfig.CHARSET,AlipayConfig.ALIPAY_PUBLIC_KEY,AlipayConfig.SIGNTYPE);
        AlipayTradePagePayRequest  alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        if (payFormBody.getTotalAmount() == null) {
            new NullPointerException("参数为空");
        }
        JSONObject json = new JSONObject();
        //商户订单号
        json.put("out_trade_no",payFormBody.getOutTradeNo());
        //销售产品码
        json.put("product_code","FAST_INSTANT_TRADE_PAY");
        //订单总金额
        json.put("total_amount",payFormBody.getTotalAmount());
        //订单标题
        json.put("subject",payFormBody.getSubject());
        //订单描述
        json.put("body",payFormBody.getBody());
        //订单最晚交易时间
        json.put("timeout_express","1m");
        alipayRequest.setBizContent(json.toJSONString());
        response.setCharacterEncoding("utf8");
        response.getWriter().write(JSON.toJSONString(alipayClient.pageExecute(alipayRequest).getBody()));
    }

    @ApiOperation(value = "创建交易订单", notes = "支付宝")
    @PostMapping(value = "/AlipayTradeCreate")
    public  void  AlipayTradeCreate(@RequestBody PayFormBody payFormBody,HttpServletRequest request, HttpServletResponse response) throws  Exception{
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.URL,AlipayConfig.APPID,AlipayConfig.RSA_PRIVATE_KEY,AlipayConfig.FORMAT,AlipayConfig.CHARSET,AlipayConfig.ALIPAY_PUBLIC_KEY,AlipayConfig.SIGNTYPE);
        AlipayTradeCreateRequest alipayRequest = new AlipayTradeCreateRequest ();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        if (payFormBody.getTotalAmount() == null) {
            new NullPointerException("参数为空");
        }
        JSONObject json = new JSONObject();
        //商户订单号
        json.put("out_trade_no",payFormBody.getOutTradeNo());
        //销售产品码
        json.put("product_code","FAST_INSTANT_TRADE_PAY");
        //订单总金额
        json.put("total_amount",payFormBody.getTotalAmount());
        //订单标题
        json.put("subject",payFormBody.getSubject());
        //订单描述
        json.put("body",payFormBody.getBody());
        //订单最晚交易时间
        json.put("timeout_express","1m");
        alipayRequest.setBizContent(json.toJSONString());
        response.setCharacterEncoding("utf8");
        response.getWriter().write(JSON.toJSONString(alipayClient.pageExecute(alipayRequest).getBody()));
    }








}
