package basetest;

public abstract class BaseRunInterface{
	public String getIndexWithTitle(int index){
		return "练习" + (index + 1) + " " + getTitle();
	}
	
	public abstract String getTitle();
	
	public boolean isShow(){
		return true;
	}
	
	public abstract void run();
}