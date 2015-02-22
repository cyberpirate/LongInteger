
public class MainTest {

	public static void main(String[] args) {
		
		int[] testValues = new int[] {0, 1, 2, 3};
		
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
	}

	
	public static String arrToStr(int... values) {
		StringBuilder sb = new StringBuilder();
		
		for(int i : values) {
			sb.append(i);
			sb.append(" ");
		}
		
		return sb.toString();
	}
}
