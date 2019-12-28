package com.gov.vill.sms;

//required imports
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONObject;

public class SMSService {
	static String url = "https://www.way2sms.com";

	/**
     *
     * @param token 
     * @param phone 10 digit mobile number
     * @param message
     * @param senderId
     */
    public static String sendCampaign(String apiKey,String secretKey,String useType, String phone, String message, String senderId){
      try{
          // construct data
        JSONObject urlParameters = new JSONObject();
        urlParameters.put("apikey",apiKey);
        urlParameters.put("secret",secretKey);
        urlParameters.put("usetype",useType);
        urlParameters.put("phone", phone);
        urlParameters.put("message", URLEncoder.encode(message,"UTF-8"));
        urlParameters.put("senderid", senderId);
        URL obj = new URL(url + "/api/v1/sendCampaign");
          // send data
        HttpURLConnection httpConnection = (HttpURLConnection) obj.openConnection();
        httpConnection.setDoOutput(true);
        httpConnection.setRequestMethod("POST");
        DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream());
        wr.write(urlParameters.toString().getBytes());
        // get the response  
        BufferedReader bufferedReader = null;
        if (httpConnection.getResponseCode() == 200) {
            bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
        } else {
            bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream()));
        }
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            content.append(line).append("\n");
        }
        bufferedReader.close();
        return content.toString();
      }catch(Exception ex){
        System.out.println("Exception at:"+ex);
        ex.printStackTrace();
        return "{'status':500,'message':'Internal Server Error'}";
      }
        
    }
    
	/*
	 * public static void main(String[] args) { String
	 * apiKey="KPSUSPEIX5X02Q6SPLYFTV3NKKRQ6MTN"; String
	 * secretKey="JCM45A4WJLS4H4XW"; String useType = "stage"; String phone
	 * ="8019692762"; String message = "Hi, im from way2sms."; String senderId =
	 * "9581956117";
	 * 
	 * String response = sendCampaign(apiKey, secretKey, useType, phone, message,
	 * senderId);
	 * 
	 * System.out.println("Response "+response); }
	 */
	/*
	 * response 
	 * { "code":"200", "status":"success", "req-type":"get/post",
	 * "message":"campaign send successfully.", "smscost":[Rs.xxx],
	 * "balacne":[Rs.xxxx]. --- some additional information--- }
	 */

}


