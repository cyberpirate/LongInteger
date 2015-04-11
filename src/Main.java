
public class Main {

	public static final int A = 0;
	public static final int B = 1;
	public static final int C = 2;
	public static final int D = 3;
	public static final int E = 4;
	public static final int F = 5;
	public static final int G = 6;
	public static final int H = 7;
	public static LongInteger[] li;
	
	public static void main(String[] args) {
		li = new LongInteger[8];
		li[A] = new LongInteger("2222");
		li[B] = new LongInteger("99999999");
		li[C] = new LongInteger("-246813575732");
		li[D] = new LongInteger("180270361023456789");
		li[E] = new LongInteger("1423550000000010056810000054593452907711568359");
		li[F] = new LongInteger("-350003274594847454317890");
		li[G] = new LongInteger("29302390234702973402973420937420973420937420937234872349872934872893472893749287423847");
		li[H] = new LongInteger("-98534342983742987342987339234098230498203894209928374662342342342356723423423");
		
		System.out.print("A: "); printList(li[A]);
		System.out.print("B: "); printList(li[B]);
		System.out.print("C: "); printList(li[C]);
		System.out.print("D: "); printList(li[D]);
		System.out.print("E: "); printList(li[E]);
		System.out.print("F: "); printList(li[F]);
		System.out.print("G: "); printList(li[G]);
		System.out.print("H: "); printList(li[H]);
		
		System.out.println();
		
		System.out.print("A: "); li[A].output();
		System.out.print("B: "); li[B].output();
		System.out.print("C: "); li[C].output();
		System.out.print("D: "); li[D].output();
		System.out.print("E: "); li[E].output();
		System.out.print("F: "); li[F].output();
		System.out.print("G: "); li[G].output();
		System.out.print("H: "); li[H].output();
		
		System.out.println();
		
		System.out.println("A: " + (li[A].getSign() ? "neg" : "pos") + " " + li[A].getDigitCount());
		System.out.println("B: " + (li[B].getSign() ? "neg" : "pos") + " " + li[B].getDigitCount());
		System.out.println("C: " + (li[C].getSign() ? "neg" : "pos") + " " + li[C].getDigitCount());
		System.out.println("D: " + (li[D].getSign() ? "neg" : "pos") + " " + li[D].getDigitCount());
		System.out.println("E: " + (li[E].getSign() ? "neg" : "pos") + " " + li[E].getDigitCount());
		System.out.println("F: " + (li[F].getSign() ? "neg" : "pos") + " " + li[F].getDigitCount());
		System.out.println("G: " + (li[G].getSign() ? "neg" : "pos") + " " + li[G].getDigitCount());
		System.out.println("H: " + (li[H].getSign() ? "neg" : "pos") + " " + li[H].getDigitCount());
		
		System.out.println();
		
		int a = Integer.parseInt(li[A].toString());
		int b = Integer.parseInt(li[B].toString());
		
		System.out.println("overflow(a): " + UtilityOperations.overflow(a));
		System.out.println("underflow(a): " + UtilityOperations.underflow(a));
		System.out.println("upperHalf(a): " + UtilityOperations.upperHalf(a));
		System.out.println("lowerHalf(a): " + UtilityOperations.lowerHalf(a));
		System.out.println("digits(a): " + UtilityOperations.digits(a));
		
		System.out.println();
		
		System.out.println("overflow(b): " + UtilityOperations.overflow(b));
		System.out.println("underflow(b): " + UtilityOperations.underflow(b));
		System.out.println("upperHalf(b): " + UtilityOperations.upperHalf(b));
		System.out.println("lowerHalf(b): " + UtilityOperations.lowerHalf(b));
		System.out.println("digits(b): " + UtilityOperations.digits(b));
		
		System.out.println();
		
		for(int i = 0; i < H; i++) {
			for(int j = i+1; j < H+1; j++) {
				System.out.println(intToChar(i) + " = " + intToChar(j) + ": " + li[i].equals(li[j]));
				System.out.println(intToChar(i) + " < " + intToChar(j) + ": " + li[i].lessThan(li[j]));
				System.out.println(intToChar(i) + " > " + intToChar(j) + ": " + li[i].greaterThan(li[j]));
			}
		}
		
		System.out.println();
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < H+1; j++) {
				System.out.println(intToChar(i) + " + " + intToChar(j) + ": " + li[i].add(li[j]));
				System.out.println(intToChar(i) + " - " + intToChar(j) + ": " + li[i].subtract(li[j]));
				System.out.println(intToChar(i) + " * " + intToChar(j) + ": " + li[i].multiply(li[j]));
			}
		}
	}

	public static void printList(LongInteger li) {
		ProjectList list = li.getList();
    	if(list.isEmpty()) {
    		System.out.println("0");
    		return;
    	}
    	
        StringBuilder sb = new StringBuilder();
        
        Position p = list.first();
        
        while(!list.isLast(p)) {
        	sb.append(p.getValue());
        	sb.append(" ");
        	p = list.after(p);
        }
        sb.append(p.getValue());
        
        System.out.println(sb);
	}
	
	public static char intToChar(int i) {
		return (char) (65 + i);
	}
}
