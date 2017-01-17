package cse360assign3;

/**
 * 
 * @author D. Calliss for CSE360 Fall 2016
 *
 * This program will serve as a test driver for the 3rd assignment.  The array contains 
 * the list of node names, costs and predecessors in network.  The program will initialize
 * the contents of a network table and then print the contents of the table showing the name, 
 * cost, predecessors of each node and successors of each node in the network.
 */

public class Driver {

	public static void main(String[] args) {
		
		String [][] data = {
				{"A", "3", "-"},  // first node has no predecessor
				{"B", "5", "A"},
				{"C", "4", "A"},
				{"D", "2", "B"},
				{"E", "4", "F"},
				{"D", "2", "C"},
				{"E", "4", "D"},
				{"F", "6", "C"},
		};
		
		NetworkTable table = new NetworkTable();
		
		for (int row = 0; row < data.length; row++) {
			String id = data[row][0];
			int val = Integer.parseInt(data[row][1]);
			String pred = data[row][2];
			
			table.add (id, val, pred);	
		}

		table.setSuccessors();
		table.print();
		
		System.out.println("done");
	}

}