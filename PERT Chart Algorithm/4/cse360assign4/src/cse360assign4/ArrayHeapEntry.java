/**
 * @author Tarek Salama CSE 360 F16 - B29
 * @version October 30 16
 * 
 * This class creates an ArrayHeapEntry with a key and a corresponding list
 */


package cse360assign4;

public class ArrayHeapEntry {
	private int key;
	private StringListExt list;

	ArrayHeapEntry(int key, StringListExt list) {
		this.key = key;
		this.list = list;
	}

	/**
	 * 
	 * @return entry key
	 */
	public int getKey() {
		return key;
	}

	/**
	 * 
	 * @return entry list
	 */
	public StringListExt getList() {
		return list;
	}

	/**
	 * returns a string representation of the entry key followed by its corresponding list
	 */
	public String toString() {
		return key + " " + list;
	}
}
