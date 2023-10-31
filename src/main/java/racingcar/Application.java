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

    //전체 게임 과정
	private static void startGameProcess() {
		Message.printCarNameMessage();
		Message.printMovingNumberMessage();
		String carNames = Input.inputCarName();
		List<String> carList = Input.separateCarNameInput(carNames);
		int movingNumber = Input.inputMovingNumber();
		Map<String, Integer> carRacingRecord = RacingCar.setCarRacingRecord(carList);
		Message.printCarRacingResult(movingNumber,carList,carRacingRecord);
		Message.printGameResult(carList,carRacingRecord);
	}
    
}
