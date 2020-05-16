import java.util.Random;

public class ConcentrationM {
	 private static int[] ordered = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28};

     public static int[] shuffled()
     {
     int[] shuffled=shuffler(ordered);
     return shuffled;
     }
   
  private static  int[] shuffler (int[]a) { //method to shuffle cards
  
     for (int i = 0; i < a.length; i++) {
        for (int j = 0; j < a.length; j++) {
           for (int k = 0; k < a.length; k++) {
              Random generator = new Random();
              swapper(a, generator.nextInt(a.length), generator.nextInt(a.length));            
           }         
        }    
     } 
     return a;
  }
  private static void swapper(int[] a, int b, int c){  
     int x = a[b]; 
     int y = a[c]; 
     a[b] = y; 
     a[c] = x; 
  }  
 }



