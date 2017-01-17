package cse360assign2;

public class StringListExt extends StringList {

	/** Description of add(String str)
	 * 
	 * @param str String to add to end of list
	 */
	public void add(String str)
	{
		A.add(str);
	}
	
	/** Description of get(int index)
	 * 
	 * @param index
	 * @return String in given index
	 */
	public String get(int index)
	{
		return A.get(index);
	}
	
	/** Description of int length()
	 * 
	 * @return length of ArrayList
	 */
	public int length()
	{
		return A.size();
	}
	
	/** Description of String getLast()
	 * 
	 * @return last String in ArrayList
	 */
	public String getLast()
	{
		if(A.size() == 0)
			return "";
		else
			return(A.get(A.size() - 1));
	}
	
	/** Description of void remove()
	 * 
	 * @param String to be removed from ArrayList
	 */
	public void remove(String str)
	{
		int index = search(str);
		
		if(index != -1)
			A.remove(index);
	}
}
