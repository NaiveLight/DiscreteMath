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
 *			print G and C(G)
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
 *  v1, v2, v3 : LinkedList<Number> v1�� 1~4, v2�� 5~9, v3�� 10�� �����ϵ��� �ϵ��� �Ѵ�.
 *	selectedVertex : 1���� 10������ random ���� �����ϴ� �����̴�.
 *	count : Connectivity Number of Graph�̴�. Vertex ���� �� ������ Vertex ���� �� count�� �����Ѵ�.
 */

package kr.ac.kookmin.discrete.fcn;

import java.util.*;

public class FindConnectedNumber {
	//3�κ��� ����� �׷����� ǥ���ϱ� ���� 3���� ��ũ�帮��Ʈ�� ����
	private LinkedList<Number> v1 = new LinkedList<Number>();
	private LinkedList<Number> v2 = new LinkedList<Number>();
	private LinkedList<Number> v3 = new LinkedList<Number>();
	private int selectedVertex;
	private int count = 0;

	/*
	 * Method : setGraph()
	 * description : 1���� 10������ vertex�� �� �������� �ִ� vertex���� v1,v2,v3�� ����Ʈ�� �߰��Ͽ� ���� �������ִ� �۾��� �����Ѵ�.
	 * Variables : i => 1���� 10������ ���� for������ ������ ���� ��˵Ǿ���.
	 * 			   v1, v2, v3 => �з��� i�� v1,v2,v3�� �з��ϱ� ���� ���Ǿ���. 
	 */
	public void setGraph(){
		for (int i=1; i<11; i++){
			if (0 < i && i < 5){ //i�� 1~4 �� ��
				v1.add(i); //v1�� �߰�
			}
			else if (4 < i && i < 10){ //i�� 5~9 �� ��
				v2.add(i); //v2�� �߰�
			}
			else{ //i�� 10 �� ��
				v3.add(i); //v3�� �߰�
			}
		}
	}
	
	/*
	 * Method : printGraph()
	 * description : Graph�� ���¸� ȭ�鿡 ������ִ� �۾��� �����Ѵ�.
	 * Variables : e => for each���� ����ϱ� ���� ���Ǿ���.
	 * 			   v1, v2, v3 => �� ����Ʈ���� ��ü ������ ���� ����Ͽ� Graph�� ǥ���ϱ� ���� ����Ͽ���. 
	 */
	public void printGraph(){
		System.out.print("Graph : ");
		for (Number e : v1){ //v1 ����Ʈ ��� ���
			System.out.print(e);
		}
		for (Number e : v2){ //v2 ����Ʈ ��� ���
			System.out.print(e);
		}
		for (Number e : v3){ //v3 ����Ʈ ��� ���
			System.out.print(e);
		}
		System.out.println("\n");
	}
	
	/*
	 * Method : setRandomVertex()
	 * description : 1���� 10���� Random Vertex�� �����Ѵ�. �׸��� ���õ� Vertex�� ������ְ� return���ش�.
	 * Variables : i => for���� �����ϱ� ���Ͽ� ���Ǿ���.
	 * 			  selectedVertex => random()�Լ��� ���� ���õ� 1���� 10������ ���� return���ֱ� ���� ���Ǿ���. 
	 */
	public int setRandomVertex(){
		for (int i=0; i<10; i++){
			selectedVertex = 1+(int)(Math.random()*10); //selectedVertex�� int���� 1~10 ���� �����ϰ� ���� 
		}
		System.out.println("���õ� Vertex : " + selectedVertex + "\n");
		return selectedVertex;
	}
	
	/*
	 * Method : removeGraph()
	 * description : selectedVertex���� �޾ƿͼ� �ش� Vertex�� �����ϰ� �ִ� ��ũ�帮��Ʈ�� clear�Ͽ� �����Ѵ�. �׸��� count�� ������Ų �� Graph�� ������ش�.
	 * 				���� �ش� ����Ʈ�� ����� ���� �� Graph�� �˸� �޽����� ������ش�. 
	 * Variables : count => connectivity number of graph�̴�. 
	 * 			  selectedVertex => random()�Լ��� ���� ���õ� 1���� 10������ ���� return���ֱ� ���� ���Ǿ���. 
	 */
	public void removeGraph(int selectedVertex){
				if (0 < selectedVertex && selectedVertex < 5){ //���õ� Vertex�� 1~4�� ��
					if(v1.isEmpty()){	//�̹� Vertex���� �����Ǿ��� ���
						System.out.println("�̹� ���� �Ǿ����ϴ�.");
						printGraph();
					}
					else{ //���õ� Vertex�� ����� Vertex���� ������ ���
						v1.clear(); //����� Vertex ����
						count++; //C(G) ����
						System.out.println("���õ� Vertex ���� �� �׷��� ����\n");
						printGraph();
						System.out.println("���� count �� : "+count);
					}
				}
				else if (4 < selectedVertex && selectedVertex < 10){ //���õ� Vertex�� 5~9�� ��
					if(v2.isEmpty()){	//�̹� Vertex���� �����Ǿ��� ���
						System.out.println("�̹� ���� �Ǿ����ϴ�.");
						printGraph();
					}
					else{
						v2.clear();	//����� Vertex ����
						count++;	 //C(G) ����
						System.out.println("���õ� Vertex ���� �� �׷��� ����\n");
						printGraph();
						System.out.println("���� count �� : "+count);
					}
				}
				else { //���õ� Vertex�� 10�� ��
					if(v3.isEmpty()){	//�̹� Vertex���� �����Ǿ��� ���
						System.out.println("�̹� ���� �Ǿ����ϴ�.");
						printGraph();
					}
					else{
						v3.clear();	//����� Vertex ����
						count++;	 //C(G) ����
						System.out.println("���õ� Vertex ���� �� �׷��� ����\n");
						printGraph();
						System.out.println("���� count �� : "+count);
					}
				}
				System.out.println("");
			
	}

	/*
	 * Method : checkConnectivity()
	 * description : ���� method���� ����Ͽ� Vertex�� ��� ������ �� ���� setRandomVertex()�� removeGraph(selectedVertex)�� �����Ѵ�.
	 * 				 ���� Graph���� Vertex���� ��� �����Ǿ��ٸ� �˸��޽����� count�� ��� �� ���α׷��� �����Ѵ�.
	 * Variables : v1.size(), v2.size(), v3.size() => ����Ʈ���� ��� �����Ǿ����� üũ�ϱ� ���� ���Ǿ���.
	 * 			  selectedVertex => removeGraph()�� �Ķ���ͷ� ���Ǿ���.
	 */
	public void checkConnectivity(){
		for(;;){ //���� ���� ����
			if (v1.size() == 0 && v2.size() == 0 && v3.size() == 0){ //v1,v2,v3 �� ��� ����� ��
				System.out.println("Graph�� ��� ���ŵǾ����ϴ�.");
				System.out.println("C(G) = "+ count + "\n ���α׷� ����");
				break; //���� ���� Ż��, ���α׷� ����
			}
			else{
				setRandomVertex(); //Random Vertex ����
				removeGraph(selectedVertex); //���õ� Random Vertex�� ���� ���� ����� Vertex ����
			}
		System.out.println(".........................");
		}
	}
}
