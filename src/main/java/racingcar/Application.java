package racingcar;

import java.util.ArrayList;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    	Function function= new Function();
    	
    	int count= function.inputNumber();
    	ArrayList<String> carName= function.inputCarName();
    	Map<String, Integer> result = function.run(count, carName);
    	
    	function.outputMove(result);
    	function.outputWinners(function.winners(result));
    }
}
