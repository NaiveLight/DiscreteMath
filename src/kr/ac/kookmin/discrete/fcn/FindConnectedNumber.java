/*
 * Name : 박 순광
 * Student ID : 20113281
 * Program ID : HW#2 - FindConnectedNumber
 * Description : 임의의 Vertex를 선정하여 해당 Vertex와 연결된 Vertex들을 삭제한다.
 */

package kr.ac.kookmin.discrete.fcn;

import java.util.*;

public class FindConnectedNumber {
	//3부분의 연결된 그래프를 표현하기 위해 3개의 링크드리스트를 생성
	public LinkedList<Number> v1 = new LinkedList<Number>();
	public LinkedList<Number> v2 = new LinkedList<Number>();
	public LinkedList<Number> v3 = new LinkedList<Number>();
	public int vertex;
	int selectedVertex;
	public int count = 0;
	
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

	public void checkGraph(){
		setRandomVertex();
		if (v1.size() == 0 && v2.size() == 0 && v3.size() == 0){
			System.out.println("Graph가 모두 제거되었습니다.");
			System.out.println("C(G) = "+ count + "\n 프로그램 종료");
		}
		else{
			removeGraph(selectedVertex);
			
		}
		System.out.println(".........................");
	}
	}
