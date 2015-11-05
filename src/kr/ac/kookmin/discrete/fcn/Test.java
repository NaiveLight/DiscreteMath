package kr.ac.kookmin.discrete.fcn;

public class Test {

	public static void main(String[] args) {
		FindConnectedNumber FCN = new FindConnectedNumber();
		FCN.setGraph();
		System.out.println("초기 그래프 상태 출력\n");
		FCN.printGraph();
		
	
		FCN.checkGraph();
		
		FCN.checkGraph();
		
		FCN.checkGraph();
		
		FCN.checkGraph();
	}
}
