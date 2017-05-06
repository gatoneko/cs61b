public class HelloNumbers {
    public static void main(String[] args) {
        int x = 0;
        int currentTotal = 0;
        while (x < 10) {
        	System.out.print(currentTotal + " ");		
            x = x + 1;
            currentTotal = currentTotal + x;
        }
        System.out.println();
    }
}