public interface ProjectList<P extends Position> {
	
	/**
	 * Adds a new node at front of the list
	 * @param value
	 */
    public void insertFirst(int value);
    
    /**
     * Adds a new node at the end of the list
     * @param value
     */
    public void insertLast(int value);
    
    /**
     * Returns first Position of the list
     * @return
     */
    public P first();
    
    /**
     * Returns last Position of the list
     * @return
     */
    public P last();
    
    /**
     * Determines if Position p is the first position of the list
     * @param p
     * @return
     */
    public boolean isFirst(P p);
    
    /**
     * Determines if Position p is the last position of the list
     * @param p
     * @return
     */
    public boolean isLast(P p);
    
    /**
     * Returns the Position before Position p (error if p is first position)
     * @param p
     * @return
     */
    public P before(P p);
    
    /**
     * Returns the Position after Position p (error if p is the last position)
     * @param p
     * @return
     */
    public P after(P p);
    
    
    /**
     * Returns Boolean value indicating if the list has no nodes
     * @return
     */
    public boolean isEmpty();
    
    /**
     * Returns the number of positions in the list as an integer
     * @return
     */
    public int size();
}
