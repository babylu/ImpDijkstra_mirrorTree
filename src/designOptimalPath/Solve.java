package designOptimalPath;


import java.util.Date;
import java.util.Random;
import java.util.Scanner;


public class Solve {

	public static void main(String[] args) {
		System.out.println("Please input the number of vertices:");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println("Please input the type of graph(1-normal 2-sparse 3-complete):");
		int typeOfGraph = in.nextInt();
		
		AdjacencyMatrix2DGraph graph2D = new AdjacencyMatrix2DGraph();
		DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();
		ImproveDijkstraAlgorithm improveDijkstraAlgorithm = new ImproveDijkstraAlgorithm();
		
		//generate start and end
		Random random = new Random();
		int startPoint = random.nextInt(n);
		int endPoint = random.nextInt(n);
		while(endPoint == startPoint){
			endPoint = random.nextInt(n);
		}
		
		
		Date date1 = new Date();
		graph2D.GraphGenerator(n, typeOfGraph);
		Date date2 = new Date();
		//dijkstra
		Date date3 = new Date();
		dijkstraAlgorithm.dijkstraAlgorithm(graph2D, n, startPoint);
		Date date4 = new Date();
		//improved dijkstra
		Date date5 = new Date();
		improveDijkstraAlgorithm.improveDijkstraAlgorithm(graph2D, n, startPoint, endPoint);
		Date date6 = new Date();
		
		System.out.println("complete!");
		long generateGraph = date2.getTime() - date1.getTime();
		long dijkstraTakeTime = date4.getTime() - date3.getTime();
		long improveDijkstraTakeTime = date6.getTime() - date5.getTime();
		System.out.println("Generate graph take time:"+generateGraph+" ms");
		System.out.println("Dijkstra take time:"+dijkstraTakeTime+" ms");
		System.out.println("Improve Dijkstra take time:"+improveDijkstraTakeTime+" ms");
	}

}
