package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	private static final int MIN_TIMES = 1;
	private static final int MAX_TIMES = 100;
	private static final int MAX_CAR_NAME_LENGTH = 5;
	
    public static void main(String[] args) {
        
    	System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    	String carInput = Console.readLine();
    	List<String> carList = inputToCarList(carInput);
    	validateCarList(carList);
    	
    	System.out.println("시도할 회수는 몇회인가요?");
    	String timesInput = Console.readLine();
    	validateTimes(timesInput);
    	
    	System.out.println("\n실행 결과");
    	List<Integer> results = new ArrayList<>();
    	setCarsOnStart(carList, results);
    	printTryAsRequest(carList, timesInput, results);
    	
    	System.out.print("최종 우승자 : ");
    	printWinners(carList, results);
    }

	public static void printWinners(List<String> carList, List<Integer> results) {
		int max = Collections.max(results);
    	int index = results.indexOf(max);
    	while(index != -1) {
    		System.out.print(carList.get(index));
    		index = findTie(carList, results, max, index);
    	}
	}

	public static int findTie(List<String> carList, List<Integer> results, int max, int index) {
		results.remove(index);
		carList.remove(index);
		index = results.indexOf(max);
		
		if(index != -1) 
			System.out.print(", ");
		return index;
	}

	public static void printTryAsRequest(List<String> carList, String timesInput, List<Integer> results) {
		for(int j = 0; j < Integer.valueOf(timesInput); j++) {
    		playOnceEachCar(carList, results);
    		System.out.println("");
    	}
	}

	public static void playOnceEachCar(List<String> carList, List<Integer> results) {
		for(int i = 0; i < results.size(); i++) {
			goOrStopByRandomNum(results, i);
			printCarAndGoTimes(carList, results, i);
		}
	}

	public static void printCarAndGoTimes(List<String> carList, List<Integer> results, int i) {
		System.out.print(carList.get(i)+" : ");
		for(int k = 0; k < results.get(i); k++) {
			System.out.print("-");
		}
		System.out.println("");
	}
    
	public static void goOrStopByRandomNum(List<Integer> results, int i) {
		int randomNum = Randoms.pickNumberInRange(0,9);
		if(randomNum >= 4) {
			results.set(i, results.get(i)+1);
		}
	}
    
	public static void setCarsOnStart(List<String> carList, List<Integer> results) {
		for(int i = 0; i < carList.size(); i++) {
    		results.add(i, 0);
    	}
	}

	public static void validateTimes(String timesInput) {
		int times = Integer.valueOf(timesInput);
		if(!timesInput.matches("\\d+") || times < MIN_TIMES || times > MAX_TIMES)
    		throw new IllegalArgumentException(MIN_TIMES+"~"+MAX_TIMES+" 사이의 정수로 설정해주세요.");
	}

	public static void validateCarList(List<String> carList) {
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
    		if(carList.get(i).length() > MAX_CAR_NAME_LENGTH)
    			throw new IllegalArgumentException("각 자동차의 이름은 "+MAX_CAR_NAME_LENGTH+"자 이하로 작성해주세요.");
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

	