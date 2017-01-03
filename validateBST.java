
public class validateBST {

	public static class BinaryTree{
		int x;
		BinaryTree left;
		BinaryTree right;
		
		
		public BinaryTree(int x){
			this.x = x;
		}
	}
	
	static boolean  isBST(BinaryTree t){
		
		if (t == null){
			return true;
		}
		
		if (t.left != null){
			if (t.x < t.left.x ){
				return false;
			}
		}
		
		if (t.right != null){
			if (t.x > t.right.x ){
				return false;
			}
		}
		
		return (isBST(t.left) && isBST(t.right));
		
	}
	
	public static void main(String[] args) {

		BinaryTree t = new BinaryTree(5);
		t.left = new BinaryTree(6);
		
		if (isBST(t)){
			System.out.println("Is a Binary Search Tree.");
		}
		else{
			System.out.println("Is NOT a Binary Search Tree.");
		}
		
		if (isBST(t.left)){
			System.out.println("Is a Binary Search Tree.");
		}
		else{
			System.out.println("Is NOT a Binary Search Tree.");
		}
	}

}
