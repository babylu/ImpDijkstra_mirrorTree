package mirrorBinaryTree;

import mirrorBinaryTree.BinaryTree.BinaryTreeNode;

/**
 * @author babylu
 *
 */
public class GenerateMirrorBinaryTree {
	public BinaryTree<Integer> mirrorBinaryTree = new BinaryTree<Integer>();
	public BinaryTree<Integer> orignBinaryTree = new BinaryTree<Integer>();
	
	/**
	 * generateMirrorBinaryTree
	 * @param inputBinaryTree
	 * @return mirrorBinaryTree
	 */
	public BinaryTree<Integer> generateMirrorBinaryTree(BinaryTree<Integer> inputBinaryTree){
		orignBinaryTree = inputBinaryTree;
		BinaryTreeNode<Integer> orignRoot = orignBinaryTree.getRoot();
		BinaryTreeNode<Integer> mirrorRoot = new BinaryTreeNode<Integer>(orignRoot.getValue());
		preOrderCopyToMirror(mirrorRoot,orignRoot);
		this.mirrorBinaryTree.setRoot(mirrorRoot);
		return mirrorBinaryTree;
		
	}
	/**
	 * preOrderCopyToMirror
	 * @param mirrorRoot
	 * @param orignRoot
	 */
	public void preOrderCopyToMirror(BinaryTreeNode<Integer> mirrorRoot,BinaryTreeNode<Integer> orignRoot){
		if(orignRoot!=null){
			mirrorRoot.setValue(orignRoot.getValue());
			BinaryTreeNode<Integer> mirrorRootLeft = new BinaryTreeNode<Integer>();
			BinaryTreeNode<Integer> mirrorRootRight = new BinaryTreeNode<Integer>();
			mirrorRoot.setLeftPointer(mirrorRootLeft);
			mirrorRoot.setRightPointer(mirrorRootRight);
			preOrderCopyToMirror(mirrorRoot.getLeftPointer(),orignRoot.getRightPointer());
			preOrderCopyToMirror(mirrorRoot.getRightPointer(),orignRoot.getLeftPointer());
		}
	}
	
	/**
	 * 
	 * @param root1
	 * @param root2
	 */
	public boolean compareTwoBinaryTree(BinaryTreeNode<Integer> root1,BinaryTreeNode<Integer> root2){
		if(root1 != null && root2 != null){
			if(root1.getValue() != root2.getValue()){
				return false;
			}else{
				BinaryTreeNode<Integer> root1Left = root1.getLeftPointer();
				BinaryTreeNode<Integer> root1Right = root1.getRightPointer();
				BinaryTreeNode<Integer> root2Left = root2.getLeftPointer();
				BinaryTreeNode<Integer> root2Right = root2.getRightPointer();
				
				compareTwoBinaryTree(root1Left,root2Right);
				compareTwoBinaryTree(root1Right,root2Left);
			}
		}else if((root1 == null && root2 != null) || (root2 == null && root1 != null)){
			return false;
		}
		return true;
	}
}
