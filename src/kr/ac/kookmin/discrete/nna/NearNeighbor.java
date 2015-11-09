/*
 * Name : 박 순광
 * Student ID : 20113281
 * Program ID : HW#2 - NearNeighborAlgorithm
 * Description : 
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
 *  
 */

package kr.ac.kookmin.discrete.nna;

import java.util.*;

public class NearNeighbor {
	public int vertex;
	public String RandomVertex;
	public int weight;
	public LinkedList<String> vertexlist  = new LinkedList<String>();
	public LinkedList<String> pathlist = new LinkedList<String>();
	public int Path[][] = {{0, 5, 6, 8}, {5, 0, 7, 10}, {6, 7, 0, 3}, {8, 10, 3, 0}};
	
	public void setGraph(){
		vertexlist.add("A");
		vertexlist.add("B");
		vertexlist.add("C");
		vertexlist.add("D");
	}
	
	public void setRandomVertex(){
		vertex = (int)(Math.random()*4);
		RandomVertex = vertexlist.get(vertex);
		System.out.println("선택된 Vertex : " + RandomVertex);
		vertexlist.remove(vertex);
		pathlist.add(RandomVertex);
		System.out.println("남은 Vertex : "+vertexlist+"\n"+"Pahtlist : "+pathlist);

	}
	
}
