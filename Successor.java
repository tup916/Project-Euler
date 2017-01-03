//
// Write an algorithm to find the "next" node (i.e., in-order successor) of a given node ina binary search tree.
// You may assume that each node has a link to its parent.

public class Successor {

	public static class BinarySearchTree{
		int x;
		BinarySearchTree left;
		BinarySearchTree right;
		BinarySearchTree parent;
		
		public BinarySearchTree(int x){
			this.x = x;
			this.parent = null;
		}
		
		
		public BinarySearchTree(int x, BinarySearchTree parent){
			this.x = x;
			this.parent = parent;
		}
		
	}
	
	
	static int smallestValue(BinarySearchTree parent){
		
		if (parent.left == null){
			return parent.x;
		}
		else{
			return smallestValue(parent.left);
		}
		
		
	}
	
	static int nextSuccessor(BinarySearchTree tree){
		
		if (tree.right == null){
			//if i don't have a right and I am a left child, i can return my parent.
			if (tree == tree.parent.left){
				return tree.parent.x;
			}
			// but if i am a right child, 
			//then the next successor is the first parent encountered of a left child
			else{
				return findRightParent(tree.parent);
			}
			
		}
		else{
				return smallestValue(tree.right);
		}
		
	}
	
	
	
	
	private static int findRightParent(BinarySearchTree tree) {
		
		if (tree == null){
			return -1;
		}
		
		if (tree.parent != null && tree == tree.parent.left){
			return tree.parent.x;
		}
		else{
			return findRightParent(tree.parent);
		}
		
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree(10);
		tree.left = new BinarySearchTree(5, tree);
		tree.right = new BinarySearchTree(17, tree);
		
		//				10
		//			   /  \
		//			  5	   15		
		
		//Should be 10.			  
		System.out.println(nextSuccessor(tree.left));
		
		//Should be 17
		System.out.println(nextSuccessor(tree));
		
		
		tree.right.left = new BinarySearchTree(13, tree.right);
		
		
		//				10
		//			   /  \
		//			  5	    17
		//				   /
		//				 13
		
		
		//Should be 13
		System.out.println(nextSuccessor(tree));
		
		
		tree.right.right = new BinarySearchTree(20, tree.right);
		
		//				10
		//			   /  \
		//			  5	    17
		//				   /  \
		//				 13   20
		
		
		//Should be -1
		System.out.println(nextSuccessor(tree.right.right));
		
		//Should be 20
		System.out.println(nextSuccessor(tree.right));
				
		
		tree.right.left.right = new BinarySearchTree(14, tree.right.left );
		tree.right.left.right.right = new BinarySearchTree(15, tree.right.left.right );
		
		//				10
		//			   /  \
		//			  5	    17
		//				   /   \
		//				 13     20
		//				  \
		//				  14
		//					\
		//					15
		
		//Should be 15
		System.out.println(nextSuccessor(tree.right.left.right));
				
		//Should be 17
		System.out.println(nextSuccessor(tree.right.left.right.right));
	}

}
