package kr.ac.kookmin.discrete.fcn;

public class Test {

	public static void main(String[] args) {
		FindConnectedNumber FCN = new FindConnectedNumber();
		FCN.setGraph(); //그래프 초기화
		System.out.println("초기 그래프 상태 출력\n");
		FCN.printGraph(); //그래프 출력
		FCN.checkConnectivity(); //C(G) 구하기.
	}
}
