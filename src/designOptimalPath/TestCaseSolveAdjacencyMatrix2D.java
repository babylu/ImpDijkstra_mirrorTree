package designOptimalPath;


public class TestCaseSolveAdjacencyMatrix2D {
	private static final int INF = Integer.MAX_VALUE;
	static ImproveDijkstraAlgorithm improvedij = new ImproveDijkstraAlgorithm();
	static DijkstraAlgorithm dij = new DijkstraAlgorithm();
	
	public static void main(String[] args) {
		
		
		int[][] twoDMatrix1 = {
				{  0,   79,  INF,  INF,   86,  117,  INF,  INF},
				{ 79,    0,  INF,  178,  INF,   83,  INF,   55},
				{INF,  INF,    0,  INF,  102,   43,   42,  130},
				{INF,  178,  INF,    0,  126,  INF,   75,  116},
				{ 86,  INF,  102,  126,    0,  INF,  INF,  INF},
				{117,   83,   43,  INF,  INF,    0,  193,  INF},
				{INF,  INF,   42,   75,  INF,  193,    0,  138},
				{INF,   55,  130,  116,  INF,  INF,  138,    0}
				};
//		System.out.println("Test Case-1");
//		printMatrixInLine(twoDMatrix1,8);
//		idTest2D(0,7,twoDMatrix1,1);
//		dTest2D(0,7,twoDMatrix1,1);
		
		int[][] twoDMatrix2={
				 {  0,  INF,   40,  120,  INF,   95,  129,  140,  INF,  INF,  INF},
				 {INF,    0,  103,  INF,  INF,  INF,  INF,  INF,   72,  INF,  INF},
				 { 40,  103,    0,  104,  INF,   90,  INF,   89,  INF,  INF,  198},
				 {120,  INF,  104,    0,  INF,  INF,  INF,  INF,  INF,  INF,  INF},
				 {INF,  INF,  INF,  INF,    0,   97,  INF,  INF,  112,  INF,  INF},
				 { 95,  INF,   90,  INF,   97,    0,  INF,  146,  INF,  200,  INF},
				 {129,  INF,  INF,  INF,  INF,  INF,    0,  INF,  INF,   40,  INF},
				 {140,  INF,   89,  INF,  INF,  146,  INF,    0,  INF,  INF,  INF},
				 {INF,   72,  INF,  INF,  112,  INF,  INF,  INF,    0,  INF,  INF},
				 {INF,  INF,  INF,  INF,  INF,  200,   40,  INF,  INF,    0,  INF},
				 {INF,  INF,  198,  INF,  INF,  INF,  INF,  INF,  INF,  INF,    0}

		};
		System.out.println("Test Case-2");
		printMatrixInLine(twoDMatrix2,11);
		idTest2D(1,2,twoDMatrix2,2);
		dTest2D(1,2,twoDMatrix2,2);
	}

	/**
	 * Test function for Dijkstra Algorithm for 2D graph
	 * @param start
	 * @param dest
	 * @param matrix must be n*n matrix
	 * @param dij
	 */
	private static void idTest2D(int start,int end, int[][] matrix, int times) {
		System.out.println("Test" + times + " improve dijkstra:");
		int length = matrix.length;
		AdjacencyMatrix2DGraph graph2D = new AdjacencyMatrix2DGraph();
		graph2D.setEdges(matrix);
		improvedij.improveDijkstraAlgorithm(graph2D, length, start, end);
		printImproveDijkstraResult(start, end, improvedij.getMeetingNode());
	}

	/**
	 * Test function for Dijkstra Algorithm for 2D graph
	 * @param start
	 * @param dest
	 * @param matrix must be n*n matrix
	 * @param dij
	 */
	private static void dTest2D(int start, int dest, int[][] matrix, int times) {
		System.out.println("Test" + times + " dijkstra:");
		int length = matrix.length;
		AdjacencyMatrix2DGraph graph2D = new AdjacencyMatrix2DGraph();
		graph2D.setEdges(matrix);
		dij.dijkstraAlgorithm(graph2D, length, start);
		printDijkstraResult(start, dest, dij);
	}
	
	/**
	 * print matrix
	 * @param matrix
	 * @param n
	 */
	private static void printMatrixInLine(int[][] matrix,int n) {
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if (matrix[i][j] == Integer.MAX_VALUE){
					System.out.print('#'+",");
				}else{
					System.out.print(matrix[i][j]+",");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * Print the result of Dijkstra Algorithm
	 * @param start
	 * @param dest
	 * @param dAlgor
	 */
	private static void printImproveDijkstraResult(int start,int end,int meetingNode) {
		System.out.println("Improved dijkstra result:");
		System.out.println("Meeting node: " + (meetingNode+1));
		System.out.println("Routine from v" + (start + 1)  + " to v" + (end + 1) +": "  + improvedij.getRoutine());
		System.out.println("Weight: ");
		System.out.println("v" + (start+1) + " to v"+(meetingNode+1) + ": " + improvedij.getDistStart()[meetingNode]);
		System.out.println("v" + (end+1) + " to v" + (meetingNode+1) + ": " + improvedij.getDistEnd()[meetingNode]);
		System.out.println("Total is: " + (improvedij.getDistStart()[meetingNode] + improvedij.getDistEnd()[meetingNode]));
		System.out.println();
	}
	/**
	 * Print the result of Dijkstra Algorithm
	 * @param start
	 * @param dest
	 * @param dAlgor
	 */
	private static void printDijkstraResult(int start, int dest, DijkstraAlgorithm dAlgor) {
		System.out.println("Dijkstra result:");
		System.out.println("Routine from vertex " + (start + 1)  + " to vertex " + (dest + 1) +": "  + dAlgor.getRoutine(dest));
		System.out.println("Weight:" + dAlgor.getDist()[dest]);
		System.out.println();
	}
}
