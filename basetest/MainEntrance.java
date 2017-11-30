package basetest;

import java.util.*;
import java.io.*;

public class MainEntrance{
	
	// 持有运行接口名的列表（用于动态获取类并生成对象）
	private static List<String> runInterfaceNameList = new ArrayList<String>();
	// 持有运行接口对象的列表
	private static List<BaseRunInterface> runInterfaceList = new ArrayList<BaseRunInterface>();

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		// 搜索basetest包中所有入口的类名
		searchEntranceFile();
		instanceEntrance();
		
		int choice = 0;
		
		do{
			// 生成练习选择运行选择表
			printLine();
			for(int i = 0, size = runInterfaceNameList.size(); i < size; i++){
				System.out.println((i + 1) + "." + runInterfaceList.get(i).getTitle());
			}
			if(runInterfaceNameList.size() <= 0){
				System.out.println("当前还没有创建练习！");
			}
			System.out.println("0.退出");
			System.out.println("请选择需要运行的练习:");
			
			// 等待用户输入来判断接下来的操作
			if(input.hasNextInt()){
				choice = input.nextInt();
			}
			
			printLine();
			
			// 运行选中的入口
			if(choice > 0 && choice <= runInterfaceList.size()){
				System.out.println("运行练习" + choice);
				runInterfaceList.get(choice - 1).run();
				System.out.println("练习" + choice + "结束");
			}else if(choice < 0){
				System.out.println("输入有误！");
			}else if(choice > runInterfaceList.size()){
				System.out.println("并没有该练习！");
			}
		}while(choice != 0);
	}
	
	/**
	 * 生成运行入口对象并添加到列表中
	 */
	private static void instanceEntrance(){
		try{
			for(int i = 0, size = runInterfaceNameList.size(); i < size; i++){
				ClassLoader classLoader = MainEntrance.class.getClassLoader();
				// 根据完整类名动态获取类
				Class baseRun = classLoader.loadClass(runInterfaceNameList.get(i));
				// 根据获取的类生成对象
				Object baseRunInstance = baseRun.newInstance();
				if(baseRunInstance instanceof BaseRunInterface){
					BaseRunInterface runInterface = (BaseRunInterface)baseRunInstance;
					// 加入运行接口对象列表
					runInterfaceList.add(i, runInterface);
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 搜索入口文件
	 */
	private static void searchEntranceFile(){
		String basePath = "";
		// 获取根目录文件
		File baseFile = new File("basetest");
		
		if(baseFile.exists()){
			// 初始化根路径
			basePath += "basetest";
			// 搜索根目录下子文件或目录中是否有入口文件
			searchSubFile(baseFile, basePath);
		}
	}
	
	/**
	 * 搜索目录下的所有子文件
	 * @param baseFile 目录文件
	 * @param basePath 目录文件Path
	 */
	private static void searchSubFile(File baseFile, String basePath){
		// 如果baseFile是文件
		if(baseFile.isFile()){
			// 去除.java文件后缀名
			basePath = basePath.replace(".java", "");
			// 如果baseFile是入口文件
			if(baseFile.getName().contains("EntranceImpl")){
				// 把该地址加入入口文件列表中
				runInterfaceNameList.add(basePath);
			}
			return;
		}
		
		// 获取该目录下的所有子文件
		File[] subFiles = baseFile.listFiles();
		for(int i = 0,size = subFiles.length; i < size; i++){
			// 再去搜索子文件或目录中是否有入口文件
			searchSubFile(subFiles[i], basePath + "." + subFiles[i].getName());
		}
	}
	
	/**
	 * 打出一条线
	 */
	private static void printLine(){
		for(int i = 0; i < 50; i++){
			System.out.print("-");
		}
		System.out.println();
	}

}