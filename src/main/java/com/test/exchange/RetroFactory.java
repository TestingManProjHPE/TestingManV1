package com.test.exchange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetroFactory {
	// 实现cookie的自动管理功能，CookieJar类中重载saveFromResponse方法和loadForRequest方法
	static OkHttpClient client = new OkHttpClient.Builder().cookieJar(new CookieJar() {
		private final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();

		@Override
		public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
			String urlKey = url.host() + ":" + url.port();
			List<Cookie> tempCookies = new ArrayList<Cookie>();
			// 需要添加 cookie 失效
			if (cookieStore.containsKey(urlKey)) {
				tempCookies.addAll(cookieStore.get(urlKey));

				for (Cookie cookie : cookies) {
					for (Cookie tempCookie : tempCookies) {
						if (tempCookie.name().equals(cookie.name())) {
							tempCookies.remove(tempCookie);
							break;
						}
					}
				}
			}

			tempCookies.addAll(cookies);
			cookieStore.put(urlKey, tempCookies);
		}

		@Override
		public List<Cookie> loadForRequest(HttpUrl url) {
			String urlKey = url.host() + ":" + url.port();
			List<Cookie> cookies = cookieStore.get(urlKey);
			System.out.println("load : " + url.host() + " - " + cookies);
			return cookies != null ? cookies : new ArrayList<Cookie>();
		}
	}).build();
	// 需要访问的rest服务器基础路径
	private static String baseUrl = "http://192.168.5.130:8080/qcbin/";

	private static Retrofit jsonRetrofit = new Retrofit.Builder().baseUrl(baseUrl)
			.addConverterFactory(GsonConverterFactory.create()).client(client).build();

	private static Retrofit xmlRetrofit = new Retrofit.Builder().baseUrl(baseUrl)
			.addConverterFactory(SimpleXmlConverterFactory.create()).client(client).build();

	private static Retrofit scalarsRetrofit = new Retrofit.Builder().baseUrl(baseUrl)
			.addConverterFactory(ScalarsConverterFactory.create()).client(client).build();

	public static RetrofitService getJsonService() {
		RetrofitService service = jsonRetrofit.create(RetrofitService.class);
		return service;
	}

	public static RetrofitService getXmlService() {
		RetrofitService service = xmlRetrofit.create(RetrofitService.class);
		return service;
	}

	public static RetrofitService getScalarsService() {
		RetrofitService service = scalarsRetrofit.create(RetrofitService.class);
		return service;
	}

}
