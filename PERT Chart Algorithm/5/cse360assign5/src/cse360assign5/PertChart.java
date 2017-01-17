/**
 * @author Tarek Salama CSE 360 F16 - B29
 * @version Nov 26 16
 * 
 * This class creates a PertChart (ArrayHeap) and finds all paths.
 */

package cse360assign5;

public class PertChart {
	private NetworkTable table;
	private ArrayHeap paths;
	
	/**
	 * Creates the NetworkTable from the input data and then finds all paths.
	 * @param data 
	 */
	PertChart (String[][] data) {
		table = new NetworkTable();
		
		for (int row = 0; row < data.length; row++) {
			String id = data[row][0];
			int val = Integer.parseInt(data[row][1]);
			String pred = data[row][2];
			
			table.add (id, val, pred);	
		}

		table.setSuccessors();
		
		findPaths();
	}
	
	/**
	 * findPaths
	 * 
	 * Finds all paths in Network Table.
	 */
	private void findPaths() {
		paths = new ArrayHeap();
		Boolean succAvail = true;
		
		NetworkEntry entry = table.getFirst();
		StringListExt label = new StringListExt();
		label.add(entry.getLabel());
		paths.insert(entry.getCost(), label);
				
		while (succAvail) {
			succAvail = false;
			ArrayHeap temp = new ArrayHeap();
			while(paths.numEntries() > 0) {
				ArrayHeapEntry topEntry = paths.remove();
				String lastEntryName = topEntry.getList().getLast();
				StringListExt succList = table.getEntry(lastEntryName).getSuccList();
				for (int i = 0; i < succList.length(); i++) {
					NetworkEntry succ = table.getEntry(succList.get(i));
					
					int cost = topEntry.getKey() + succ.getCost();
					StringListExt newList = new StringListExt();
					for (int j = 0; j < topEntry.getList().length(); j++)
						newList.add(topEntry.getList().get(j));
					newList.add(succ.getLabel());
					temp.insert(cost, newList);
					
					if (succ.getSuccList().length() != 0) 
						succAvail = true;
				}					
			}
			
			paths = temp;
		}
	}

	/**
	 * printAllPaths
	 * 
	 * Prints all paths in Network Table.
	 */
	public void printAllPaths () { 
		System.out.println("Paths: ");
		paths.printAll();
	}

}
