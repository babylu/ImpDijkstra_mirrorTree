package designOptimalPath;

import java.util.ArrayList;


/**
 * @author babylu
 *
 */
public class DijkstraAlgorithm {
	private boolean[] flag;
	private int[] dist;
	private static final int INF = Integer.MAX_VALUE;
	private int[] prev;
	private int start;
	
	/**
	 * Dijkstra Algorithm using 2D Adjacency Matrix
	 * @param graph
	 * @param n
	 * @param startpoint
	 */
	public void dijkstraAlgorithm(AdjacencyMatrix2DGraph graph, int n,int startpoint) {
		start = startpoint;
		flag = new boolean[n];
		dist = new int[n];
		prev = new int[n];
		
		//Initial data
		for(int i=0;i<n;i++){
			flag[i] = false;
			dist[i] = graph.getEdges()[start][i];
			prev[i] = start;
		}
		flag[start] = true;
		
		int position = 0;
		for (int i = 1; i < dist.length; i++) {
			int min = INF;
			for(int j=0;j<dist.length;j++){
				if(dist[j]<min && !flag[j]){
					min = dist[j];
					position = j;
				}
			}
			flag[position] = true;
			for(int j=0;j<dist.length;j++){
				if(graph.getEdges()[position][j] != INF && graph.getEdges()[position][j]+dist[position] < dist[j]){
					dist[j] = graph.getEdges()[position][j]+dist[position];
					prev[j] = position; 
				}
			}
		}
	}

	
	
	/**
	 * Get the routine string as normal thought, 0 is translated into 1 and so on
	 * @param dest
	 * @return routine
	 */
	public String getRoutine(int dest){
		String s = "";
		ArrayList<Integer> routineList = new ArrayList<Integer>();
		int j = dest;
		while(j != start){
			routineList.add(j);
			j = prev[j];
		}
		routineList.add(j);
		for (int i = routineList.size()-1; i > 0; i--){
			s += "v" + (routineList.get(i) + 1) + "->";
		}
		s += "v" + (routineList.get(0) + 1);
		return s;
	}
	
	
	
	
	public int[] getDist() {
		return dist;
	}


	public void setDist(int[] dist) {
		this.dist = dist;
	}


	public int[] getPrev() {
		return prev;
	}


	public void setPrev(int[] prev) {
		this.prev = prev;
	}


	public int getStart() {
		return start;
	}


	public void setStart(int start) {
		this.start = start;
	}
	
}
