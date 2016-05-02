package mirrorBinaryTree;

import java.util.Date;

import mirrorBinaryTree.BinaryTree.BinaryTreeNode;

public class TestCase {

	public static void main(String[] args) {
		//////////test case 1///////////
		//generate origin tree
		int[] testCase1 = {34,24,96,10};
		BinaryTree<Integer> orignBinaryTree1 = generateOriginTree(testCase1);
		//generate mirror tree
		GenerateMirrorBinaryTree generateMirrorBinaryTree1 = new GenerateMirrorBinaryTree();
		Date date1 = new Date();
		BinaryTree<Integer> mirrorBinaryTree1 = generateMirrorBinaryTree1.generateMirrorBinaryTree(orignBinaryTree1);
		Date date2 = new Date();
		printMirrorBinaryTree(mirrorBinaryTree1,1);
		
		//////////test case 2///////////
		//generate origin tree
		int[] testCase2 = {19,15,30,23,12,18,16};
		BinaryTree<Integer> orignBinaryTree2 = generateOriginTree(testCase2);
		//generate mirror tree
		GenerateMirrorBinaryTree generateMirrorBinaryTree2 = new GenerateMirrorBinaryTree();
		Date date3 = new Date();
		BinaryTree<Integer> mirrorBinaryTree2 = generateMirrorBinaryTree2.generateMirrorBinaryTree(orignBinaryTree2);
		Date date4 = new Date();
		printMirrorBinaryTree(mirrorBinaryTree2,2);
		
		//////////test case 3///////////
		//generate origin tree
		int[] testCase3 = {35,12,23,98,285,54,8,1,9,29,50};
		BinaryTree<Integer> orignBinaryTree3 = generateOriginTree(testCase3);
		//generate mirror tree
		GenerateMirrorBinaryTree generateMirrorBinaryTree3 = new GenerateMirrorBinaryTree();
		Date date5 = new Date();
		BinaryTree<Integer> mirrorBinaryTree3 = generateMirrorBinaryTree3.generateMirrorBinaryTree(orignBinaryTree3);
		Date date6 = new Date();
		printMirrorBinaryTree(mirrorBinaryTree3,3);
		
		//Time cost
		System.out.println("complete!");
		long testcase1Time = date2.getTime() - date1.getTime();
		long testcase2Time = date4.getTime() - date3.getTime();
		long testcase3Time = date6.getTime() - date5.getTime();
		System.out.println("Testcase1 take time:"+testcase1Time+" ms");
		System.out.println("Testcase2 take time:"+testcase2Time+" ms");
		System.out.println("Testcase3 take time:"+testcase3Time+" ms");
		
	}
	
	/**
	 * generateOriginTree
	 * @param testCase
	 * @return orignBinaryTree
	 */
	private static BinaryTree<Integer> generateOriginTree(int[] nodeValueList) {
		BinaryTree<Integer> orignBinaryTree = new BinaryTree<Integer>();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(nodeValueList[0]);
		orignBinaryTree.setRoot(root);
		for(int i=1; i<nodeValueList.length; i++){
			BinaryTreeNode<Integer> point = new BinaryTreeNode<Integer>(nodeValueList[i]);
			orignBinaryTree.insertNodeToOriginTree(root, point);
		}
		
		return orignBinaryTree;
		
		
	}

	private static void printMirrorBinaryTree(BinaryTree<Integer> mirrorBinaryTree, int caseNum) {
		System.out.println("Test case " + caseNum +":");
		System.out.print("The in-order traversal of the mirror tree is: ");
		mirrorBinaryTree.inOrder(mirrorBinaryTree.getRoot());
		System.out.println();
		System.out.print("The pre-order traversal of the mirror tree is: ");
		mirrorBinaryTree.preOrder(mirrorBinaryTree.getRoot());
		System.out.println("\n");
	}

}
