package basetest.test01;

import basetest.*;

public class EntranceImpl implements BaseRunInterface{
	
	public void run(){
		int i = 0;
		
		switch(i){
			case 0:
			case 1:
				System.out.println("case 1");
			case 2:
				System.out.println("case 2");
				break;
		}
	}
	
}