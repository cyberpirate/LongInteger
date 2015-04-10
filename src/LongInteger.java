public class LongInteger {
    
	// DO NOT CHANGE OR REMOVE THIS LINE (UNTIL STEP 3)
    private ProjectList list = new DLLProjectList();
	
    private boolean isNegative = false;
    
    /**
     * Initializes a new Long Integer which represents the number in String s. String s is in the format: [-?][1-9][0-9]*
     * @param s
     */
    public LongInteger(String s) {
        
    	if(s.charAt(0) == '-') {
    		isNegative = true;
    		s = s.substring(1, s.length());
    	}
    	
    	for(int i = s.length(); i > 0; i -= 8) {
    		String part = s.substring(Math.max(0, i-8), i);
    		
    		int value = Integer.parseInt(part);
    		
    		list.insertFirst(value);
    	}
    }

    public LongInteger() {
    	
    }
    
    /**
     * Prints the Long Integer to standard output in format: [-?][1-9][0-9]*
     */
    public void output() {
        System.out.println(toString());
    }
	
    /**
     * Returns the sign of the long integer (represented by a boolean isNegative)
     * @return
     */
	public boolean getSign() {
		return isNegative;
	}
	
	/**
	 * Returns the number of digits in the Long Integer as an integer. This value has to be computed dynamically.
	 * @return
	 */
	public int getDigitCount() {
		if(list.isEmpty()) return 0;
		
		int n = (list.size()-1)*8;
		n += UtilityOperations.digits(list.first().getValue());
		
		return n;
	}
    
    public boolean equalTo(LongInteger i) {

    	ProjectList l1 = list;
    	ProjectList l2 = i.list;
    	
    	Position p1 = l1.last();
    	Position p2 = l2.last();
        
    	while(!l1.isFirst(p1) && !l2.isFirst(p2)) {
    		
    		if(p1.getValue() != p2.getValue())
    			return false;
    		
    		p1 = l1.before(p1);
    		p2 = l2.before(p2);
    	}
    	
    	if(!l1.isFirst(p1) || !l2.isFirst(p2))
    		return false;
    	
    	return p1.getValue() == p2.getValue();
    }
    
    public boolean lessThan(LongInteger i) {
    	if(isNegative != i.isNegative) {
    		return isNegative;
    	}
    	
        int tn = getDigitCount();
        int in = i.getDigitCount();
        
        if(tn == in) {
        	if(tn == 0) return false;
        	
        	Position tp = list.first();
        	Position ip = i.list.first();
        	
        	while(true) {
            	tn = tp.getValue();
            	in = ip.getValue();
            	
            	if(tn == in) {
            		tp = list.after(tp);
            		ip = i.list.after(ip);
            		continue;
            	}
        	}
        }
        
        return tn < in;
    }
    
    public boolean greaterThan(LongInteger i) {
    	if(isNegative != i.isNegative) {
    		return !isNegative;
    	}
    	
        int tn = getDigitCount();
        int in = i.getDigitCount();
        
        if(tn == in) {
        	if(tn == 0) return false;
        	
        	Position tp = list.first();
        	Position ip = i.list.first();
        	
        	while(true) {
            	tn = tp.getValue();
            	in = ip.getValue();
            	
            	if(tn == in) {
            		tp = list.after(tp);
            		ip = i.list.after(ip);
            		continue;
            	}
        	}
        }
        
        return tn > in;
    }
    
    /**
     * Adds the Long Integer to Long Integer i and returns the result as a new Long Integer. Must be implemented separately from subtract, but add and subtract can call each other when necessary.
     * @param i
     * @return
     */
    public LongInteger add(LongInteger i) {
        
    	LongInteger ng = this, nl = i, ret = new LongInteger();
    	
    	if(ng.getDigitCount() < nl.getDigitCount()) {
    		LongInteger tmp = nl;
    		nl = ng;
    		ng = tmp;
    	}
    	
    	int overflow = 0;
    	int sum = 0;
    	Position pg = ng.list.last();
    	Position pl = nl.list.last();
    	
    	while(!nl.list.isFirst(pl)) {
    		sum = pg.getValue() + pl.getValue() + overflow;
    		overflow = UtilityOperations.overflow(sum);
    		ret.list.insertFirst(UtilityOperations.underflow(sum));
    		pg = ng.list.before(pg);
    		pl = nl.list.before(pl);
    	}
    	
		sum = pg.getValue() + pl.getValue() + overflow;
		overflow = UtilityOperations.overflow(sum);
		ret.list.insertFirst(UtilityOperations.underflow(sum));
		
	    if(!ng.list.isFirst(pg)) {
			pg = ng.list.before(pg);
	    	
	    	while(!ng.list.isFirst(pg)) {
	    		sum = pg.getValue() + overflow;
	    		overflow = UtilityOperations.overflow(sum);
	    		ret.list.insertFirst(UtilityOperations.underflow(sum));
	    		pg = ng.list.before(pg);
	    	}
	    	
			sum = pg.getValue() + overflow;
			overflow = UtilityOperations.overflow(sum);
			ret.list.insertFirst(UtilityOperations.underflow(sum));
    	}
    	
		if(overflow != 0) {
			ret.list.insertFirst(overflow);
		}
		
		ret.isNegative = this.isNegative;
		
    	return ret;
    }
//    
//    /**
//     * Subtracts the Long Integer i from the Long Integer and returns the result as a new Long Integer. Must be implemented separately from add, but add and subtract can call each other when necessary.
//     * @param i
//     * @return
//     */
//    public LongInteger subtract(LongInteger i) {
//        
//    }
//    
//    /**
//     * Multiplies the Long Integer by Long Integer i and returns the result as a new Long Integer
//     * @param i
//     * @return
//     */
//    public LongInteger multiply(LongInteger i) {
//        
//    }
//    
//    /**
//     * Raises the Long Integer to the power p (a regular integer) and returns the result as a new Long Integer. Note that no more than 2lg(p) calls to multiply are allowed.
//     * @param p
//     * @return
//     */
//    public LongInteger power(int p) {
//        
//    }
    
    public ProjectList getList() {
    	return list;
    }
    
    @Override
    public String toString() {
    	if(list.isEmpty()) {
    		return "0";
    	}
    	
        StringBuilder sb = new StringBuilder(getSign() ? "-" : "");
        
        Position p = list.first();
        
        if(!list.isLast(p)) {
        	sb.append(String.format("%d", p.getValue()));
        	p = list.after(p);
        }
        
        while(!list.isLast(p)) {
        	sb.append(String.format("%08d", p.getValue()));
        	p = list.after(p);
        }
        sb.append(String.format("%08d", p.getValue()));
        
        return sb.toString();
    }
}
