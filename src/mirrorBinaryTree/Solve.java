package mirrorBinaryTree;

import java.util.Date;

import mirrorBinaryTree.BinaryTree.BinaryTreeNode;

public class Solve {

	public static void main(String[] args) {
		int[] nodeList = {34,24,96,10};
		BinaryTree<Integer> BinaryTree1 = generateOriginTree(nodeList);
//		int[] testCase2 = {19,15,30,23,12,18,16};
//		BinaryTree<Integer> BinaryTree2 = generateOriginTree(testCase2);
		BinaryTree<Integer> BinaryTree2 = new BinaryTree<Integer>();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(34);
		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<Integer>(24);
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<Integer>(96);
		BinaryTreeNode<Integer> node3 = new BinaryTreeNode<Integer>(10);
		root.setLeftPointer(node2);
		node1.setRightPointer(node3);
		root.setRightPointer(node1);
		BinaryTree2.setRoot(root);
		
		printBinaryTree(BinaryTree1,1);
		printBinaryTree(BinaryTree2,2);
		GenerateMirrorBinaryTree generateMirrorBinaryTree = new GenerateMirrorBinaryTree();
		Date date1 = new Date();
		boolean result =generateMirrorBinaryTree.compareTwoBinaryTree(BinaryTree1.getRoot(), BinaryTree2.getRoot());
		Date date2 = new Date();
		System.out.println("Judge result is: " + result);
		
		System.out.println("complete!");
		long timeCost = date2.getTime() - date1.getTime();
		System.out.println("Testcase1 take time:" + timeCost + " ms");
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
	
	private static void printBinaryTree(BinaryTree<Integer> binaryTree, int num) {
		System.out.print("The in-order traversal of the tree" + num + " is: ");
		binaryTree.inOrder(binaryTree.getRoot());
		System.out.println();
		System.out.print("The pre-order traversal of the mirror tree" + num + " is: ");
		binaryTree.preOrder(binaryTree.getRoot());
		System.out.println("\n");
	}
}
