public class DLLNode extends Position {
    protected DLLNode next;
    protected DLLNode prev;
    
    public DLLNode(int value) {
    	super(value);
    }
    
    public DLLNode(int value, DLLNode next, DLLNode prev) {
        super(value);
		
		this.next = next;
		this.prev = prev;
    }
}
