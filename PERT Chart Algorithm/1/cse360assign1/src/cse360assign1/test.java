package cse360assign1;

import java.util.*;

public class test {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter # of values: ");
		
		int n = in.nextInt();
		
		StringList array = new StringList();
		
		for(int i = 0; i < n; i++){
			System.out.println("Value: ");
			array.insert(in.next());
		}
		
		
		
		// System.out.println("ArrayList: " + array.toString());
		
		
		
		System.out.print("Enter value to search: ");
		
		String value = in.next();
		
		in.close();
		
		int index = array.search(value);
		
		if(index == -1)
			System.out.println("Not found!");
		else
			System.out.println("Found at index " + index);
		
		System.out.println("Program complete.");
	}
}