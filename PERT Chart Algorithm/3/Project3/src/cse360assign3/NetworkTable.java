package cse360assign3;

/**
 * @author Tarek Salama CSE 360 F16 - B29
 * @version October 4 16
 * 
 * This class creates a NetworkTable of NetworkEntry entries, 
 *   populates the successor list, and prints the NetworkTable.
 */

import java.util.ArrayList;

public class NetworkTable {
	private ArrayList<NetworkEntry> table;
	private StringListExt lookup;

	NetworkTable() {
		table = new ArrayList<NetworkEntry>();
		lookup = new StringListExt();
	}

	/**
	 * Prints the NetworkTable by printing each NetworkEntry
	 */
	public void print() {
		for (NetworkEntry entry : table)
			System.out.println(entry.toString());
	}

	/**
	 * Adds a NetworkEntry to the Table if not found; otherwise the predecessor
	 * is added to the found entry's predecessor list.
	 * 
	 * @param node
	 *            name of entry to be added or retrieved
	 * @param val
	 *            value of node to be added
	 * @param pred
	 *            predecessor to be added to the entry
	 */
	public void add(String node, int val, String pred) {
		NetworkEntry entry;

		int index = lookup.search(node);

		if (index == -1) {
			entry = new NetworkEntry(node, val, pred);

			table.add(entry);
			lookup.add(node);
		} else {
			entry = table.get(index);
			entry.addPred(pred);
		}
	}

	/**
	 *  Populates the successor list for each NetworkEntry.
	 */
	public void setSuccessors() {
		for (NetworkEntry entry : table) {

			StringListExt preds = entry.getPredList();
			String succ = entry.getLabel();

			for (String pred : preds.list) {
				String node = pred;

				int index = lookup.search(node);

				if (index != -1)
					table.get(index).addSucc(succ);
			}
		}
	}
}
