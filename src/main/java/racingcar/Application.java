package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        
    	System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    	
    	String carInput = Console.readLine();
    	List<String> carList = inputToCarList(carInput);
    	
    }
    
    public static List<String> inputToCarList(String carInput) {
		String[] separate = carInput.split(",");
    	List<String> carList = new ArrayList<>();
    	
    	for(int i = 0; i < separate.length; i++) {
    		carList.add(separate[i].trim());
    	}
    	
    	while(carList.remove(String.valueOf("")));
    	
		return carList;
	}
}

	