public class SLLProjectList implements ProjectList<SLLNode> {

    // NOTE: This is for extra credit on Step 3. 
    // It is not a required part of the project. 
    // Implementing a singly linked list project list
    // and applying the test cases is worth 
	// 5 pts extra credit
    private SLLNode head;
    
    public SLLProjectList() {
        
    }
    
    public void insertFirst(int value) {
        head = new SLLNode(value, head);
    }
    
    public void insertLast(int value) {
        if(head == null)
        	head = new SLLNode(value, head);
        
        SLLNode n = head;
        while(n.getNext() != null) {
        	n = n.getNext();
        }
        
        n.setNext(new SLLNode(value, null));
    }
    
    public SLLNode first() {
        return head;
    }

    public SLLNode last() {
        SLLNode n = head;
        while(n.getNext() != null) {
        	n = n.getNext();
        }
        
        return n;
    }

    public boolean isFirst(SLLNode p) {
        return p.equals(head);
    }

    public boolean isLast(SLLNode p) {
        return p.getNext() == null;
    }

    public SLLNode before(SLLNode p) {
        SLLNode n = head;
        while(!n.getNext().equals(p)) {
        	n = n.getNext();
        }
        
        return n;
    }

    public SLLNode after(SLLNode p) {
        return p.getNext();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
    	if(head == null) return 0;
    	
    	int count = 1;
        SLLNode n = head;
        while(n.getNext() != null) {
        	n = n.getNext();
        	count++;
        }
        
        return count;
    }
}
