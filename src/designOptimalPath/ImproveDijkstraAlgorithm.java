package designOptimalPath;

import java.util.ArrayList;


/**
 * @author babylu
 *
 */
public class ImproveDijkstraAlgorithm {
	private boolean[] flagStart;
	private int[] distStart;
	private int[] prevStart;
	private boolean[] flagEnd;
	private int[] distEnd;
	private int[] prevEnd;
	private int start;
	private int end;
	private static final int INF = Integer.MAX_VALUE;
	private int meetingNode;
	
	/**
	 * Dijkstra Algorithm using 2D Adjacency Matrix
	 * @param graph
	 * @param n
	 * @param startpoint
	 */
	public void improveDijkstraAlgorithm(AdjacencyMatrix2DGraph graph, int n,int startpoint,int endpoint) {
		start = startpoint;
		end = endpoint;
		
		flagStart = new boolean[n];
		distStart = new int[n];
		prevStart = new int[n];
		
		flagEnd = new boolean[n];
		distEnd = new int[n];
		prevEnd = new int[n];
		
		//Initial data
		for(int i=0;i<n;i++){
			flagStart[i] = false;
			distStart[i] = graph.getEdges()[start][i];
			prevStart[i] = start;
			flagEnd[i] = false;
			distEnd[i] = graph.getEdges()[end][i];
			prevEnd[i] = end;
		}
		
		flagStart[start] = true;
		flagEnd[end] = true;
		
		int positionStart = 0;
		int positionEnd = 0;
		for (int i = 1; i < n; i++) {
			//do start
			int min = INF;
			for(int j=0;j<n;j++){
				if(distStart[j]<min && !flagStart[j]){
					min = distStart[j];
					positionStart = j;
				}
			}
			flagStart[positionStart] = true;
			for(int j=0;j<n;j++){
				if(graph.getEdges()[positionStart][j] != INF && graph.getEdges()[positionStart][j]+distStart[positionStart] < distStart[j]){
					distStart[j] = graph.getEdges()[positionStart][j]+distStart[positionStart];
					prevStart[j] = positionStart; 
				}
			}
			
			//stop situation start
			if(flagEnd[positionStart]){
				this.meetingNode = positionStart;
				break;
			}
			
			//do end
			min = INF;
			for(int j=0;j<n;j++){
				if(distEnd[j]<min && !flagEnd[j]){
					min = distEnd[j];
					positionEnd = j;
				}
			}
			flagEnd[positionEnd] = true;
			for(int j=0;j<n;j++){
				if(graph.getEdges()[positionEnd][j] != INF && graph.getEdges()[positionEnd][j]+distEnd[positionEnd] < distEnd[j]){
					distEnd[j] = graph.getEdges()[positionEnd][j]+distEnd[positionEnd];
					prevEnd[j] = positionEnd; 
				}
			}
			
			//stop situation end
			if(flagStart[positionEnd]){
				this.meetingNode = positionEnd;
				break;
			}
		}
	}
	
	/**
	 * Get the routine string as normal thought, 0 is translated into 1 and so on
	 * @param dest
	 * @return routine
	 */
	public String getRoutine(){
		String s = "";
		ArrayList<Integer> routineListStart = new ArrayList<Integer>();
		int j = meetingNode;
		while(j != start){
			routineListStart.add(j);
			j = prevStart[j];
		}
		routineListStart.add(j);
		for (int i = routineListStart.size()-1; i > 0; i--){
			s += "v" + (routineListStart.get(i) + 1) + "->";
		}
		if(routineListStart.get(0) != end){
			s += "v" + (routineListStart.get(0) + 1) + "->";
		}
		
		
		ArrayList<Integer> routineListEnd = new ArrayList<Integer>();
		j = meetingNode;
		while(j != end){
			routineListEnd.add(j);
			j = prevEnd[j];
		}
		routineListEnd.add(j);
		for (int i = 1; i < routineListEnd.size()-1; i++){
			s += "v" + (routineListEnd.get(i) + 1) + "->";
		}
		s += "v" + (routineListEnd.get(routineListEnd.size()-1) + 1);
		return s;
	}

	
	public boolean[] getFlagStart() {
		return flagStart;
	}


	public void setFlagStart(boolean[] flagStart) {
		this.flagStart = flagStart;
	}


	public int[] getDistStart() {
		return distStart;
	}


	public void setDistStart(int[] distStart) {
		this.distStart = distStart;
	}


	public int[] getPrevStart() {
		return prevStart;
	}


	public void setPrevStart(int[] prevStart) {
		this.prevStart = prevStart;
	}


	public boolean[] getFlagEnd() {
		return flagEnd;
	}


	public void setFlagEnd(boolean[] flagEnd) {
		this.flagEnd = flagEnd;
	}


	public int[] getDistEnd() {
		return distEnd;
	}


	public void setDistEnd(int[] distEnd) {
		this.distEnd = distEnd;
	}


	public int[] getPrevEnd() {
		return prevEnd;
	}


	public void setPrevEnd(int[] prevEnd) {
		this.prevEnd = prevEnd;
	}


	public int getStart() {
		return start;
	}


	public void setStart(int start) {
		this.start = start;
	}


	public int getEnd() {
		return end;
	}


	public void setEnd(int end) {
		this.end = end;
	}


	public int getMeetingNode() {
		return meetingNode;
	}


	public void setMeetingNode(int meetingNode) {
		this.meetingNode = meetingNode;
	}
	
}