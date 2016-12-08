package test.test1;

import java.io.File;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.Invoker;

public class AutoGenerateEntity {
	public static void main(String[] args) {

		try {

			System.setProperty("M2_HOME", "C:\\jba\\apache-maven-3.3.3");

			InvocationRequest request = new DefaultInvocationRequest();
			request.setPomFile(new File("pom.xml"));
			request.setGoals(Collections.singletonList("hibernate3:hbm2java"));

			Invoker invoker = new DefaultInvoker();
			System.out.println("M2_HOME:" + System.getProperty("M2_HOME"));

			invoker.setMavenHome(new File(System.getProperty("M2_HOME")));
			invoker.execute(request);
			System.out.println("maven executed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setEnv(String key, String value) {
		try {
			Map<String, String> env = System.getenv();
			System.out.println("ee:" + env.size());
			Class<?> cl = env.getClass();
			Field field = cl.getDeclaredField("m");
			field.setAccessible(true);
			Map<String, String> writableEnv = (Map<String, String>) field
					.get(env);
			writableEnv.put(key, value);
		} catch (Exception e) {
			throw new IllegalStateException(
					"Failed to set environment variable", e);
		}
	}

	public static void setEnv1(Map<String, String> newenv) throws Exception {
		Class[] classes = Collections.class.getDeclaredClasses();
		Map<String, String> env = System.getenv();
		for (Class cl : classes) {
			if ("java.util.Collections$UnmodifiableMap".equals(cl.getName())) {
				System.out.println("inside>>>>>");
				Field field = cl.getDeclaredField("m");
				field.setAccessible(true);
				Object obj = field.get(env);
				Map<String, String> map = (Map<String, String>) obj;
				map.clear();
				map.putAll(newenv);
			}
		}
	}

}
