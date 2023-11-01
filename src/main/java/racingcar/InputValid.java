package racingcar;

import java.util.HashSet;
import java.util.Set;

public class InputValid {

    public static void names(String[] carNames) {
        
    	Set<String> uniquecarnames = new HashSet<>();
        
        for (int i = 0; i<carNames.length;i++ ) {
        	String names = carNames[i];
        
        	if (names.isEmpty()) {
        		throw new IllegalArgumentException();
        	}
        	if (names.length()>5) {
        		throw new IllegalArgumentException();
        	}
        	if (!uniquecarnames.add(names)) {
        		throw new IllegalArgumentException();
        	}
        	
        	uniquecarnames.add(names);
        }
        
        
        


    }
    public static void count(int count) {
    	
    	if(count<1) {
    		throw new IllegalArgumentException();
    	}
    }

}
