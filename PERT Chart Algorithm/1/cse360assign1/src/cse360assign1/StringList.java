/** Description of StringList 
 *
 * @author Tarek Salama - PIN B29 - CSE 360 Assign. 1
 * @version September 5, 2016.
 */

package cse360assign1;

import java.util.*;

public class StringList {
	private ArrayList<String> A;
	private int size;
	private boolean debug;

	StringList() {
		A = new ArrayList<String>();
	}

	/**
	 * Description of insert(String v)
	 * 
	 * @param v
	 *            New string to be inserted
	 */
	public void insert(String v) {
		// Debug for each new string
		System.out.println("Debug on? y or n: ");

		Scanner in = new Scanner(System.in);

		char d = in.next().charAt(0);

		if (d == 'n')
			debug = false;
		else
			debug = true;

		// Insert
		if (size == 0) { // New ArrayList
			A.add(v);
			size++;

			if (debug)
				System.out.println("Debug - Size: " + size);
		} else {
			boolean positionFound = false;
			boolean duplicate = false;
			int i = 0;
			int j = 0;

			while (i < size && !positionFound && !duplicate) {
				if (v.compareTo(A.get(i)) < 0)
					positionFound = true;
				else if (v.compareTo(A.get(i)) == 0)
					duplicate = true;
				else {
					j++;
					i++;
				}
			}

			// Insert at beginning or middle of ArrayList
			if (positionFound && !duplicate) {
				A.add("0");
				size++;

				for (int k = size - 1; k > j; k--)
					A.set(k, A.get(k - 1));

				A.set(j, v);

				if (debug)
					System.out.println("Debug - Size: " + A.size());
			} else if (!duplicate) // Insert at end
			{
				A.add(j, v);
				size++;

				if (debug)
					System.out.println("Debug - Size: " + A.size());
			} else if (debug) // Duplicate - No insert
				System.out.println("Debug - Duplicate");
		}

		if (debug)
			System.out.println("Debug - ArrayList: " + toString());
	}

	/**
	 * Description of toString()
	 * 
	 * @return str ArrayList content
	 */
	public String toString() {
		String str = "";

		for (int i = 0; i < size; i++)
			str += A.get(i) + " ";

		return str;
	}

	/**
	 * Description of search(String v)
	 * 
	 * @param v
	 *            String to be searched
	 * @return pos index of String; -1 returned if not found
	 */
	public int search(String v) {
		int pos = -1;

		if (A.size() > 0) {
			pos = 0;
			boolean cont = true;

			while (pos < A.size() && cont) {
				if (A.get(pos).compareTo(v) == 0)
					cont = false;
				else
					pos++;
			}

			if (cont)
				pos = -1;
		}

		return pos;
	}
}