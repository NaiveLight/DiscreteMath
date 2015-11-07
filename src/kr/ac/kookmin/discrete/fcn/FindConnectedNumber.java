/*
 * Name : 박 순광
 * Student ID : 20113281
 * Program ID : HW#2 - FindConnectedNumber
 * Description : 임의의 Vertex를 선정하여 해당 Vertex와 연결된 Vertex들을 삭제한 후 Count를 센다.
 * 				이후 그래프의 Vertex가 모두 삭제된 후 
 * 				count(=Graph connectivity Number)를 구하는 프로그램이다.
 * Algorithm : G = (V,E) => Graph,	 C = C(G) => Connectivity Number of Graph 
 * 			V' = V  //Graph의 Vertex들을 V' 리스트에 정렬
 * 			while V' != 0 do //V' 리스트가 비어있지 않으면 do
 * 			   begin
 *			    choose y in V' //select Random Vertex
 *				Find all vertices connected to y and remove
 *				C = C+1
 *			   end
 *			end
 * Variables Used : 
 *  * 사용한  method
 *  public void setGraph()
 *  -> 1~10의 vertex를 1~4는 v1으로 연결하고 5~9는 v2로 연결 그리고 10은 v3로 연결하는 작업을 수행한다.
 *  
 *  public void printGraph()
 *  -> v1,v2,v3를 이어서 G를 출력한다.
 *  
 *  public int setRandomVertex()
 *  -> 1~10까지의 Random Vertex를 선택한다.
 *  
 *  public void removeGraph(int selectedVertex)
 *  -> 선택된 Vertex와 연결된 링크드리스트를 비운다.
 *  
 *  public void checkConnectivity()
 *  -> setRandomVertex와 removeGraph를 반복하며 Graph의 Connectivity Number를 구한다.
 *    Graph의 모든 Vertex가 삭제되면 프로그램을 종료한다.
 *  
 *  * 사용한 variables
 *  v1, v2, v3 = LinkedList<Number> v1은 1~4, v2는 5~9, v3는 10을 포함하도록 하도록 한다.
 *	selectedVertex = 1부터 10까지의 random 값을 저장하는 변수이다.
 *	count = Connectivity Number of Graph이다. Vertex 선택 후 연관된 Vertex 삭제 시 count가 증가한다.
 */

package kr.ac.kookmin.discrete.fcn;

import java.util.*;

public class FindConnectedNumber {
	//3부분의 연결된 그래프를 표현하기 위해 3개의 링크드리스트를 생성
	public LinkedList<Number> v1 = new LinkedList<Number>();
	public LinkedList<Number> v2 = new LinkedList<Number>();
	public LinkedList<Number> v3 = new LinkedList<Number>();
	public int selectedVertex;
	public int count = 0;

	/*
	 * Method : setGraph()
	 * description : setGraph의 사용 목적은 1부터 10까지의 vertex들 중 연관성이 있는 vertex끼리 v1,v2,v3의 리스트로 옮겨 연결해주는 것이다.
	 * Variables : 
	 */
	//1~4까지는 v1으로 5~9까지는 v2로 10은 v3로 넣는다.
	public void setGraph(){
		for (int i=1; i<11; i++){
			if (0 < i && i < 5){
				v1.add(i);
			}
			else if (4 < i && i < 10){
				v2.add(i);
			}
			else{
				v3.add(i);
			}
		}
	}
	
	//전체 리스트를 출력해준다.
	public void printGraph(){
		System.out.print("Graph : ");
		for (Number e : v1){
			System.out.print(e);
		}
		for (Number e : v2){
			System.out.print(e);
		}
		for (Number e : v3){
			System.out.print(e);
		}
		System.out.println("\n");
	}
	
	//랜덤 Vertex를 선택한다.
	public int setRandomVertex(){
		for (int i=0; i<10; i++){
			selectedVertex = 1+(int)(Math.random()*10);
		}
		System.out.println("선택된 Vertex : " + selectedVertex + "\n");
		return selectedVertex;
	}
	
	//선택된 Vertex의 값이 존재하는 리스트를 비운다.
	public void removeGraph(int selectedVertex){
				if (0 < selectedVertex && selectedVertex < 5){
					if(v1.isEmpty()){
						System.out.println("이미 제거 되었습니다.");
						printGraph();
					}
					else{
						v1.clear();
						count++;
						System.out.println("선택된 Vertex 그래프 삭제 후 그래프 상태\n");
						printGraph();
						System.out.println("현재 count 수 : "+count);
					}
				}
				else if (4 < selectedVertex && selectedVertex < 10){
					if(v2.isEmpty()){
						System.out.println("이미 제거 되었습니다.");
						printGraph();
					}
					else{
						v2.clear();
						count++;
						System.out.println("선택된 Vertex 그래프 삭제 후 그래프 상태\n");
						printGraph();
						System.out.println("현재 count 수 : "+count);
					}
				}
				else {
					if(v3.isEmpty()){
						System.out.println("이미 제거 되었습니다.");
						printGraph();
					}
					else{
						v3.clear();
						count++;
						System.out.println("선택된 Vertex 그래프 삭제 후 그래프 상태\n");
						printGraph();
						System.out.println("현재 count 수 : "+count);
					}
				}
				System.out.println("");
			
	}

	public void checkConnectivity(){
		for(;;){
			if (v1.size() == 0 && v2.size() == 0 && v3.size() == 0){
				System.out.println("Graph가 모두 제거되었습니다.");
				System.out.println("C(G) = "+ count + "\n 프로그램 종료");
				break;
			}
			else{
				setRandomVertex();
				removeGraph(selectedVertex);
			}
		System.out.println(".........................");
		}
	}
	}
