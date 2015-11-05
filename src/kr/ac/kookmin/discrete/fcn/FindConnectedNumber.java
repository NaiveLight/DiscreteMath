/*
 * Name : �� ����
 * Student ID : 20113281
 * Program ID : HW#2 - FindConnectedNumber
 * Description : ������ Vertex�� �����Ͽ� �ش� Vertex�� ����� Vertex���� �����Ѵ�.
 */

package kr.ac.kookmin.discrete.fcn;

import java.util.*;

public class FindConnectedNumber {
	//3�κ��� ����� �׷����� ǥ���ϱ� ���� 3���� ��ũ�帮��Ʈ�� ����
	public LinkedList<Number> v1 = new LinkedList<Number>();
	public LinkedList<Number> v2 = new LinkedList<Number>();
	public LinkedList<Number> v3 = new LinkedList<Number>();
	public int vertex;
	int selectedVertex;
	public int count = 0;
	
	//1~4������ v1���� 5~9������ v2�� 10�� v3�� �ִ´�.
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
	
	//��ü ����Ʈ�� ������ش�.
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
	
	//���� Vertex�� �����Ѵ�.
	public int setRandomVertex(){
		for (int i=0; i<10; i++){
			selectedVertex = 1+(int)(Math.random()*10);
		}
		System.out.println("���õ� Vertex : " + selectedVertex + "\n");
		return selectedVertex;
	}
	
	//���õ� Vertex�� ���� �����ϴ� ����Ʈ�� ����.
	public void removeGraph(int selectedVertex){
				if (0 < selectedVertex && selectedVertex < 5){
					if(v1.isEmpty()){
						System.out.println("�̹� ���� �Ǿ����ϴ�.");
						printGraph();
					}
					else{
						v1.clear();
						count++;
						System.out.println("���õ� Vertex �׷��� ���� �� �׷��� ����\n");
						printGraph();
						System.out.println("���� count �� : "+count);
					}
				}
				else if (4 < selectedVertex && selectedVertex < 10){
					if(v2.isEmpty()){
						System.out.println("�̹� ���� �Ǿ����ϴ�.");
						printGraph();
					}
					else{
						v2.clear();
						count++;
						System.out.println("���õ� Vertex �׷��� ���� �� �׷��� ����\n");
						printGraph();
						System.out.println("���� count �� : "+count);
					}
				}
				else {
					if(v3.isEmpty()){
						System.out.println("�̹� ���� �Ǿ����ϴ�.");
						printGraph();
					}
					else{
						v3.clear();
						count++;
						System.out.println("���õ� Vertex �׷��� ���� �� �׷��� ����\n");
						printGraph();
						System.out.println("���� count �� : "+count);
					}
				}
				System.out.println("");
			
	}

	public void checkGraph(){
		setRandomVertex();
		if (v1.size() == 0 && v2.size() == 0 && v3.size() == 0){
			System.out.println("Graph�� ��� ���ŵǾ����ϴ�.");
			System.out.println("C(G) = "+ count + "\n ���α׷� ����");
		}
		else{
			removeGraph(selectedVertex);
			
		}
		System.out.println(".........................");
	}
	}
