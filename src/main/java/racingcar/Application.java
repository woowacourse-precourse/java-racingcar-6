package racingcar;
import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    	Try_Numb();
    	//Run(Car_Names(),Try_Numb());
    }
    
    public static void Run(List<String> Car_Names, Integer Try_Numb) {
    	
    }
    
    public static ArrayList<String> Car_Names() {
    	ArrayList<String> Car_Names = new ArrayList<>();
    	    	
    	return Car_Names;
    }
    
    public static Integer Try_Numb() {
    	Integer Try_numb = Randoms.pickNumberInRange(1, 9);
    	System.out.print(Try_numb);
    	return Try_numb;
    }
}
