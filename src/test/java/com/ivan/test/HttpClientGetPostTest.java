package com.ivan.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

/**
 * 测试HTTPClientGet
 * @author Ivan
 *
 */

public class HttpClientGetPostTest {
	@Test
	// 不带参数
	public void doGet() throws Exception {
		// 创建一个HTTPClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();

		// 创建一个Get对象
		HttpGet get = new HttpGet("http://www.baidu.com");
		// HttpGet get = new HttpGet("http://www.sougou.com");//返回中文乱码,toSring()方法加一个参数:utf-8

		// 执行请求
		CloseableHttpResponse response = httpClient.execute(get);

		// 取得响应结果
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);// 200即表示成功
		HttpEntity entity = response.getEntity();
		String string = EntityUtils.toString(entity);
		// String string = EntityUtils.toString(entity, "utf-8");

		System.out.println(string);

		// 关闭资源
		response.close();
		httpClient.close();
	}

	@Test
	// 带参数
	public void doGetWithParameter() throws Exception {
		// 创建一个HTTPClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		//创建一个uri对象
		URIBuilder uriBuilder = new URIBuilder("http://www.baidu.com/");
		uriBuilder.addParameter("query", "北京");

		// 创建一个Get对象
		HttpGet get = new HttpGet(uriBuilder.build());

		// 执行请求
		CloseableHttpResponse response = httpClient.execute(get);

		// 取得响应结果
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);// 200即表示成功
		HttpEntity entity = response.getEntity();
		String string = EntityUtils.toString(entity);

		System.out.println(string);

		// 关闭资源
		response.close();
		httpClient.close();
	}
	
	@Test
	//不带参数
	public void doPost() throws Exception{
		// 创建一个HTTPClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();

		// 创建一个Post对象
		HttpPost post = new HttpPost("http://localhost:8081/httppost/test.html");
		
		//执行请求
		CloseableHttpResponse response = httpClient.execute(post);
				
		//获取请求结果		
		String string = EntityUtils.toString(response.getEntity());
		System.out.println(string);
		
		// 关闭资源
		response.close();
		httpClient.close();
		
	}
	
	@Test
	//带参数
	public void doPostWithParameter() throws Exception{
		// 创建一个HTTPClient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();

		// 创建一个Post对象
		HttpPost post = new HttpPost("http://localhost:8081/httppost/test.html");
		
		//创建一个entity,模拟表单
		List<NameValuePair> kvlList = new ArrayList<>();
		kvlList.add(new BasicNameValuePair("username", "ivan"));
		kvlList.add(new BasicNameValuePair("password", "123456"));
		//包装成一个entity对象
		StringEntity entity = new UrlEncodedFormEntity(kvlList);
		//设置请求内容
		post.setEntity(entity);
		
		//执行请求
		CloseableHttpResponse response = httpClient.execute(post);
		
		//获取请求结果
		String string = EntityUtils.toString(response.getEntity());
		System.out.println(string);
		
		// 关闭资源
		response.close();
		httpClient.close();
		
	}
}
