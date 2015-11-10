package kr.ac.kookmin.discrete.nna;

public class Test {

	public static void main(String[] args) {
		NearNeighbor NNA = new NearNeighbor();
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				System.out.print(NNA.Path[i][j]+"  ");
			}
			System.out.println("");
		}
		NNA.setGraph();
		NNA.setRandomVertex();
		NNA.findResultOfCircuit();
	}
}
