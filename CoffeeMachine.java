/**
 * Given a layout of an office, with w = wall, d = desk, c = coffee machine,
 * in a 2D array of character, computer the minimum distance a person would have
 * to walk from their desk to the nearest coffee machine. 
 */
import java.util.LinkedList;
import java.util.Queue;

public class CoffeeMachine {

	public static class Pair{
		public Integer first;
		public Integer second;
		
		public Pair(Integer t, Integer e){
			this.first = t;
			this.second = e;
		}
	}
	
	public static int[][] distanceToCoffee(char[][] setup){
		
		Queue<Pair> queue = new LinkedList<Pair>();
		int numRows = setup.length;
		int numCols = setup[0].length;
		boolean [][] visited = new boolean[numRows][numCols];
		for (int row=0; row<numRows; row++){
			for (int col=0; col<numCols; col++){
				visited[row][col] = false;
			}
		}
		
		int [][] distance = new int[setup.length][setup[0].length];
		for (int row=0; row<distance.length; row++){
			for (int col=0; col<distance[0].length; col++){
				distance[row][col] = distance.length+1;
			}
		}
		
		for (int row=0; row<setup.length; row++){
			for (int col=0; col<setup[0].length; col++){
				if (setup[row][col] == 'c'){
					distance[row][col] = 0;
					visited[row][col] = true;
					queue.offer(new Pair(row, col));
				}
				if (setup[row][col] == 'w'){
					visited[row][col] = true;
				}
			}
		}
		
		
		while (!queue.isEmpty()){
			
			Pair temp = queue.poll();
			
			if (temp.first+1 < numRows && !visited[temp.first+1][temp.second]){
				distance[temp.first+1][temp.second] = Math.min(distance[temp.first + 1][temp.second], distance[temp.first][temp.second] + 1);
				visited[temp.first+1][temp.second] = true;
				queue.offer(new Pair(temp.first+1, temp.second));
			}
			if (temp.first-1 >=0 && !visited[temp.first-1][temp.second]){
				distance[temp.first-1][temp.second] = Math.min(distance[temp.first - 1][temp.second], distance[temp.first][temp.second] + 1);
				visited[temp.first-1][temp.second] = true;
				queue.offer(new Pair(temp.first-1, temp.second));
			}
			if (temp.second+1 < numCols && !visited[temp.first][temp.second+1]){
				distance[temp.first][temp.second+1] = Math.min(distance[temp.first][temp.second+1], distance[temp.first][temp.second] + 1);
				visited[temp.first][temp.second+1] = true;
				queue.offer(new Pair(temp.first, temp.second+1));
			}
			if (temp.second-1 >= 0 && !visited[temp.first][temp.second-1]){
				distance[temp.first][temp.second-1] = Math.min(distance[temp.first][temp.second-1], distance[temp.first][temp.second] + 1);
				visited[temp.first][temp.second-1] = true;
				queue.offer(new Pair(temp.first, temp.second-1));
			}
		}

		return distance;
	}
	
	public static int distanceToCoffeeFromADesk(int[][] distance, int row, int col){
		return distance[row][col];
	}
	
	public static void main(String[] args) {
		int length = 5;
		char [][] setup = new char [length][length];
		
		for (int row=0; row<length; row++){
			for (int col=0; col<length; col++){
				setup[row][col] = 'd';
			}
		}
		
		setup[4][4] = 'c';
		setup[0][0] = 'c';
		
		int [][] distance = distanceToCoffee(setup);
		
		for (int row=0; row<length; row++){
			for (int col=0; col<length; col++){
				System.out.print(distance[row][col]);
			}
			System.out.println("");
		}
		
		System.out.println("The distance for a person sitting at position 1,3 is " + distanceToCoffeeFromADesk( distance, 1, 3));
	}

}
