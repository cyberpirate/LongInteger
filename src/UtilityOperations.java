public class UtilityOperations {
    
	/**
	 * Returns the overflow digit (9th digit in a 9 digit integer)
	 * @param t
	 * @return
	 */
    public static int overflow(int t) {
        return t / 100000000;
    }
    
    /**
     * Returns the 8 rightmost digits of regular integer t
     * @param t
     * @return
     */
    public static int underflow(int t) {
        return t % 100000000;
    }
    
    /**
     * Returns the four leftmost digits of an 8 digit integer
     * @param t
     * @return
     */
    public static int upperHalf(int t) {
        t = underflow(t);
        
        return t / 10000;
    }
    
    /**
     * Returns the four rightmost digits of an 8 digit integer
     * @param t
     * @return
     */
    public static int lowerHalf(int t) {
        t = underflow(t);
        
        return t % 10000;
    }
    
    /**
     * Returns the number of digits in regular integer t as an integer
     * @param t
     * @return
     */
    public static int digits(int t) {
        int n = 0;
        
        while(t > 0) {
        	n++;
        	t /= 10;
        }
        
        return n;
    }
    
    /**
     * Returns the number of digits in regular integer t as an integer
     * @param t
     * @return
     */
    public static int digits(long t) {
        int n = 0;
        
        while(t > 0) {
        	n++;
        	t /= 10;
        }
        
        return n;
    }
    
    /**
     * Returns the floor of log base 2
     * @param t
     * @return
     */
    public static int lowerLog(int t) {
        int n = 0;
        
        t /= 2;
        while(t > 0) {
        	n++;
        	t /= 2;
        }
        
        return n;
    }
}
