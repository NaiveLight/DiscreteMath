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
 *			print G and C(G)
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
 *  v1, v2, v3 : LinkedList<Number> v1은 1~4, v2는 5~9, v3는 10을 포함하도록 하도록 한다.
 *	selectedVertex : 1부터 10까지의 random 값을 저장하는 변수이다.
 *	count : Connectivity Number of Graph이다. Vertex 선택 후 연관된 Vertex 삭제 시 count가 증가한다.
 */

package kr.ac.kookmin.discrete.fcn;

import java.util.*;

public class FindConnectedNumber {
	//3부분의 연결된 그래프를 표현하기 위해 3개의 링크드리스트를 생성
	private LinkedList<Number> v1 = new LinkedList<Number>();
	private LinkedList<Number> v2 = new LinkedList<Number>();
	private LinkedList<Number> v3 = new LinkedList<Number>();
	private int selectedVertex;
	private int count = 0;

	/*
	 * Method : setGraph()
	 * description : 1부터 10까지의 vertex들 중 연관성이 있는 vertex끼리 v1,v2,v3의 리스트에 추가하여 서로 연결해주는 작업을 수행한다.
	 * Variables : i => 1부터 10까지의 수를 for문으로 돌리기 위해 사옹되었다.
	 * 			   v1, v2, v3 => 분류한 i를 v1,v2,v3로 분류하기 위해 사용되었다. 
	 */
	public void setGraph(){
		for (int i=1; i<11; i++){
			if (0 < i && i < 5){ //i가 1~4 일 시
				v1.add(i); //v1에 추가
			}
			else if (4 < i && i < 10){ //i가 5~9 일 시
				v2.add(i); //v2에 추가
			}
			else{ //i가 10 일 시
				v3.add(i); //v3에 추가
			}
		}
	}
	
	/*
	 * Method : printGraph()
	 * description : Graph의 상태를 화면에 출력해주는 작업을 수행한다.
	 * Variables : e => for each문을 사용하기 위해 사용되었다.
	 * 			   v1, v2, v3 => 각 리스트들의 전체 내용을 같이 출력하여 Graph를 표현하기 위해 사용하였다. 
	 */
	public void printGraph(){
		System.out.print("Graph : ");
		for (Number e : v1){ //v1 리스트 모두 출력
			System.out.print(e);
		}
		for (Number e : v2){ //v2 리스트 모두 출력
			System.out.print(e);
		}
		for (Number e : v3){ //v3 리스트 모두 출력
			System.out.print(e);
		}
		System.out.println("\n");
	}
	
	/*
	 * Method : setRandomVertex()
	 * description : 1부터 10까지 Random Vertex를 선택한다. 그리고 선택된 Vertex를 출력해주고 return해준다.
	 * Variables : i => for문을 수행하기 위하여 사용되었다.
	 * 			  selectedVertex => random()함수를 통해 선택된 1부터 10사이의 값을 return해주기 위해 사용되었다. 
	 */
	public int setRandomVertex(){
		for (int i=0; i<10; i++){
			selectedVertex = 1+(int)(Math.random()*10); //selectedVertex에 int형의 1~10 수를 랜덤하게 대입 
		}
		System.out.println("선택된 Vertex : " + selectedVertex + "\n");
		return selectedVertex;
	}
	
	/*
	 * Method : removeGraph()
	 * description : selectedVertex값을 받아와서 해당 Vertex를 포함하고 있는 링크드리스트를 clear하여 삭제한다. 그리고 count를 증가시킨 후 Graph를 출력해준다.
	 * 				만일 해당 리스트가 비워져 있을 시 Graph와 알림 메시지를 출력해준다. 
	 * Variables : count => connectivity number of graph이다. 
	 * 			  selectedVertex => random()함수를 통해 선택된 1부터 10사이의 값을 return해주기 위해 사용되었다. 
	 */
	public void removeGraph(int selectedVertex){
				if (0 < selectedVertex && selectedVertex < 5){ //선택된 Vertex가 1~4일 시
					if(v1.isEmpty()){	//이미 Vertex들이 삭제되었을 경우
						System.out.println("이미 제거 되었습니다.");
						printGraph();
					}
					else{ //선택된 Vertex와 연결된 Vertex들이 존재할 경우
						v1.clear(); //연결된 Vertex 삭제
						count++; //C(G) 증가
						System.out.println("선택된 Vertex 삭제 후 그래프 상태\n");
						printGraph();
						System.out.println("현재 count 수 : "+count);
					}
				}
				else if (4 < selectedVertex && selectedVertex < 10){ //선택된 Vertex가 5~9일 시
					if(v2.isEmpty()){	//이미 Vertex들이 삭제되었을 경우
						System.out.println("이미 제거 되었습니다.");
						printGraph();
					}
					else{
						v2.clear();	//연결된 Vertex 삭제
						count++;	 //C(G) 증가
						System.out.println("선택된 Vertex 삭제 후 그래프 상태\n");
						printGraph();
						System.out.println("현재 count 수 : "+count);
					}
				}
				else { //선택된 Vertex가 10일 시
					if(v3.isEmpty()){	//이미 Vertex들이 삭제되었을 경우
						System.out.println("이미 제거 되었습니다.");
						printGraph();
					}
					else{
						v3.clear();	//연결된 Vertex 삭제
						count++;	 //C(G) 증가
						System.out.println("선택된 Vertex 삭제 후 그래프 상태\n");
						printGraph();
						System.out.println("현재 count 수 : "+count);
					}
				}
				System.out.println("");
			
	}

	/*
	 * Method : checkConnectivity()
	 * description : 위의 method들을 사용하여 Vertex가 모두 삭제될 때 까지 setRandomVertex()와 removeGraph(selectedVertex)를 실행한다.
	 * 				 만일 Graph내의 Vertex들이 모두 삭제되었다면 알림메시지와 count를 출력 후 프로그램을 종료한다.
	 * Variables : v1.size(), v2.size(), v3.size() => 리스트들이 모두 삭제되었는지 체크하기 위해 사용되었다.
	 * 			  selectedVertex => removeGraph()에 파라미터로 사용되었다.
	 */
	public void checkConnectivity(){
		for(;;){ //무한 루프 진행
			if (v1.size() == 0 && v2.size() == 0 && v3.size() == 0){ //v1,v2,v3 가 모두 비었을 시
				System.out.println("Graph가 모두 제거되었습니다.");
				System.out.println("C(G) = "+ count + "\n 프로그램 종료");
				break; //무한 루프 탈출, 프로그램 종료
			}
			else{
				setRandomVertex(); //Random Vertex 선택
				removeGraph(selectedVertex); //선택된 Random Vertex의 값에 따라 연결된 Vertex 제거
			}
		System.out.println(".........................");
		}
	}
}
