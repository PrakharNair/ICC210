
public class Fibonacci {
	
	public static void main(String[] args) {
		int a = 1; 
		int b = 0; 
		
		int total = 0; 
		
		while(total < 144) {
			total = a + b;
			System.out.print(total);
			if (total != 144) {
				System.out.print(", ");
			}
			a = b;
			b = total;
		}
	}
}

