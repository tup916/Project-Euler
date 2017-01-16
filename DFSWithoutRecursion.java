import java.util.HashSet;
import java.util.Stack;

public class DFSWithoutRecursion {
	public static class Tree{
		Integer x;
		Tree left;
		Tree right;
		
		public Tree(Integer val){
			this.x = val;
		}
	}
	public static boolean DFSPreOrder(Tree t,  Integer element){
		
		Stack<Tree> stack = new Stack<Tree>();
		boolean found = false;
		stack.push(t);
//		if (t.right != null) stack.push(t.right);
//		if (t.left != null) stack.push(t.left);
		
		while (!stack.isEmpty()){
			
			Tree tempTree = stack.pop();
			System.out.println("Considering " + tempTree.x);
//			if (tempTree.x == element){
//				found = true;
//				break;
//			}
			if (tempTree.right != null) stack.push(tempTree.right);
			if (tempTree.left != null) stack.push(tempTree.left);
			
			
		}

		return found;
	}
	
	
	public static boolean DFSPostOrder(Tree t,  Integer element){
		
		Stack<Tree> stack = new Stack<Tree>();
		boolean found = false;
		stack.push(t);
		HashSet<Tree> visited = new HashSet<Tree>();
		visited.add(t);
		
		while (!stack.isEmpty()){
			Tree tempTree = null;
			if ((stack.peek().left == null && stack.peek().right == null) || (visited.contains(stack.peek().right) && visited.contains(stack.peek().left))){
				tempTree = stack.pop();
				System.out.println("Considering " + tempTree.x);
				if (tempTree.x == element){
					found = true;
					break;
				}
				visited.add(tempTree);
				
			}
			else{
				tempTree = stack.peek();
				if (tempTree.right != null && !visited.contains(tempTree.right)) stack.push(tempTree.right);
				if (tempTree.left != null && !visited.contains(tempTree.left)) stack.push(tempTree.left);
			
			}
		}

		return found;
	}
	
	
	public static boolean DFSinOrder(Tree t,  Integer element){
		
		Stack<Tree> stack = new Stack<Tree>();
		boolean found = false;
		stack.push(t);
		HashSet<Tree> visited = new HashSet<Tree>();
		visited.add(t);
		
		while (!stack.isEmpty()){
			Tree tempTree = null;
			if ((stack.peek().left == null ) || ( visited.contains(stack.peek().left))){
				tempTree = stack.pop();
				System.out.println("Considering " + tempTree.x);
				if (tempTree.x == element){
					found = true;
					break;
				}
				visited.add(tempTree);
				
			}
			else{
				tempTree = stack.pop();
				if (tempTree.right != null && !visited.contains(tempTree.right)) stack.push(tempTree.right);
				stack.push(tempTree);
				if (tempTree.left != null && !visited.contains(tempTree.left)) stack.push(tempTree.left);
			
			}
		}

		return found;
	}
	
	public static void main(String[] args) {
		Tree tree = new Tree(10);
		tree.left = new Tree(5);
		tree.right = new Tree(15);
		tree.left.left = new Tree(2);
		tree.left.right = new Tree(7);	
		tree.right.left = new Tree(12);
		tree.right.right = new Tree(22);
		
		System.out.println("PreOrder");
		DFSPreOrder(tree, 22);
		
		System.out.println("inOrder");
		DFSinOrder(tree, 22);
		
		System.out.println("PostOrder");
		DFSPostOrder(tree, 22);
	}
	
}
