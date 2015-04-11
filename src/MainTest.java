
public class MainTest {

	static int[] testValues = new int[] {0, 1, 2, 3};
	
	public static void main(String[] args) {
		
//		testDLL();
//		System.out.println();
//		
//		testUtilityOperations();
//		System.out.println();

//		testLongInteger("12112321123432112345432112345654321", "121123211234321123454321");
		
//		testAdd();
//		testSub();
//		testKarat();
		testMult();
	}

	public static void testDLL() {
		DLLProjectList dll = new DLLProjectList();
		DLLProjectList dll1 = new DLLProjectList();
		DLLProjectList dll2 = new DLLProjectList(testValues);
		
		for(int i = 0; i < testValues.length; i++) {
			dll.insertLast(testValues[i]);
		}
		
		for(int i = testValues.length-1; i >= 0; i--) {
			dll1.insertFirst(testValues[i]);
		}
		
		System.out.println("DLL Test:");
		System.out.println("array:\t" + arrToStr(testValues));
		System.out.println("dll:\t" + dll.toString());
		System.out.println("dll1:\t" + dll1.toString());
		System.out.println("dll2:\t" + dll2.toString());
		System.out.println("length: " + testValues.length + " " + dll.size() + " " + dll1.size() + " " + dll2.size());
		System.out.println(dll.isFirst(dll.first()));
		System.out.println(!dll.isLast(dll.first()));
		System.out.println(!dll.isFirst(dll.last()));
		System.out.println(dll.isLast(dll.last()));
	}
	
	public static void testUtilityOperations() {
		System.out.println("UtilityOperations Test:");
		System.out.println("overflow(100010099): " + UtilityOperations.overflow(100010099));
		System.out.println("underflow(100010099): " + UtilityOperations.underflow(100010099));
		System.out.println("upperHalf(12345678): " + UtilityOperations.upperHalf(12345678));
		System.out.println("lowerHalf(12345678): " + UtilityOperations.lowerHalf(12345678));
		System.out.println("digits(1234): " + UtilityOperations.digits(1234));
	}
	
	public static void testLongInteger(String greater, String less) {
		LongInteger lig = new LongInteger(greater);
		LongInteger lil = new LongInteger(less);
		
		System.out.println(greater);
		lig.output();
		
		System.out.println("isNegative: " + lig.getSign());
		System.out.println(greater.length() + "\n" + lig.getDigitCount());
		System.out.println(!lig.equalTo(lil));
		System.out.println(!lig.lessThan(lil));
		System.out.println(lig.greaterThan(lil));
	}
	
	public static void testAdd() {
		LongInteger li1, li2;
		
		li1 = new LongInteger("-100000000");
//		li1 = new LongInteger("99999999");
		li2 = new LongInteger("-1");
		
		li1.add(li2).output();
	}
	
	public static void testSub() {
		LongInteger li1, li2;
		
		li1 = new LongInteger("-1");
		li2 = new LongInteger("100000000");
		
		li1.subtract(li2).output();
	}
	
	public static String arrToStr(int... values) {
		StringBuilder sb = new StringBuilder();
		
		for(int i : values) {
			sb.append(i);
			sb.append(" ");
		}
		
		return sb.toString();
	}
	
	public static void testKarat() {
		System.out.println(arrToStr(LongInteger.singleKarat(99999999, 99999999)));
	}
	
	public static void testMult() {
		LongInteger li1, li2;
		
		li1 = new LongInteger("-199999999");
		li2 = new LongInteger("100000000");
		
		li1.multiply(li2).output();
	}
}
