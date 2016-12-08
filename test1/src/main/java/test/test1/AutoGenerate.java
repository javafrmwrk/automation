package test.test1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.source.AnnotationSource;
import org.jboss.forge.roaster.model.source.JavaClassSource;

public class AutoGenerate {

	public static void main(String a[]) {
		final JavaClassSource javaClass = Roaster.create(JavaClassSource.class);

		javaClass.setPackage("test").setName("Storecontroller");

		// add import statement. java, javax, third party library first
		javaClass
				.addImport("org.springframework.beans.factory.annotation.Autowired");
		javaClass.addImport("org.springframework.stereotype.Controller");
		javaClass.addImport("org.springframework.ui.Model");
		javaClass.addImport("org.springframework.ui.Model");
		javaClass
				.addImport("org.springframework.web.bind.annotation.RequestMapping");
		javaClass
				.addImport("org.springframework.web.bind.annotation.RequestParam");

		// add annotation to the bean class
		AnnotationSource<JavaClassSource> restController = javaClass
				.addAnnotation("Controller"); // add Stateless Annotation

		// set the parent class
		// javaClass.setSuperType("Storecontroller");

		// add fileds and fields annotation
		javaClass.addField().setType("StoreService").setName("storeService")
				.addAnnotation("Autowired");

		// emit the generated class as String from the roaster
		String str = javaClass.toString();

		// This can be removed
		System.out.println(str);
	}

	public static void autoGenerateControleFile(String targetDirectory,
			String packageName, String classFileName) {

		System.out.println("Inside autoGenerateControleFile"+packageName);
		final JavaClassSource javaClass = Roaster.create(JavaClassSource.class);

		packageName=packageName.replace("\\", ".");
		packageName=packageName.substring(1, packageName.length());
		System.out.println(">>packageName:"+packageName);
		String controllerFileName=classFileName+"Controller";
		javaClass.setPackage(packageName).setName(controllerFileName);

		javaClass.addImport("org.springframework.beans.factory.annotation.Autowired");
		javaClass.addImport("org.springframework.stereotype.Controller");
		javaClass.addImport("org.springframework.ui.Model");
		javaClass.addImport("org.springframework.ui.Model");
		javaClass.addImport("org.springframework.web.bind.annotation.RequestMapping");
		javaClass.addImport("org.springframework.web.bind.annotation.RequestParam");

		// add annotation to the bean class
		AnnotationSource<JavaClassSource> restController = javaClass
				.addAnnotation("Controller"); // add Stateless Annotation

		// set the parent class
		// javaClass.setSuperType("Storecontroller");

		// add fileds and fields annotation
		javaClass.addField().setType(classFileName+"Service").setName(classFileName+"Service")
				.addAnnotation("Autowired");

		// emit the generated class as String from the roaster
		String content = javaClass.toString();
		System.out.println("content"+content);

		writeToFile(targetDirectory,controllerFileName,content);

	}

public static void  writeToFile(String targetDirectory, String controllerFileName, String content) {

	System.out.println("Inside the file writeToFile");
		Writer writer = null;

		try {
			writer = new BufferedWriter(new FileWriter(new File(targetDirectory+"/"+controllerFileName)+".java"));
			writer.write(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//TODO
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}



	}

}
