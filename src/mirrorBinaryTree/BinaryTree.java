package mirrorBinaryTree;

public class BinaryTree<T> {
	private BinaryTreeNode<T> root; 
	
	public BinaryTree(){
		root = null;
	}
	
	public void addRoot(BinaryTreeNode<T> point) {   
		this.root = point;  
	} 
	
	public void insertNodeToOriginTree(BinaryTreeNode<Integer> fatherNode,BinaryTreeNode<Integer> point) {   
		if(fatherNode.getValue() > point.getValue()){
			if(fatherNode.getLeftPointer() == null){
				fatherNode.setLeftPointer(point);
			}else{
				insertNodeToOriginTree(fatherNode.getLeftPointer(),point);
			}
		}else{
			if(fatherNode.getRightPointer() == null){
				fatherNode.setRightPointer(point);
			}else{
				insertNodeToOriginTree(fatherNode.getRightPointer(),point);
			}
		}
	} 
	
	public boolean isEmpty(){
		return this.root == null;
	}
	
	
	public void preOrder(BinaryTreeNode<T> root){
		if(root != null){
			if(root.getValue() != null){
				System.out.print(root.getValue()+" ");
				preOrder(root.getLeftPointer());
				preOrder(root.getRightPointer());
			}
		}
	}
	
	 public void inOrder(BinaryTreeNode<T> root){
		 if(root != null){
			 if(root.getValue() != null){
				 inOrder(root.getLeftPointer());
				 System.out.print(root.getValue()+" ");
				 inOrder(root.getRightPointer());
			 }
		 }
	}
	 
	public void postOrder(BinaryTreeNode<T> root){
		 if(root != null){
			 if(root.getValue() != null){
				 postOrder(root.getLeftPointer());
				 postOrder(root.getRightPointer());
				 System.out.print(root.getValue()+" ");
			 }
		 }
	}
	
	public static class BinaryTreeNode<T> {
		private T value;
		private BinaryTreeNode<T> leftPointer;
		private BinaryTreeNode<T> rightPointer;
		
		BinaryTreeNode(T data) { 
		    this.setValue(data);  
		    this.setLeftPointer(null);
		    this.setRightPointer(null);  
		}
		BinaryTreeNode() {
		}
		
		public T getValue() {
			return value;
		}
		public void setValue(T value) {
			this.value = value;
		}
		public BinaryTreeNode<T> getLeftPointer() {
			return leftPointer;
		}
		public void setLeftPointer(BinaryTreeNode<T> leftPointer) {
			this.leftPointer = leftPointer;
		}
		public BinaryTreeNode<T> getRightPointer() {
			return rightPointer;
		}
		public void setRightPointer(BinaryTreeNode<T> rightPointer) {
			this.rightPointer = rightPointer;
		}
	}

	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}

}
