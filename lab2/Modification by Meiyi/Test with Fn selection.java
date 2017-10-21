package lab2;

//import java.util.function.*;
//import java.util.ArrayList;
import java.util.*;
class Test {
    public static void main(String[] args) {
    	System.out.println("Choose the hashing function:");
    	System.out.println("1. Mod Table Size Hash");
    	System.out.println("2. Folding Hash");
    	System.out.println("3. Multiplicative Congruential Hash");
    	System.out.println("4. Quit");   
    	
    	Scanner sc = new Scanner(System.in);
    	
    	while(true) {
    		
    	    System.out.print("Enter your choice:");
    	    int choice = sc.nextInt();
    	    if (choice == 4) break;
    	    
    	    System.out.print("Enter the hash table size:");
    	    int tableSize = sc.nextInt();
    	
    	    String hashFn = null;
    	    switch(choice) {
    	    case 1: hashFn = "MOD_TABLE_SIZE_HASH";
    		    break;
    	    case 2: hashFn = "FOLDING_HASH";
    		    break;
    	    case 3: hashFn = "MULTIPLICATIVE_CONGRUENTIAL_HASH";
    		    break;
    	    default:
    		    break;
    	    }
        HashTable map = new HashTable(tableSize, hashFn);
        map.add(10);
        map.add(12,9);
        System.out.println(map.contains(10));
        System.out.println(map.get(12));
    	}
    	sc.close();
    }
    
}