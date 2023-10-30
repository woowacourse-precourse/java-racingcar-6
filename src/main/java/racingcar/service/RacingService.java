package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Constants;
import racingcar.Entity.Racing;
import racingcar.view.SystemInputMessage;

public class RacingService {

    Racing racing = new Racing();

    public void initRacing() {
        SystemInputMessage.showStartGameMessage();
        racing.ready(InputCarName());
        SystemInputMessage.showTryCountMessage();
        racing.setCount(InputTryCount());
    }

    private int InputTryCount() {
        return Integer.parseInt(Console.readLine());
    }

    // 자동차 이름 입력
    public String[] InputCarName() {
        String carsString = Console.readLine();
        String[] cars = carsString.split(Constants.COMMA);
        try {
            IsValidName(cars);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return InputCarName();
        }
        return cars;
    }

    private void IsValidName(String[] cars) {
        for (String car : cars) {
            if (car.length() > Constants.MAXIMUM_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(Constants.NAME_LENGTH_ERROR_MESSAGE);
            }
        }
    }
}
