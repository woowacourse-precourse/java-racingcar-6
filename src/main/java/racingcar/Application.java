package racingcar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        
    	System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    	String carInput = Console.readLine();
    	List<String> carList = inputToCarList(carInput);
    	carListException(carList);
    	
    	System.out.println("시도할 회수는 몇회인가요?");
    	String timeInput = Console.readLine();
    	
    	
    }

	public static void carListException(List<String> carList) {
		atLeastOneCar(carList);
    	limitFiveEach(carList);
    	distinctName(carList);
	}

	public static void distinctName(List<String> carList) {
		Set<String> carSet = new HashSet<>(carList);
    	if(carSet.size() != carList.size())
    		throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
	}

	public static void limitFiveEach(List<String> carList) {
		for(int i = 0; i < carList.size(); i++) {
    		if(carList.get(i).length() > 5)
    			throw new IllegalArgumentException("각 자동차의 이름은 5자 이하로 작성해주세요.");
    	}
	}

	public static void atLeastOneCar(List<String> carList) {
		if(carList.size() < 1)
    		throw new IllegalArgumentException("유효한 자동차 이름이 없습니다.");
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

	