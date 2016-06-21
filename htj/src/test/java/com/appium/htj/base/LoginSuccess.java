package com.appium.htj.base;

import java.io.IOException;

import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginSuccess extends httpRequest{

private String token = null;
private String nickname = null;

//public void loginSuccess(int userType) throws ClientProtocolException, JSONException, IOException {
//	if (userType == 1) {
//		request("ClientLogin");
//	}else if (userType == 2) {
//		request("ServerLogin");
//	}else{
//		Log.d("dir", "user type error!");
//	}
//	
//	formatResponse();
//}

@Override
public void setBody() {
//	mobile=15210819621&password=123456&platform=M351+%3B+Android4.4.4&user_type=1
	data.add(new BasicNameValuePair("mobile", bodyMap.get("mobile")));
	data.add(new BasicNameValuePair("password", bodyMap.get("password")));
	data.add(new BasicNameValuePair("platform", bodyMap.get("platform")));
	data.add(new BasicNameValuePair("user_type", bodyMap.get("user_type")));
}

//格式化response
public void formatResponse() throws JSONException {
	String jsonKey = "value";
	if (code==HttpStatus.SC_OK) {
		JSONObject jsonObject = new JSONObject(result.toString()).getJSONObject(jsonKey);
		token = jsonObject.getString("token");
		nickname = jsonObject.getString("nickname");
	}else{
//		Log.d("dir", "failed");
	}
}

//获取用户tonken
public String getToken() {
	return token;
}

//获取用户姓名
public String getNickname() {
	return nickname;
}

/*
 * @userType 1:client,2:server
 */
public LoginSuccess(int userType) throws ClientProtocolException, JSONException, IOException {
	super();
	
	if (userType == 1) {
		request("ClientLogin");
	}else if (userType == 2) {
		request("ServerLogin");
	}else{
//		Log.d("dir", "user type error!");
	}
	
	formatResponse();
}

}
