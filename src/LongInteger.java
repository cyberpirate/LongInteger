public class LongInteger {
    
	// DO NOT CHANGE OR REMOVE THIS LINE (UNTIL STEP 3)
    private ProjectList list = null;
	
    public static Class<? extends ProjectList<? extends Position>> listType = DLLProjectList.class;
    
    private boolean isNegative = false;
    
    public LongInteger() {
    	try {
			list = listType.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    /**
     * Initializes a new Long Integer which represents the number in String s. String s is in the format: [-?][1-9][0-9]*
     * @param s
     */
    public LongInteger(String s) {
    	this();
        init(s);
    }
    
    private void init(String s) {
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
        	
        	tn = tp.getValue();
        	in = ip.getValue();
        	
        	while(tn == in && (!list.isLast(tp) && !i.list.isLast(ip))) {
        		tp = list.after(tp);
        		ip = i.list.after(ip);
        		
            	tn = tp.getValue();
            	in = ip.getValue();
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
        	
        	tn = tp.getValue();
        	in = ip.getValue();
        	
        	while(tn == in && (!list.isLast(tp) && !i.list.isLast(ip))) {
        		tp = list.after(tp);
        		ip = i.list.after(ip);
        		
            	tn = tp.getValue();
            	in = ip.getValue();
        	}
        }
        
        return tn > in;
    }
    
    public boolean greaterMag(LongInteger i) {
        int tn = getDigitCount();
        int in = i.getDigitCount();
        
        if(tn == in) {
        	if(tn == 0) return false;
        	
        	Position tp = list.first();
        	Position ip = i.list.first();
        	
        	tn = tp.getValue();
        	in = ip.getValue();
        	
        	while(tn == in && (!list.isLast(tp) && !i.list.isLast(ip))) {
        		tp = list.after(tp);
        		ip = i.list.after(ip);
        		
            	tn = tp.getValue();
            	in = ip.getValue();
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
        
    	if(this.isNegative == i.isNegative)
    		return addSameSign(this, i);
    	else if(!this.greaterMag(i))
    		return subGreaterFromLess(i, this);
    	else
    		return subGreaterFromLess(this, i);
    }
    
    private static LongInteger addSameSign(LongInteger ng, LongInteger nl) {
    	LongInteger ret = new LongInteger();
    	
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
		
		ret.isNegative = ng.isNegative;
		
    	return ret;
    }
    
    /**
     * Subtracts the Long Integer i from the Long Integer and returns the result as a new Long Integer. Must be implemented separately from add, but add and subtract can call each other when necessary.
     * @param i
     * @return
     */
    public LongInteger subtract(LongInteger i) {
    	
    	if(this.isNegative == i.isNegative) {
        	if(this.greaterMag(i))
        		return subGreaterFromLess(this, i);
        	else {
        		LongInteger ret = subGreaterFromLess(i, this);
        		ret.isNegative = !ret.isNegative;
        		return ret;
        	}
    	} else {
    		LongInteger ret = addSameSign(this, i);
    		ret.isNegative = this.isNegative;
    		return ret;
    	}
    }
    
    private static LongInteger subGreaterFromLess(LongInteger ng, LongInteger nl) {
    	
    	int n = 0;
    	int[] retData = new int[ng.list.size()];
    	
    	Position pg = ng.list.last();
    	Position pl = nl.list.last();
    	int carry = 0, vg, vl;
    	
    	while(!nl.list.isFirst(pl)) {
    		
    		vg = pg.getValue() + carry;
    		vl = pl.getValue();
    		
    		if(vg < vl) {
    			carry = -1;
    			vg += 100000000;
    		} else {
    			carry = 0;
    		}
    		
    		retData[n++] = vg - vl;
    		pg = ng.list.before(pg);
    		pl = nl.list.before(pl);
    	}
    	
		vg = pg.getValue() + carry;
		vl = pl.getValue();
		
		if(vg < vl) {
			carry = -1;
			vg += 100000000;
		} else {
			carry = 0;
		}
		
		retData[n++] = vg - vl;
    	
		if(!ng.list.isFirst(pg)) {
			pg = ng.list.before(pg);
			
			while(!ng.list.isFirst(pg)) {
				vg = pg.getValue() + carry;
				
				if(carry != 0) {
					carry = 0;
				}
				
				if(vg < 0) {
					carry = -1;
					vg = 99999999;
				}
				
				retData[n++] = vg;
				pg = ng.list.before(pg);
			}
			
			vg = pg.getValue() + carry;
			
			if(carry != 0) {
				carry = 0;
			}
			
			retData[n++] = vg;
		}
		

		
		while(n > 0 && retData[n-1] == 0)
			n--;
		
		LongInteger ret = new LongInteger();
		
		for(int i = n-1; i >= 0; i--) {
			ret.list.insertLast(retData[i]);
		}
    	
		ret.isNegative = ng.isNegative;
		
    	return ret;
    }
    
    
    /**
     * Multiplies the Long Integer by Long Integer i and returns the result as a new Long Integer
     * @param i
     * @return
     */
    public LongInteger multiply(LongInteger b) {
    	
    	LongInteger a = this;
    	LongInteger[] mult = new LongInteger[a.list.size()];
    	
    	Position ap = a.list.last();
    	
    	for(int i = 0; i < mult.length; i++) {
    		
    		mult[i] = new LongInteger();
    		
    		for(int j = 0; j < i; j++)
    			mult[i].list.insertLast(0);
    		
    		Position bp = b.list.last();
    		int carry = 0;
    		int[] num;
    		
    		while(!b.list.isFirst(bp)) {
    			
    			num = singleKarat(ap.getValue(), bp.getValue());
    			int val = num[1]+carry;
    			
    			num[0] += UtilityOperations.overflow(val);
    			val = UtilityOperations.underflow(val);
    			
    			mult[i].list.insertFirst(val);
    			carry = num[0];
    			
    			bp = b.list.before(bp);
    		}
    		
			num = singleKarat(ap.getValue(), bp.getValue());
			int val = num[1]+carry;
			
			num[0] += UtilityOperations.overflow(val);
			val = UtilityOperations.underflow(val);
			
			mult[i].list.insertFirst(val);
			
			if(num[0] != 0)
				mult[i].list.insertFirst(num[0]);
    		
			if(!a.list.isFirst(ap))
				ap = a.list.before(ap);
    		
    	}
    	
    	for(int i = 1; i < mult.length; i++) {
    		mult[0] = mult[0].add(mult[i]);
    	}
    	
    	mult[0].isNegative = a.isNegative != b.isNegative;
    	
    	return mult[0];
    }
    
    public static int[] singleKarat(int a, int b) {
    	int[] ret = new int[2];
    	
    	int a1 = UtilityOperations.upperHalf(a),
    			a2 = UtilityOperations.lowerHalf(a),
    			b1 = UtilityOperations.upperHalf(b),
    			b2 = UtilityOperations.lowerHalf(b);
    	
    	int z1 = a1*b1, 
    			z3 = a2*b2;
    	
    	int z2 = (a1 + a2)*(b1 + b2) - z3 - z1;
    	
    	ret[0] = z1 + UtilityOperations.upperHalf(z2) + UtilityOperations.overflow(z2)*10000;
    	ret[1] = z3 + UtilityOperations.lowerHalf(z2)*10000;
    	
    	ret[0] += UtilityOperations.overflow(ret[1]);
    	ret[1] = UtilityOperations.underflow(ret[1]);
    	
    	return ret;
    }
    
    /**
     * Raises the Long Integer to the power p (a regular integer) and returns the result as a new Long Integer. Note that no more than 2lg(p) calls to multiply are allowed.
     * @param p
     * @return
     */
    public LongInteger power(int p) {
    	
    	if(p < 0) return new LongInteger("0");
    	
    	int[] logs = new int[UtilityOperations.lowerLog(p)+1];
    	LongInteger[] parts = new LongInteger[logs.length];
    	LongInteger ret = new LongInteger("1");
    	
    	logs[0] = 1;
    	parts[0] = this;
    	
    	for(int i = 1; i < logs.length; i++) {
    		logs[i] = 2*logs[i-1];
    		parts[i] = parts[i-1].multiply(parts[i-1]);
    	}
    	
    	for(int i = logs.length-1; i >= 0; i--) {
    		if(p >= logs[i]) {
    			p -= logs[i];
    			ret = ret.multiply(parts[i]);
    		}
    		if(p == 0)
    			break;
    	}
    	
    	return ret;
    }
    
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
        boolean wasLast = true;
        
        if(!list.isLast(p)) {
        	sb.append(String.format("%d", p.getValue()));
        	p = list.after(p);
        	wasLast = false;
        }
        
        while(!list.isLast(p)) {
        	sb.append(String.format("%08d", p.getValue()));
        	p = list.after(p);
        }
        sb.append(String.format((wasLast ? "%d" : "%08d"), p.getValue()));
        
        return sb.toString();
    }
}
