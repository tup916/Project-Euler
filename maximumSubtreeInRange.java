// Given a tree and a range in integer A, B, return the maximum size of the subtree fully contained in the tree with all nodes in 
// the specified range. The nodes should be inclusive of both A and B.


public class maximumSubtreeInRange {

	
	public static class Tree{
		int x;
		Tree left;
		Tree right;
		
		
		public Tree(int x){
			this.x = x;
		}
	}
	
	public static class Pair<T1, T2>{
		public T1 first;
		public T2 second;
		
		public Pair(T1 value1, T2 value2){
			first = value1;
			second = value2;
		}
	}
	
	static public Pair<Integer, Boolean> maxSubtreeHelper(Tree t, int A, int B){
		
		if (t == null){
			return new Pair<Integer, Boolean>(new Integer(0), new Boolean(true));
		}
		
		else if ( A <= t.x && t.x <= B){
			Pair<Integer, Boolean> pairLeft =  maxSubtreeHelper(t.left, A, B);
			Pair<Integer, Boolean> pairRight =  maxSubtreeHelper(t.right, A, B);
			
			if (pairLeft.second && pairRight.second){
				pairLeft.first = Math.max(pairLeft.first, pairRight.first) + 1;
				return pairLeft;
			}
			else{
				return new Pair<Integer, Boolean>(Math.max(pairLeft.first, pairRight.first) , new Boolean(false));
			}
		}
		
		else if ( A < t.x &&  B < t.x ){
			Pair<Integer, Boolean> pairLeft =  maxSubtreeHelper(t.left, A, B);
			pairLeft.second = false;
			return pairLeft;
		}
		
		else if ( A > t.x &&  B > t.x ){
			Pair<Integer, Boolean> pairRight =  maxSubtreeHelper(t.right, A, B);
			pairRight.second = false;
			return pairRight;
		}
		else{
			System.out.println("Error: Can never end up here.");
			return null;
		}
		
	}
	
	static public int maxSubtree(Tree t, int A, int B){
		return maxSubtreeHelper(t, A, B).first;
	}
	
	public static void main(String [] args){
		
		Tree t = new Tree(25);
		
		System.out.println("1 == " + maxSubtree(t, 10, 100));
		System.out.println("0 == " + maxSubtree(t, 10, 15));
		System.out.println("0 == " + maxSubtree(t, 100, 110));
		
		
		t.left = new Tree(19);
		t.left.left = new Tree(12);
		t.left.left.left = new Tree(4);
		
		System.out.println("0 == " + maxSubtree(t, 100, 110));
		System.out.println("0 == " + maxSubtree(t, 13, 30));
		System.out.println("2 == " + maxSubtree(t, 3, 13));
		System.out.println("0 == " + maxSubtree(t, 11, 23));
		
		t.left.right = new Tree(22);
		t.left.right.right = new Tree(23);
		t.right = new Tree(39);
		t.right.left = new Tree(28);
		t.right.right = new Tree(48);
		t.right.right.left = new Tree(40);
		
		System.out.println("2 == " + maxSubtree(t, 13, 29));
		System.out.println("3 == " + maxSubtree(t, 0, 29));
		
		t.left.left.right = new Tree(15);
		t.left.left.right.right = new Tree(16);
		t.left.left.right.right.right = new Tree(17);
		t.left.left.right.right.right.right = new Tree(18);
		
		System.out.println("4 == " + maxSubtree(t, 13, 29));
		
		
		
	}
}
