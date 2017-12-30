public class assign1 {
    public static void main(String[] args) {
        
        for(int i = 1; i < 97; i++) {
            if(i % 5 == 0) {
                if(i % 9 == 0) {
                    System.out.println("Fruit Loops");
                }//end if
                else {
                    System.out.println("Fruit");
                }//end else
            }//end if
            else if(i % 9 == 0) {
                System.out.println("Loops");
            }//end else
            else {
                System.out.println(i);
            }//end else
        }//end for
        
    }//end main
    
}//end fruitloop

