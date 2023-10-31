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
