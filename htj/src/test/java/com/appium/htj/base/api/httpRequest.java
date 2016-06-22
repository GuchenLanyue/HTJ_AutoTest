package com.appium.htj.base.api;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.fluent.Response;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.appium.htj.base.api.DataReader;

public class httpRequest {
	
protected String type = null;
protected String host = null;
protected String api = null;
protected String url = null;
protected String contentType = null;
protected String connection = null;
protected String userAgent = null;
protected String acceptEncoding = null;
protected String body = null;
protected String result = null;

protected int code = 0;
protected HttpResponse response;
protected HashMap<String, String> myList = new HashMap<String ,String>();
protected HashMap<String, String> deviceID = new HashMap<String ,String>();
protected List<String> list = new ArrayList<>();
protected HashMap<String, String> bodyMap = new HashMap<String,String>();
protected List<NameValuePair> data = null;

protected String path = "data/api.xls";
protected DataReader dataReader;
protected HashMap<String, HashMap<String, String>> map = new HashMap<String, HashMap<String, String>>();
protected HashMap<String, String> mylist = new HashMap<String, String>();

public void request(String testCase) throws JSONException, ClientProtocolException, IOException {
	dataReader = new DataReader(path,"API",1,0);
	map = dataReader.getMap();
	myList = map.get(testCase);
	type = map.get(testCase).get("Type");
	if (type.equals("POST")) {
		post(myList);
	}else if(type.equals("GET")){
		
	}
}

public void post(HashMap<String, String> list) throws JSONException, ClientProtocolException, IOException{
	
	myList = list;
	type = myList.get("Type");
	host = myList.get("Host");
	api = myList.get("URL");
	url = host+api;
	contentType = myList.get("Content-Type");
	connection = myList.get("Connection");
	userAgent = myList.get("User-Agent");
	acceptEncoding = myList.get("Accept-Encoding");
	body = myList.get("Body");
	
//	构造HttpClient对象，来管理请求
	HttpClient client = new DefaultHttpClient();
//	构造HttpPost对象，并将用户名，密码数据按照表单格式封装
	HttpPost request = new HttpPost(url);
//	设置连接超时为10s
	HttpConnectionParams.setConnectionTimeout(client.getParams(), 10000);
	HttpConnectionParams.setSoTimeout(client.getParams(), 10000);
	
//	设置header
	request.setHeader("Content-Type",contentType);
	request.setHeader("Connection",connection);
	request.setHeader("User-Agent",userAgent);
	request.setHeader("Accept-Encoding",acceptEncoding);
	
//	设置参数
	data = new LinkedList<NameValuePair>();
	splitBody();
	setBody();
	request.setEntity(new UrlEncodedFormEntity(data,HTTP.UTF_8));
	HttpResponse response = client.execute(request);
	code = response.getStatusLine().getStatusCode();
	result = EntityUtils.toString(response.getEntity());
//	小号掉返回数据，结束连接
	response.getEntity().consumeContent();
}

public void splitBody() {
//	HashMap<String, String> parameterMap = new HashMap<String,String>();
	String[] bodyArray = null;
	bodyArray = body.split("&");
	for(int i = 0 ; i < bodyArray.length ; i++){
		String[] parametersArray = bodyArray[i].split("=");
		if (parametersArray.length>1) {
			bodyMap.put(parametersArray[0], parametersArray[1]);
		}else{
			bodyMap.put(parametersArray[0], null);
		}
		
	}
}

public String getURL() {
	return url;
}

public String getType() {
	return type;
}

public String getResponse(){
	return result;
}
public int getCode() {
	return code;
}

public void setToken(String token) {
	bodyMap.put("token", token);
}

public void setRepairID(int repair_id) {
	bodyMap.put("repair_id", String.valueOf(repair_id));
}

public void setDeviceID(int deviceID) {
	bodyMap.put("device_id", String.valueOf(deviceID));
}

public void setBody() {
	try {
		LoginSuccess login = new LoginSuccess(1);
		String token = login.getToken();
		setToken(token);
		data.add(new BasicNameValuePair("token", bodyMap.get("token")));
	} catch (ClientProtocolException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public HashMap<String, String> getBody() {
	return bodyMap;
}

public httpRequest() {
	// TODO Auto-generated constructor stub
}

public httpRequest(String testCase) {
	// TODO Auto-generated constructor stub

	try {
		request(testCase);
	} catch (ClientProtocolException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
