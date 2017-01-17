package cse360assign2;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringListTest {

	@Test
	/**
	 *  Tests the insert, add, and get methods in order
	 *  	- add should add the second "10" but insert should not (duplicate)
	 */
	public void testInsertAddAndGet() {
		StringListExt list = new StringListExt();
		list.insert("abc");
		list.insert("10");
		list.insert("-5");
		list.insert("hello");
		list.insert("10");
		
		list.add("hi");
		list.add("10");
		
		assertEquals("-5", list.get(0));
		assertEquals("10", list.get(1));
		assertEquals("abc", list.get(2));
		assertEquals("hello", list.get(3));
		assertEquals("hi", list.get(4));
		assertEquals("10", list.get(5));

		
		assertEquals("Second attempt", "-5", list.get(0)); // second attempt
		assertEquals("Second attempt", "10", list.get(5)); // second attempt
	}
	
	@Test
	/**
	 *  Tests the length method
	 */
	public void testLength() {
		StringListExt list = new StringListExt();
	    assertEquals(0, list.length());
	    list.insert("abc");
	    assertEquals(1, list.length());
	    list.insert("10");
	    assertEquals(2, list.length());
	    list.insert("-5");
	    assertEquals(3, list.length());
	    list.insert("hello");
	    assertEquals(4, list.length());
	   
	    assertEquals("Second attempt", 4, list.length());   // second attempt
	}

	/**
	 *  Tests the getLast method
	 */
	@Test
	public void testGetLast() {
		StringListExt list = new StringListExt();
		list.add("abc");
		list.add("10");
		list.add("-5");
	
		assertEquals("-5", list.getLast());
	}

	/**
	 *  Tests the remove method
	 */
	@Test
	public void testRemove() {
		StringListExt list = new StringListExt();
		list.insert("abc");
		list.insert("10");
		list.insert("-5");
		list.insert("hello");
		
		list.remove("abc"); // index 0, "10" will take its place
		list.remove("-5"); // index 1 now, "hello" will take its place
		
		assertEquals("10", list.get(0));
		assertEquals("hello", list.get(1));		
	}

	/**
	 *  Tests the search method
	 */
	@Test
	public void testSearch() {
		StringList list = new StringList();
		list.insert("abc");
		list.insert("10");
		list.insert("-5");
		list.insert("hello");
		
		assertEquals(1, list.search("10"));
		assertEquals(-1, list.search("99"));
		assertEquals(3, list.search("hello"));
	}

	@Test
	/**
	 *  Tests the toString method
	 */
	public void testToString() {
		StringList list = new StringList();
		list.insert("abc");
		list.insert("10");
		list.insert("-5");
		list.insert("hello");
		list.insert("10");
		
		assertEquals("-5 10 abc hello ", list.toString());
	}

}
