package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
    	startGameProcess();
    }

    //차 이름을 HashMap<차이름,전진횟수>에 넣기
    public static Map<String, Integer> setCarRacingRecord(List<String> carList){
    	Map<String,Integer> carRacingRecord = new HashMap<String,Integer>();
    	for(String carName : carList) {
    		carRacingRecord.put(carName, 0);
    	}
    	return carRacingRecord;
    }
    
    //랜덤한 수 출력하기
    public static int getRandomNumber() {
    	int randomNumber = Randoms.pickNumberInRange(0,9);
    	return randomNumber;
    }
    
    //랜덤 수가 4이상인지 판별하기
    public static boolean checkRandomNumber(int randomNumber) {
    	if(randomNumber >= 4) {
    		return true;
    	}
    	return false;
    }
    
    //랜덤수를 통해 전진조건이 된 차 전진하기
    public static Map<String, Integer> updateCarRacingRecord(List<String> carList, Map<String, Integer> carRacingRecord){
    	for(String carName : carList) {
			int randomNumber = getRandomNumber();
			if(checkRandomNumber(randomNumber)) {
				carRacingRecord.put(carName, carRacingRecord.get(carName)+1);
			}
		}
    	return carRacingRecord;
    }
    
    //전진 횟수 (-)으로 표시하기
    public static String getRacingRecord(int recordNumber) {
    	StringBuilder racingRecord = new StringBuilder();
    	for(int i=0;i<recordNumber;i++) {
    		racingRecord.append("-");
    	}
    	return racingRecord.toString();
    }
    
    //전진이 된 차 기록 출력하기 
    public static void printCarRacingRecord(List<String> carList, Map<String,Integer> carRacingRecord) {
    	for(String carName : carList) {
    		String racingRecord=getRacingRecord(carRacingRecord.get(carName));
    		System.out.println(carName+" : "+racingRecord);
    	}
    }
    
    //저장된 Map에서 최댓값을 가지는 차 이름 가져오기
    public static List<String> getWinner(Map<String, Integer> carRacingRecord, int maxRecord){
    	List<String> winners = new ArrayList<>();
    	for(String carName : carRacingRecord.keySet()) {
    		if(carRacingRecord.get(carName)==maxRecord) {
    			winners.add(carName);
    		}
    	}
    	return winners;
    }

    //전체 게임 과정
	private static void startGameProcess() {
		Message.printCarNameMessage();
		Message.printMovingNumberMessage();
		String carNames = Input.inputCarName();
		List<String> carList = Input.separateCarNameInput(carNames);
		int movingNumber = Input.inputMovingNumber();
		Map<String, Integer> carRacingRecord = setCarRacingRecord(carList);
		Message.printCarRacingResult(movingNumber,carList,carRacingRecord);
		Message.printGameResult(carList,carRacingRecord);
	}
    
}
