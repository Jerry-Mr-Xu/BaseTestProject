package basetest;

import java.util.*;
import java.io.*;

public class MainEntrance{
	
	List<BaseRunInterface> runInterfaceList = new ArrayList<BaseRunInterface>();

	public static void main(String[] args){
		ClassLoader classLoader = MainEntrance.class.getClassLoader();
		
		// 搜索basetest包中所有入口的类名
		searchEntranceFile();
		
		try{
			Class baseRun = classLoader.loadClass("basetest.test01.EntranceImpl");
			BaseRunInterface runInterface = (BaseRunInterface)baseRun.newInstance();
			//runInterface.run();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	private static void searchEntranceFile(){
		String basePath = "";
		File baseFile = new File("basetest");
		
		if(baseFile.exists()){
			basePath += "basetest";
		}
	}

}