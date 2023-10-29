package racingcar.util;

import racingcar.Entity.Car;
import racingcar.constant.CarStatus;
import racingcar.constant.Message;
import racingcar.constant.SymbolType;

import java.util.ArrayList;
import java.util.List;

public class ConsolePrint {
    public void requestCarNameInput() {
        System.out.println(Message.CAR_NAME_REQUEST.getValue());
    }

    public void requestTryCountInput() {
        System.out.println(Message.TRY_COUNT_REQUEST.getValue());
    }
    public void informRacingResult() {
        System.out.println(Message.RESULT_RACING_INFO.getValue());
    }

    public void racingTryResult(Car car, CarStatus status) {
        System.out.println(car.getName() + SymbolType.CAR_RESULT.getValue() + car.getNowMoveTrace());

    }

    public void finalWinner(List<Car> winners) {
        System.out.print(Message.FINAL_WINNER_INFO.getValue());

        ArrayList<String> winnersName = new ArrayList<>();
        for (Car winner : winners) {
            winnersName.add(winner.getName());
        }
        String result = String.join(SymbolType.DELIMITER_PRINT_CARS.getValue(),winnersName);

        System.out.println(result);
    }
}
