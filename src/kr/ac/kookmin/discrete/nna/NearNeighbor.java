/*
 * Name : 박 순광
 * Student ID : 20113281
 * Program ID : HW#2 - NearNeighborAlgorithm
 * Description : 임의의 Vertex를 선정하여 이웃하고 있는 Vertex들 중 가장 최소 비용의 path를 통해 이동한다. 단 모든 Vertex들은 정확히 1번씩만 방문하여 시작한 Vertex로 돌아온다.
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
 * *사용한 method
 * public void setGraph() -> A, B, C, D 의 vertex로 이루어진 그래프를 리스트로 생성한다.
 * public void setRandomVertex() -> 처음 시작할 임의의 vertex를 정하여 출력한다.
 * public void addVertexToList() -> 선택된 vertex를 마킹(삭제)하고 경로를 pathlist에 추가한다.
 * public void findNextVertex() -> 각 상황에 맞는 최소 weight의 path를 가지는 vertex를 찾고 그에 따른 weight을 증가시킨다.
 * public void moveNextVertex() -> 위의 함수에서 찾은 vertex로 이동한다.
 * public void findResultOfCircuit() -> 무한루프를 통해 최종 pathlist와 weight을 출력해준다.
 * *사용한 Variables
 * int randomvertex -> 0~3까지 임의의 수를 정한 후 그에 따른 vertexlist의 인덱스에 해당하는 vertex를 가져온다. 
 * String startvertex -> 시작 Vertex를 저장하기 위한 변수이다.
 * String selectedvertex -> 초기에 선택된 vertex로 초기화 되며 이후 찾아낸 최소 비용의 vertex로 갱신된다.
 * int weight -> 0으로 초기화 하였고 path를 찾을 시 마다 계속 갱신된다.
 * int minpath -> 각 조건에 맞는 최소 비용 값으로 갱신된다.
 * LinkedList<String> vertexlist -> 초기 Graph를 표현하기 위한 링크드리스트이다.
 * LinkedList<String> pathlist -> 경로를 표현하기 위한 링크드리스트이다.
 * int Path[][] -> A ~ D까지의 비용을 2차원 배열로 초기화 하였다.
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
	 * description : vertexlist에 Graph를 초기화하기 위한 함수이다.
	 * Variables : vertexlist -> Vertex A, B, C, D를 추가하기 위해 사용되었다.
	 */
	public void setGraph(){
		vertexlist.add("A");
		vertexlist.add("B");
		vertexlist.add("C");
		vertexlist.add("D");
	}
	
	/*
	 * Method : setRandomVertex()
	 * description : 임의의 시작 Vertex를 정하기 위한 함수이다.
	 * Variables : randomvertex -> 0~3까지의 난수 생성 후 저장하기 위해 사용되었다.
	 *             selectedvertex -> 생성된 난수의 index에 해당하는 vertex를 저장하기 위해 사용되었다.
	 *             startvertex -> 시작 vertex를 저장하기 위해 사용되었다.
	 */
	
	public void setRandomVertex(){
			randomvertex = (int)(Math.random()*4); //임의로 vertex의 index값을 선택
			selectedvertex = vertexlist.get(randomvertex); //선택된 난수 값에 해당하는 index의 vertex를 저장
			startvertex = selectedvertex;
			System.out.println("시작 Vertex : " + selectedvertex);
			addVertexToList();
	}
	
	/*
	 * Method: addVertexToList()
	 * description: 선택된 vertex를 vertexlist에서 마킹(삭제)하고 pathlist에 추가하기 위한 함수이다. 또한 vertexlist와 pathlist를 출력해준다.
	 * Variables: selectedvertex -> 선택된 vertex를 vertexlist에서 삭제하고 pathlist에 추가하기 위해 사용되었다.
	 */
	public void addVertexToList(){
		vertexlist.remove(selectedvertex); 
		pathlist.add(selectedvertex);
		System.out.println("...................................................");
		System.out.println("남은 Vertex : "+vertexlist+"\n"+"Pathlist : "+pathlist);
	}

	/*
	 * Method: findNextVertex()
	 * description: 현재 선택된 vertex에서 vertexlist의 상태를 조건으로 삼아 최소 비용의 path를 찾으며 해당 path의 비용만큼 weight을 증가시켜 준다.
	 * Variables: selectedvertex -> 선택된 vertex를 참조하여 switch문을 활용하기 위해 사용되었다.
	 * 			i -> 처음 선택한 vertex일 경우 자신을 제외한 모든 vertex path의 비용중 최소값을 찾는 for문을 사용하기 위해 사용되었다. path의 행에 해당된다.
	 *          j -> path의 열에 해당된다.
	 *          minpath -> Math.min함수를 통해 최소 비용을 저장한다. 단, vertexlist에 1개의 path만 남은 경우는 path를 직접 지정해준다. 
	 *          weight -> path를 선택할 때 마다 총 weight을 구하기 위해 사용되었다.
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
				i=0;//0행
				minpath = Path[i][i+1]; //Path[i][i] == 0 이므로 i+1을 하여 0이 아닌 수로 초기화한다.
				for (int j=0; j<3; j++){
					if(Path[i][j]==0){//자기 자신으로 이동 비용은 0이므로 자기 자신을 다시 선택하는 경우를 제외하기 위해 비용이 0일 시 건너뛴다. 
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
				minpath = Path[i][i-1]; //A, B, C의 경우는 i+1을 하였지만 D의 경우는 i=3이므로 i+1을 하면 배열의 크기를 넘어서 에러가 발생한다. 따라서 i-1을 해준다.
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
	 * description: 선택된 path의 비용에 따라 이동 후 vertex를 초기화 시켜준다. 이전의 vertex 값을 참조하여 방향성을 주었다. 그 이후 선택된 vertex와 현재까지의 비용을 출력 해준다.
	 * Variables: minpath -> 찾아낸 최소 비용의 path값을 가져와서 해당 비용에(조건에)맞는 vertex로 갱신하기 위해 사용하였다. 
	 * selectedvertex -> 이전에 선택된 vertex를 참조하여 path 이동 후 vertex의 값으로 갱신하기 위해 사용하였다.
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
		System.out.println("다음 선택된 Vertex : "+selectedvertex);
		System.out.println("이동 비용 : "+minpath+"\n현재까지의 weight : "+weight);
		addVertexToList();
	}
	
	/*
	 * Method: findResultOfCircuit()
	 * description: 위의 함수들을 사용하여 vertexlist가 모두 마킹(삭제)될 때 까지 무한루프를 돌리는 함수이다. 만일 vertexlist가 모두 마킹(삭제)되었으면 다시 startvertex로 돌아가며 pathlist에 등록 후 해당 비용을 더해주고 프로그램을 종료한다.
	 * 교재 내의 그래프에서는 C, D로 시작할 시 마지막 vertex가 B가 되고 A, B로 시작할 시 마지막 vertex가 D가 되어 거기에 해당하는 조건문만 사용하였다.
	 * Variables: weight -> 최종 비용을 갱신하기 위해 사용되었다.
	 * startvertex -> vertexlist가 모두 마킹되었을 시 시작한 vertex 갑을 참조하여 path의 비용을 알기 위해 사용되었다.
	 * selectedvertex -> 이전에 선택된 vertex를 참조하여 path 이동 후 vertex의 값으로 갱신하기 위해 사용하였다.
	 */
	
	public void findResultOfCircuit(){
		for(;;){
			if (vertexlist.size() == 0){ //모든 vertex가 마킹되었을 시
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
				System.out.println("최종 Pathlist : "+pathlist+"\n최종 weight : "+weight+"\n프로그램 종료");
				break;
			}
			else {
				findNextVertex(); //최소 비용 path 찾기
				moveNextVertex(); //찾아낸 path를 따라 vertex 이동
			}
		}
	}
}
