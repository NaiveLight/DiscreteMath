/*
 * Name : ¹Ú ¼ø±¤
 * Student ID : 20113281
 * Program ID : HW#2 - NearNeighborAlgorithm
 * Description : 
 * Algorithm : 
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
	public String vertex;
	public int weight;
	public LinkedList<String> graphvertex  = new LinkedList<String>();
	public int Path[][] = {{0, 5, 6, 8}, {5, 0, 7, 10}, {6, 7, 0, 3}, {8, 10, 3, 0}};
	
	public void setList(){
		String[] graph = {"A","B","C","D"};
		graphvertex.addAll(4, graph);
	}
	
}
