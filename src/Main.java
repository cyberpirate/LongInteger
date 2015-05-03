
public class Main {

	public static final int A = 0;
	public static final int B = 1;
	public static final int C = 2;
	public static final int D = 3;
	public static final int E = 4;
	public static final int F = 5;
	public static final int G = 6;
	public static final int H = 7;
	public static final int I = 8;
	public static final int J = 9;
	public static final int K = 10;
	public static final int L = 11;
	public static final int M = 12;
	public static final int N = 13;
	public static final int O = 14;
	public static final int P = 15;
	public static final int Q = 16;
	public static final int R = 17;
	public static final int S = 18;
	public static final int T = 19;
	public static final int U = 20;
	public static final int V = 21;
	public static final int W = 22;
	public static final int X = 23;
	public static final int Y = 24;
	public static final int Z = 25;
	public static LongInteger[] li;
	
	public static void main(String[] args) {
		
		
		LongInteger.listType = DLLProjectList.class;
		TestResults dllRes = runTests();
		
		System.out.println();
		
		LongInteger.listType = ArrayProjectList.class;
		TestResults arrRes = runTests();
		
		System.out.println();
		
		LongInteger.listType = SLLProjectList.class;
		TestResults sllRes = runTests();
		
		int colLen = 11;
		int colNum = 9;
		String row = "%3s";
		
		for(int i = 1; i < colNum; i++) {
			row += " | %" + colLen + "s";
		}
		row += "\n";
		
		System.out.println();
		
		System.out.printf(row, "", "equals", "lessThan", "greaterThan", "add", "subtract", "multiply", "power", "total");
		System.out.printf(row, "DLL", dllRes.equals, dllRes.lessThan, dllRes.greaterThan, dllRes.add, dllRes.subtract, dllRes.multiply, dllRes.power, dllRes.total);
		System.out.printf(row, "ARR", arrRes.equals, arrRes.lessThan, arrRes.greaterThan, arrRes.add, arrRes.subtract, arrRes.multiply, arrRes.power, arrRes.total);
		System.out.printf(row, "SLL", sllRes.equals, sllRes.lessThan, sllRes.greaterThan, sllRes.add, sllRes.subtract, sllRes.multiply, sllRes.power, sllRes.total);
	}
	
	public static TestResults runTests() {
		
		li = new LongInteger[26];
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
		
		TestResults ret = new TestResults();
		long s;
		long start = System.nanoTime();
		
		s = System.nanoTime();
		for(int i = 0; i < H; i++) {
			for(int j = i+1; j < H+1; j++) {
				System.out.println(intToChar(i) + " = " + intToChar(j) + ": " + li[i].equals(li[j]));
			}
		}
		ret.equals = System.nanoTime() - s;
		
		s = System.nanoTime();
		for(int i = 0; i < H; i++) {
			for(int j = i+1; j < H+1; j++) {
				System.out.println(intToChar(i) + " < " + intToChar(j) + ": " + li[i].lessThan(li[j]));
			}
		}
		ret.lessThan = System.nanoTime() - s;
		
		s = System.nanoTime();
		for(int i = 0; i < H; i++) {
			for(int j = i+1; j < H+1; j++) {
				System.out.println(intToChar(i) + " > " + intToChar(j) + ": " + li[i].greaterThan(li[j]));
			}
		}
		ret.greaterThan = System.nanoTime() - s;
		
		System.out.println();
		
		s = System.nanoTime();
		for(int i = 0; i < H; i++) {
			for(int j = i+1; j < H+1; j++) {
				System.out.println(intToChar(i) + " + " + intToChar(j) + ": " + li[i].add(li[j]));
			}
		}
		ret.add = System.nanoTime() - s;
		
		s = System.nanoTime();
		for(int i = 0; i < H; i++) {
			for(int j = i+1; j < H+1; j++) {
				System.out.println(intToChar(i) + " - " + intToChar(j) + ": " + li[i].subtract(li[j]));
			}
		}
		ret.subtract = System.nanoTime() - s;
		
		s = System.nanoTime();
		for(int i = 0; i < H; i++) {
			for(int j = i+1; j < H+1; j++) {
				System.out.println(intToChar(i) + " * " + intToChar(j) + ": " + li[i].multiply(li[j]));
			}
		}
		ret.multiply = System.nanoTime() - s;
		
		System.out.println();
		
		li[I] = li[A].add(li[D]);
		li[J] = li[B].add(li[C]);
		li[K] = li[C].add(li[D]);
		li[L] = li[I].add(li[I]);
		li[M] = li[A].add(li[I]);
		li[N] = li[B].add(li[K]);
		li[O] = li[A].subtract(li[D]);
		li[P] = li[C].subtract(li[D]);
		li[Q] = li[D].subtract(li[C]);
		li[R] = li[L].subtract(li[L]);
		li[S] = li[P].subtract(li[O]);
		li[T] = li[N].subtract(li[Q]);
		li[U] = li[A].multiply(li[D]);
		li[V] = li[B].multiply(li[C]);
		li[W] = li[D].multiply(li[D]);
		li[X] = li[O].multiply(li[I]);
		li[Y] = li[J].multiply(li[P]);
		li[Z] = li[M].multiply(li[N]);
		
		for(int i = I; i <= Z; i++) {
			System.out.println(intToChar(i) + ": " + li[i]);
		}
		
		System.out.println();
		
		int[] powers = new int[]{2, 5, 10, 25};
		s = System.nanoTime();
		for(int p : powers) {
			for(int i = A; i <= H; i++) {
				System.out.println(intToChar(i) + " ^ " + p + ": " + li[i].power(p));
			}
		}
		ret.power = System.nanoTime() - s;
		
		ret.total = System.nanoTime() - start;
		
		return ret;
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

	public static class TestResults {
		public long equals, lessThan, greaterThan, add, subtract, multiply, power, total;
	}
}
