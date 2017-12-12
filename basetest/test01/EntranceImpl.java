package basetest.test01;

import basetest.*;

public class EntranceImpl extends BaseRunInterface{
	@Override
	public String getTitle(){
		return "继承构造函数练习";
	}
	
	@Override
	public void run(){
		ClassC classC = new ClassC(1);
	}
	
	@Override
	public boolean isShow(){
		return false;
	}
}