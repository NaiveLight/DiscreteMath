/*
 * Name : �� ����
 * Student ID : 20113281
 * Program ID : HW#2 - NearNeighborAlgorithm
 * Description : ������ Vertex�� �����Ͽ� �̿��ϰ� �ִ� Vertex�� �� ���� �ּ� ����� path�� ���� �̵��Ѵ�. �� ��� Vertex���� ��Ȯ�� 1������ �湮�Ͽ� ������ Vertex�� ���ƿ´�.
 * Algorithm : V = Vertices in Graph, list
 * 			Choose any v1 in V
 * 			v' = v1
 * 			w  = 0
 * 			add v' to list of vertices in path
 * 			while unmarked vertices remain do
 * 				mark v'
 * 				choose any unmarked vertex u, that is closest to v'
 * 				add u to list of vertices in path
 * 				w = w + weight of edge{v', u}
 * 				v'= u
 * 				end while
 * 			add v' to list of path
 * 			w = w + weight of edge{v', v1}
 * 			print list and w
 * 			end
 * 
 * Variables Used : 
 * *����� method
 * public void setGraph() -> A, B, C, D �� vertex�� �̷���� �׷����� ����Ʈ�� �����Ѵ�.
 * public void setRandomVertex() -> ó�� ������ ������ vertex�� ���Ͽ� ����Ѵ�.
 * public void addVertexToList() -> ���õ� vertex�� ��ŷ(����)�ϰ� ��θ� pathlist�� �߰��Ѵ�.
 * public void findNextVertex() -> �� ��Ȳ�� �´� �ּ� weight�� path�� ������ vertex�� ã�� �׿� ���� weight�� ������Ų��.
 * public void moveNextVertex() -> ���� �Լ����� ã�� vertex�� �̵��Ѵ�.
 * public void findResultOfCircuit() -> ���ѷ����� ���� ���� pathlist�� weight�� ������ش�.
 * *����� Variables
 * int randomvertex -> 0~3���� ������ ���� ���� �� �׿� ���� vertexlist�� �ε����� �ش��ϴ� vertex�� �����´�. 
 * String startvertex -> ���� Vertex�� �����ϱ� ���� �����̴�.
 * String selectedvertex -> �ʱ⿡ ���õ� vertex�� �ʱ�ȭ �Ǹ� ���� ã�Ƴ� �ּ� ����� vertex�� ���ŵȴ�.
 * int weight -> 0���� �ʱ�ȭ �Ͽ��� path�� ã�� �� ���� ��� ���ŵȴ�.
 * int minpath -> �� ���ǿ� �´� �ּ� ��� ������ ���ŵȴ�.
 * LinkedList<String> vertexlist -> �ʱ� Graph�� ǥ���ϱ� ���� ��ũ�帮��Ʈ�̴�.
 * LinkedList<String> pathlist -> ��θ� ǥ���ϱ� ���� ��ũ�帮��Ʈ�̴�.
 * int Path[][] -> A ~ D������ ����� 2���� �迭�� �ʱ�ȭ �Ͽ���.
 */

package kr.ac.kookmin.discrete.nna;

import java.util.*;

public class NearNeighbor {
	public int randomvertex;
	public String startvertex;
	public String selectedvertex;
	public int weight = 0;
	public int minpath;
	public LinkedList<String> vertexlist  = new LinkedList<String>();
	public LinkedList<String> pathlist = new LinkedList<String>();
	public int Path[][] = {{0, 5, 6, 8}, {5, 0, 7, 10}, {6, 7, 0, 3}, {8, 10, 3, 0}};
	
	/*
	 * Method : setGraph()
	 * description : vertexlist�� Graph�� �ʱ�ȭ�ϱ� ���� �Լ��̴�.
	 * Variables : vertexlist -> Vertex A, B, C, D�� �߰��ϱ� ���� ���Ǿ���.
	 */
	public void setGraph(){
		vertexlist.add("A");
		vertexlist.add("B");
		vertexlist.add("C");
		vertexlist.add("D");
	}
	
	/*
	 * Method : setRandomVertex()
	 * description : ������ ���� Vertex�� ���ϱ� ���� �Լ��̴�.
	 * Variables : randomvertex -> 0~3������ ���� ���� �� �����ϱ� ���� ���Ǿ���.
	 *             selectedvertex -> ������ ������ index�� �ش��ϴ� vertex�� �����ϱ� ���� ���Ǿ���.
	 *             startvertex -> ���� vertex�� �����ϱ� ���� ���Ǿ���.
	 */
	
	public void setRandomVertex(){
			randomvertex = (int)(Math.random()*4); //���Ƿ� vertex�� index���� ����
			selectedvertex = vertexlist.get(randomvertex); //���õ� ���� ���� �ش��ϴ� index�� vertex�� ����
			startvertex = selectedvertex;
			System.out.println("���� Vertex : " + selectedvertex);
			addVertexToList();
	}
	
	/*
	 * Method: addVertexToList()
	 * description: ���õ� vertex�� vertexlist���� ��ŷ(����)�ϰ� pathlist�� �߰��ϱ� ���� �Լ��̴�. ���� vertexlist�� pathlist�� ������ش�.
	 * Variables: selectedvertex -> ���õ� vertex�� vertexlist���� �����ϰ� pathlist�� �߰��ϱ� ���� ���Ǿ���.
	 */
	public void addVertexToList(){
		vertexlist.remove(selectedvertex); 
		pathlist.add(selectedvertex);
		System.out.println("...................................................");
		System.out.println("���� Vertex : "+vertexlist+"\n"+"Pathlist : "+pathlist);
	}

	/*
	 * Method: findNextVertex()
	 * description: ���� ���õ� vertex���� vertexlist�� ���¸� �������� ��� �ּ� ����� path�� ã���� �ش� path�� ��븸ŭ weight�� �������� �ش�.
	 * Variables: selectedvertex -> ���õ� vertex�� �����Ͽ� switch���� Ȱ���ϱ� ���� ���Ǿ���.
	 * 			i -> ó�� ������ vertex�� ��� �ڽ��� ������ ��� vertex path�� ����� �ּҰ��� ã�� for���� ����ϱ� ���� ���Ǿ���. path�� �࿡ �ش�ȴ�.
	 *          j -> path�� ���� �ش�ȴ�.
	 *          minpath -> Math.min�Լ��� ���� �ּ� ����� �����Ѵ�. ��, vertexlist�� 1���� path�� ���� ���� path�� ���� �������ش�. 
	 *          weight -> path�� ������ �� ���� �� weight�� ���ϱ� ���� ���Ǿ���.
	 */
	public void findNextVertex(){
		int i=0;
		switch(selectedvertex){
		case "A":
			if(vertexlist.size() == 1 && vertexlist.contains("B")){
				minpath = Path[0][1]; //A->B
				break;
			}
			else if(vertexlist.size() == 1 && vertexlist.contains("C")){
				minpath = Path[0][2]; //A->C
				break;
			}
			else if(vertexlist.size() == 1 && vertexlist.contains("D")){
				minpath = Path[0][3]; //A->D
				break;
			}
			else if(vertexlist.size() == 2 && vertexlist.contains("B") && vertexlist.contains("C")){
				minpath = Math.min(Path[0][1], Path[0][2]); //A->B or A->C
				break;
			}
			else if(vertexlist.size() == 2 && vertexlist.contains("B") && vertexlist.contains("D")){
				minpath = Math.min(Path[0][1], Path[0][3]); //A->B or A->D
				break;
			}
			else if(vertexlist.size() == 2 && vertexlist.contains("C") && vertexlist.contains("D")){
				minpath = Math.min(Path[0][2], Path[0][3]); //A->C or A->D
				break;
			}
			else{ //if(vertexlist.size() == 3 && vertexlist.contains("B") && vertexlist.contains("C") && vertexlist.contains("D"))
				i=0;//0��
				minpath = Path[i][i+1]; //Path[i][i] == 0 �̹Ƿ� i+1�� �Ͽ� 0�� �ƴ� ���� �ʱ�ȭ�Ѵ�.
				for (int j=0; j<3; j++){
					if(Path[i][j]==0){//�ڱ� �ڽ����� �̵� ����� 0�̹Ƿ� �ڱ� �ڽ��� �ٽ� �����ϴ� ��츦 �����ϱ� ���� ����� 0�� �� �ǳʶڴ�. 
						continue;
					}
					else{
						minpath = Math.min(minpath, Path[i][j]);
					}
				}
				break;
			}
		case "B":
			if(vertexlist.size() == 1 && vertexlist.contains("A")){
				minpath = Path[1][0];
				break;
			}
			else if(vertexlist.size() == 1 && vertexlist.contains("C")){
				minpath = Path[1][2];
				break;
			}
			else if(vertexlist.size() == 1 && vertexlist.contains("D")){
				minpath = Path[1][3];
				break;
			}
			else if(vertexlist.size() == 2 && vertexlist.contains("A") && vertexlist.contains("C")){
				minpath = Math.min(Path[1][0], Path[1][2]);
				break;
			}
			else if(vertexlist.size() == 2 && vertexlist.contains("A") && vertexlist.contains("D")){
				minpath = Math.min(Path[1][0], Path[1][3]);
				break;
			}
			else if(vertexlist.size() == 2 && vertexlist.contains("C") && vertexlist.contains("D")){
				minpath = Math.min(Path[1][2], Path[1][3]);
				break;
			}
			else{ //if(vertexlist.size() == 3 && vertexlist.contains("A") && vertexlist.contains("C") && vertexlist.contains("D"))
				i=1;
				minpath = Path[i][i+1];
				for (int j=0; j<3; j++){
					if(Path[i][j]==0){
						continue;
					}
					else{
						minpath = Math.min(minpath, Path[i][j]);
					}
				}
				break;
			}
		case "C":
			if(vertexlist.size() == 1 && vertexlist.contains("A")){
				minpath = Path[2][0];
				break;
			}
			else if(vertexlist.size() == 1 && vertexlist.contains("B")){
				minpath = Path[2][1];
				break;
			}
			else if(vertexlist.size() == 1 && vertexlist.contains("D")){
				minpath = Path[2][3];
				break;
			}
			else if(vertexlist.size() == 2 && vertexlist.contains("A") && vertexlist.contains("B")){
				minpath = Math.min(Path[2][0], Path[2][1]);
				break;
			}
			else if(vertexlist.size() == 2 && vertexlist.contains("A") && vertexlist.contains("D")){
				minpath = Math.min(Path[2][0], Path[2][3]);
				break;
			}
			else if(vertexlist.size() == 2 && vertexlist.contains("B") && vertexlist.contains("D")){
				minpath = Math.min(Path[2][1], Path[1][3]);
				break;
			}
			else{ //if(vertexlist.size() == 3 && vertexlist.contains("A") && vertexlist.contains("B") && vertexlist.contains("D"))
				i=2;
				minpath = Path[i][i+1];
				for (int j=0; j<3; j++){
					if(Path[i][j]==0){
						continue;
					}
					else{
						minpath = Math.min(minpath, Path[i][j]);
					}
				}
				break;
			}
		case "D":
			if(vertexlist.size() == 1 && vertexlist.contains("A")){
				minpath = Path[3][0];
				break;
			}
			else if(vertexlist.size() == 1 && vertexlist.contains("B")){
				minpath = Path[3][1];
				break;
			}
			else if(vertexlist.size() == 1 && vertexlist.contains("C")){
				minpath = Path[3][2];
				break;
			}
			else if(vertexlist.size() == 2 && vertexlist.contains("A") && vertexlist.contains("B")){
				minpath = Math.min(Path[3][0], Path[3][1]);
				break;
			}
			else if(vertexlist.size() == 2 && vertexlist.contains("A") && vertexlist.contains("C")){
				minpath = Math.min(Path[3][0], Path[3][2]);
				break;
			}
			else if(vertexlist.size() == 2 && vertexlist.contains("B") && vertexlist.contains("C")){
				minpath = Math.min(Path[3][1], Path[3][2]);
				break;
			}
			else{ //if(vertexlist.size() == 3 && vertexlist.contains("A") && vertexlist.contains("B") && vertexlist.contains("C"))
				i=3;
				minpath = Path[i][i-1]; //A, B, C�� ���� i+1�� �Ͽ����� D�� ���� i=3�̹Ƿ� i+1�� �ϸ� �迭�� ũ�⸦ �Ѿ ������ �߻��Ѵ�. ���� i-1�� ���ش�.
				for (int j=0; j<3; j++){
					if(Path[i][j]==0){
						continue;
					}
					else{
						minpath = Math.min(minpath, Path[i][j]);
					}
				}
				break;
			}
		}
		weight = weight + minpath;
	}
	
	/*
	 * Method: moveNextVertex()
	 * description: ���õ� path�� ��뿡 ���� �̵� �� vertex�� �ʱ�ȭ �����ش�. ������ vertex ���� �����Ͽ� ���⼺�� �־���. �� ���� ���õ� vertex�� ��������� ����� ��� ���ش�.
	 * Variables: minpath -> ã�Ƴ� �ּ� ����� path���� �����ͼ� �ش� ��뿡(���ǿ�)�´� vertex�� �����ϱ� ���� ����Ͽ���. 
	 * selectedvertex -> ������ ���õ� vertex�� �����Ͽ� path �̵� �� vertex�� ������ �����ϱ� ���� ����Ͽ���.
	 */
	public void moveNextVertex(){
		switch(minpath){
		case 3:
			if(selectedvertex == "C"){
				selectedvertex = "D";
			}
			else{
				selectedvertex = "C";
			}
			break;
		case 5:
			if(selectedvertex == "A"){
				selectedvertex = "B";
			}
			else{
				selectedvertex = "A";
			}
			break;
		case 6:
			if(selectedvertex == "A"){
				selectedvertex = "C";
			}
			else{
				selectedvertex = "A";
			}
			break;
		case 7:
			if(selectedvertex == "B"){
				selectedvertex = "C";
			}
			else{
				selectedvertex = "B";
			}
			break;
		case 8:
			if(selectedvertex == "A"){
				selectedvertex = "D";
			}
			else{
				selectedvertex = "A";
			}
			break;
		case 10:
			if(selectedvertex == "B"){
				selectedvertex = "D";
			}
			else{
				selectedvertex = "B";
			}
			break;
		}
		System.out.println("���� ���õ� Vertex : "+selectedvertex);
		System.out.println("�̵� ��� : "+minpath+"\n��������� weight : "+weight);
		addVertexToList();
	}
	
	/*
	 * Method: findResultOfCircuit()
	 * description: ���� �Լ����� ����Ͽ� vertexlist�� ��� ��ŷ(����)�� �� ���� ���ѷ����� ������ �Լ��̴�. ���� vertexlist�� ��� ��ŷ(����)�Ǿ����� �ٽ� startvertex�� ���ư��� pathlist�� ��� �� �ش� ����� �����ְ� ���α׷��� �����Ѵ�.
	 * ���� ���� �׷��������� C, D�� ������ �� ������ vertex�� B�� �ǰ� A, B�� ������ �� ������ vertex�� D�� �Ǿ� �ű⿡ �ش��ϴ� ���ǹ��� ����Ͽ���.
	 * Variables: weight -> ���� ����� �����ϱ� ���� ���Ǿ���.
	 * startvertex -> vertexlist�� ��� ��ŷ�Ǿ��� �� ������ vertex ���� �����Ͽ� path�� ����� �˱� ���� ���Ǿ���.
	 * selectedvertex -> ������ ���õ� vertex�� �����Ͽ� path �̵� �� vertex�� ������ �����ϱ� ���� ����Ͽ���.
	 */
	
	public void findResultOfCircuit(){
		for(;;){
			if (vertexlist.size() == 0){ //��� vertex�� ��ŷ�Ǿ��� ��
				pathlist.add(startvertex);
				switch(selectedvertex){
				case "B":
					switch(startvertex){
					case "C": //B->C
						weight = weight + Path[1][2];
						break;
					case "D": //B->D
						weight = weight + Path[1][3];
					}
					break;
				case "D":
					switch(startvertex){
					case "A":
						weight = weight + Path[3][0];
						break;
					case "B":
						weight = weight + Path[3][1];
					}
					break;
				}
				System.out.println("_______________________________________________");
				System.out.println("���� Pathlist : "+pathlist+"\n���� weight : "+weight+"\n���α׷� ����");
				break;
			}
			else {
				findNextVertex(); //�ּ� ��� path ã��
				moveNextVertex(); //ã�Ƴ� path�� ���� vertex �̵�
			}
		}
	}
}
