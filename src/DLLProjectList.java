public class DLLProjectList implements ProjectList<DLLNode> {

    private DLLNode head;
    private DLLNode tail;
    
    public DLLProjectList() {
        
    }
    
    public DLLProjectList(int... values) {
    	for(int i : values) {
    		insertLast(i);
    	}
    }
    
    public void insertFirst(int value) {
        
    	DLLNode dlln = new DLLNode(value);
    	
    	dlln.next = head;
    	if(head != null) head.prev = dlln;
    	head = dlln;
    	
    	if(tail == null)
    		tail = head;
    }
    
    public void insertLast(int value) {
        
    	DLLNode dlln = new DLLNode(value);
    	
    	dlln.prev = tail;
    	if(tail != null) tail.next = dlln;
    	tail = dlln;
    	
    	if(head == null)
    		head = tail;
    }
    
    public DLLNode first() {
        return head;
    }

    public DLLNode last() {
        return tail;
    }

    public boolean isFirst(DLLNode p) {
        return first().equals(p);
    }

    public boolean isLast(DLLNode p) {
        return last().equals(p);
    }

    public DLLNode before(DLLNode p) {
    	return p.prev;
    }

    public DLLNode after(DLLNode p) {
        return p.next;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
    	int n = 0;
        DLLNode dlln = head;
    	
    	while(dlln != null) {
    		n++;
    		dlln = after(dlln);
    	}
        
    	return n;
    }
    
    @Override
    public String toString() {
    	if(isEmpty()) return "empty";
    	
    	StringBuilder sb = new StringBuilder();
    	DLLNode dlln = head;
    	
    	while(dlln != null) {
    		sb.append(dlln.getValue());
    		sb.append(" ");
    		dlln = dlln.next;
    	}
    	
    	return sb.toString();
    }
}
