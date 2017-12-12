package basetest.test01;

public class ClassC extends ClassB{
	public ClassC(int i){
		super(i);
		System.out.println("ClassC construction with param i = " + i);
	}
}