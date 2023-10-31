package racingcar;

import java.util.List;
import java.util.Map;

public class Game {

    //전체 게임 과정
    public static void run() {
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
