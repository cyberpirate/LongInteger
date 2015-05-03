public class SLLNode extends Position {
    private SLLNode next;

    public SLLNode(int value, SLLNode next) {
        super(value);
		
		this.next = next;
    }
	
	public SLLNode getNext() {
		return next;
	}
	
	public void setNext(SLLNode next) {
		this.next = next;
	}
}
