package com.test.exchange;

import java.io.IOException;
import java.util.List;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.PostgreSqlDialect;
import com.jfinal.plugin.druid.DruidPlugin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.test.mvc.requirements.Requirements;

public class MainActivity {

	private String USERNAME = "almtest";
	private String PASSWORD = "password";
	private String answerChar = "y";
	private String domain;
	private String project;
	
	
	public void setDomain(String domain) {
		this.domain = domain;
	}

	public void setProject(String project) {
		this.project = project;
	}
	
	
	public void isAuthenticated() {

		Call<String> call = RetroFactory.getScalarsService().isAuthenticated();

		call.enqueue(new Callback<String>() {
			@Override
			public void onResponse(Call<String> call, Response<String> response) {
				if (response.isSuccessful() && response.errorBody() == null) {
					System.out.println("str:" + response.body().toString());
				} else {
					String authenticationHeader = response.headers().get("WWW-Authenticate");
					String newUrl = authenticationHeader.substring(authenticationHeader.lastIndexOf("=") + 1);
					newUrl = newUrl.replace("\"", "");
					newUrl += "/authenticate";

					System.out.println(newUrl);
					// ret = newUrl;
				}
			}

			@Override
			public void onFailure(Call<String> call, Throwable t) {
				System.out.println("error:" + t.getMessage());
			}
		});

	}

	public void login() throws IOException {
		byte[] credBytes = (USERNAME + ":" + PASSWORD).getBytes();
		String credEncodedString = "Basic " + Base64Encoder.encode(credBytes);
		Call<String> call = RetroFactory.getScalarsService().login(credEncodedString);
		call.execute();
	}

	public void sitSession() throws IOException {
		String xml = ("<session-parameters>" + "<client-type>REST Client</client-type> " + "</session-parameters>");
		Call<String> call = RetroFactory.getScalarsService().sitSession(xml);
		call.execute();
	}

	public Domains getDomains() throws IOException {
		Call<Domains> call = RetroFactory.getXmlService().getDomains(answerChar);
		Response<Domains> response = call.execute();
		Domains domains = response.body();
		return domains;
	}

	public Entities getDefects() throws IOException {
		Call<Entities> call = RetroFactory.getXmlService().getDefects(domain, project);
		Response<Entities> response = call.execute();
		Entities defects = response.body();
		System.out.println();
		return defects;
	}

	public Entities getRequirements() throws IOException {
		Call<Entities> call = RetroFactory.getXmlService().getRequirements(domain, project);
		Response<Entities> response = call.execute();
		Entities Requirements = response.body();
		return Requirements;
	}
	
	public Entities getTests() throws IOException {
		Call<Entities> call = RetroFactory.getXmlService().getTests(domain, project);
		Response<Entities> response = call.execute();
		Entities tests = response.body();
		return tests;
	}

	public static void main(String[] args) {
		MainActivity MainActivity = new MainActivity();

		// MainActivity.isAuthenticated();

		try {
			MainActivity.login();
			MainActivity.sitSession();
			Domains domains = MainActivity.getDomains();

			MainActivity.setDomain(domains.getList().get(0).getName());
			MainActivity.setProject(domains.getList().get(0).getProjects().getProject().getName());

			System.out
					.println(MainActivity.getDefects().getList().get(0).getList().get(0).getField().get(7).getValue());

			System.out.println(MainActivity.getRequirements().getList().get(0).getChildrenCount().getValue());
//			System.out.println(MainActivity.getTests().getList().get(0).getChildrenCount().getValue());
			
			DruidPlugin druidPlugin = new DruidPlugin("jdbc:postgresql://127.0.0.1:5432/hp_test_management", "postgres", "qwerty", "org.postgresql.Driver");
			druidPlugin.start();
			ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
			arp.setDialect(new PostgreSqlDialect());
			arp.addMapping("requirements", "req_sn", Requirements.class);
			arp.start();
			Requirements.dao.setAuthor("test001");
			Requirements.dao.save();
			List<Requirements> requirementsList = Requirements.dao.find("select * from Requirements");
			System.out.println(requirementsList.get(0).getAuthor());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
