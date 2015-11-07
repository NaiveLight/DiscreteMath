/*
 * Name : �� ����
 * Student ID : 20113281
 * Program ID : HW#2 - FindConnectedNumber
 * Description : ������ Vertex�� �����Ͽ� �ش� Vertex�� ����� Vertex���� ������ �� Count�� ����.
 * 				���� �׷����� Vertex�� ��� ������ �� 
 * 				count(=Graph connectivity Number)�� ���ϴ� ���α׷��̴�.
 * Algorithm : G = (V,E) => Graph,	 C = C(G) => Connectivity Number of Graph 
 * 			V' = V  //Graph�� Vertex���� V' ����Ʈ�� ����
 * 			while V' != 0 do //V' ����Ʈ�� ������� ������ do
 * 			   begin
 *			    choose y in V' //select Random Vertex
 *				Find all vertices connected to y and remove
 *				C = C+1
 *			   end
 *			end
 * Variables Used : 
 *  * �����  method
 *  public void setGraph()
 *  -> 1~10�� vertex�� 1~4�� v1���� �����ϰ� 5~9�� v2�� ���� �׸��� 10�� v3�� �����ϴ� �۾��� �����Ѵ�.
 *  
 *  public void printGraph()
 *  -> v1,v2,v3�� �̾ G�� ����Ѵ�.
 *  
 *  public int setRandomVertex()
 *  -> 1~10������ Random Vertex�� �����Ѵ�.
 *  
 *  public void removeGraph(int selectedVertex)
 *  -> ���õ� Vertex�� ����� ��ũ�帮��Ʈ�� ����.
 *  
 *  public void checkConnectivity()
 *  -> setRandomVertex�� removeGraph�� �ݺ��ϸ� Graph�� Connectivity Number�� ���Ѵ�.
 *    Graph�� ��� Vertex�� �����Ǹ� ���α׷��� �����Ѵ�.
 *  
 *  * ����� variables
 *  v1, v2, v3 = LinkedList<Number> v1�� 1~4, v2�� 5~9, v3�� 10�� �����ϵ��� �ϵ��� �Ѵ�.
 *	selectedVertex = 1���� 10������ random ���� �����ϴ� �����̴�.
 *	count = Connectivity Number of Graph�̴�. Vertex ���� �� ������ Vertex ���� �� count�� �����Ѵ�.
 */

package kr.ac.kookmin.discrete.fcn;

import java.util.*;

public class FindConnectedNumber {
	//3�κ��� ����� �׷����� ǥ���ϱ� ���� 3���� ��ũ�帮��Ʈ�� ����
	public LinkedList<Number> v1 = new LinkedList<Number>();
	public LinkedList<Number> v2 = new LinkedList<Number>();
	public LinkedList<Number> v3 = new LinkedList<Number>();
	public int selectedVertex;
	public int count = 0;

	/*
	 * Method : setGraph()
	 * description : setGraph�� ��� ������ 1���� 10������ vertex�� �� �������� �ִ� vertex���� v1,v2,v3�� ����Ʈ�� �Ű� �������ִ� ���̴�.
	 * Variables : 
	 */
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

	public void checkConnectivity(){
		for(;;){
			if (v1.size() == 0 && v2.size() == 0 && v3.size() == 0){
				System.out.println("Graph�� ��� ���ŵǾ����ϴ�.");
				System.out.println("C(G) = "+ count + "\n ���α׷� ����");
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
