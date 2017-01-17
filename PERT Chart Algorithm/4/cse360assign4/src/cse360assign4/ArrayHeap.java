/**
 * @author Tarek Salama CSE 360 F16 - B29
 * @version October 30 16
 * 
 * This class creates an ArrayHeap of ArrayHeapEntry entries, and allows insertion and removal while maintaining the max heap property.
 */


package cse360assign4;

import java.util.ArrayList;

public class ArrayHeap {
	private ArrayList<ArrayHeapEntry> heap;

	ArrayHeap() {
		heap = new ArrayList<ArrayHeapEntry>();
	}

	/**
	 * insert a new entry and swap with parent while entry key is greater than
	 * parent key
	 * 
	 * @param key
	 *            new entry key
	 * @param list
	 *            new entry list
	 */
	public void insert(int key, StringListExt list) {
		ArrayHeapEntry entry = new ArrayHeapEntry(key, list);
		heap.add(entry);

		int entryIndex = heap.size() - 1;
		int parentIndex = (entryIndex - 1) / 2;

		// Done swapping?
		boolean done = false;

		ArrayHeapEntry parent;

		while (parentIndex >= 0 && !done) {
			parent = heap.get(parentIndex);

			// Swap entry with parent if entry key is greater than parent key
			if (entry.getKey() > parent.getKey()) {
				heap.set(parentIndex, entry);
				heap.set(entryIndex, parent);

				entryIndex = parentIndex;
				parentIndex = (entryIndex - 1) / 2;
			} // Otherwise the final position is found and swapping is complete
			else
				done = true;
		}
	}

	/**
	 * print each heap entry on a new line
	 */
	public void print() {
		for (int i = 0; i < heap.size(); i++)
			System.out.println(heap.get(i));

		System.out.println();
	}

	/**
	 * 
	 * @return number of entries in heap
	 */
	public int numEntries() {
		return heap.size();
	}

	/**
	 * move last entry to root, remove last index, trickle down root using maxHeapify
	 * 
	 * @return removed root entry
	 */
	public ArrayHeapEntry remove() {
		ArrayHeapEntry root = heap.get(0);

		// last entry
		int entryIndex = heap.size() - 1;
		ArrayHeapEntry entry = heap.get(entryIndex);

		heap.set(0, entry);
		entryIndex = 0;
		heap.remove(heap.size() - 1);

		maxHeapify(entryIndex);

		return root;
	}

	/**
	 * recursively trickle down last entry beginning from the root to its
	 * correct position
	 * 
	 * @param index
	 *            index of entry to be trickled down
	 */
	private void maxHeapify(int index) {
		int left = (index + 1) * 2 - 1;
		int right = (index + 1) * 2;
		int largest = index;

		if (left <= heap.size() - 1 && heap.get(left).getKey() > heap.get(index).getKey())
			largest = left;

		if (right <= heap.size() - 1 && heap.get(right).getKey() > heap.get(largest).getKey())
			largest = right;

		if (largest != index) {
			ArrayHeapEntry temp = heap.get(largest);
			heap.set(largest, heap.get(index));
			heap.set(index, temp);

			maxHeapify(largest);
		}
	}
}
