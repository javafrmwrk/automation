package test.test1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.RegexFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.io.filefilter.WildcardFileFilter;

public class FileGeneration {

	public static void main(String s[]){

		String projectName="test";
		String packageName="store";
		createFolder(projectName,packageName);
	}

private static String createFolder(String projectName,String packageName) {
            String rootDirectory="C:\\project\\";
          String folderStructure="\\src\\main\\java";
          String classFile=packageName;
          packageName="\\com\\accenture\\"+packageName;
		String targetDirName = rootDirectory+projectName+folderStructure+"\\..\\resources\\..\\webapp";

		try {

			Path path = Paths.get(targetDirName);
			Files.createDirectories(path);

			// create sub directory
               String subJavaFolder=rootDirectory+projectName+folderStructure+packageName+"\\controller";
			Path subPath = Paths.get(subJavaFolder+"\\..\\service\\..\\dao\\..model");
			Files.createDirectories(subPath);
			System.out.println(targetDirName);

			AutoGenerate.autoGenerateControleFile(subJavaFolder, packageName, classFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			 System.err.println("Cannot create directories - " + e);
		}
		return targetDirName;
	}

}
