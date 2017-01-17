package cse360assign3;

/**
 * @author Tarek Salama - CSE 360 F16 - B29
 * @version October 4 16
 * 
 * This class creates a NetworkEntry entry for a NetworkTable and
 *   implements the accessor and mutator methods.
 */

public class NetworkEntry {
	private String name;
	private int cost;
	private StringListExt predList;
	private StringListExt succList;

	/**
	 * Initializes the class variables and adds pred to the entry's predecessor
	 * list.
	 * 
	 * @param nameval
	 *            name of entry
	 * @param costval
	 *            cost of entry
	 * @param pred
	 *            predecessor of entry
	 */
	NetworkEntry(String nameval, int costval, String pred) {
		name = nameval;
		cost = costval;
		predList = new StringListExt();
		succList = new StringListExt();

		predList.add(pred);
	}

	// Accessors

	/**
	 * @return predecessor list
	 */
	public StringListExt getPredList() {
		return predList;
	}

	/**
	 * @return successor list
	 */
	public StringListExt getSuccList() {
		return succList;
	}

	/**
	 * @return name of entry
	 */
	public String getLabel() {
		return name;
	}

	/**
	 * @return cost of entry
	 */
	public int getCost() {
		return cost;
	}

	// Mutators

	/**
	 * @param str
	 *            string to be added to predecessor list
	 */
	public void addPred(String str) {
		predList.insert(str);
	}

	/**
	 * @param str
	 *            string to be added to successor list
	 */
	public void addSucc(String str) {
		succList.insert(str);
	}

	/**
	 * @return entry String of the entry and its information
	 */
	public String toString() {
		String entry = name + "(" + cost + ") Predecessors: " + predList.toString() + "\tSuccessors: "
				+ succList.toString();

		return entry;
	}
}
