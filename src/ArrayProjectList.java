import com.sun.xml.internal.ws.api.pipe.NextAction;


public class ArrayProjectList implements ProjectList<ArrayEntry> {

    // You have two choices when implementing the array-based ProjectList. 
	// Also, you'll need to decide where the first element is stored and 
	// where the last element is stored within the array.
	
	// I've provided one example of how each would work in first().
	
	//Option 1: Store the values in an int array and then return ArrayEntries when needed
	// int [] values;
	
	// Option 2: Store the values in an ArrayEntry array and return the ArrayEntries from the array
	// ArrayEntry [] entries;
	
	
	// # of positions in the list
	private int n = 0;
	int[] values;
    
    public ArrayProjectList() {
    	this(10);
    }
    
    public ArrayProjectList(int startSize) {
        values = new int[startSize];
    }
    
    public ArrayProjectList(int... values) {
    	this.values = values;
    	n = values.length;
    }
    
    private void npp() {
    	n++;
    	
    	if(n > values.length) {
    		int[] newValues = new int[(int) (n*1.5)];
    		System.arraycopy(values, 0, newValues, 0, n-1);
    		values = newValues;
    	}
    }
    
    public void insertFirst(int value) {
    	
    	npp();
    	
    	for(int i = n-1; i > 0; i--) {
    		values[i] = values[i-1];
    	}
    	
    	values[0] = value;
    }
    
    public void insertLast(int value) {
    	
    	npp();
    	
    	values[n-1] = value;
    }
    
    public ArrayEntry first() {
		return new ArrayEntry(values[0], 0);
    }

    public ArrayEntry last() {
    	return new ArrayEntry(values[n-1], n-1);
    }

    public boolean isFirst(ArrayEntry p) {
    	return p.getIndex() == 0;
    }

    public boolean isLast(ArrayEntry p) {
    	return p.getIndex() == n-1;
    }

    public ArrayEntry before(ArrayEntry p) {
    	return new ArrayEntry(values[p.getIndex()-1], p.getIndex()-1);
    }

    public ArrayEntry after(ArrayEntry p) {
    	return new ArrayEntry(values[p.getIndex()+1], p.getIndex()+1);
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }
    
	public String toString() {
		ProjectList list = this;
    	if(list.isEmpty()) {
    		return "";
    	}
    	
        StringBuilder sb = new StringBuilder();
        
        Position p = list.first();
        
        while(!list.isLast(p)) {
        	sb.append(p.getValue());
        	sb.append(" ");
        	p = list.after(p);
        }
        sb.append(p.getValue());
        
        return sb.toString();
	}
}
