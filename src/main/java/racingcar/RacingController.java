package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Entity.Car;
import racingcar.constant.CarStatus;
import racingcar.util.Calculation;
import racingcar.util.ConsolePrint;
import racingcar.util.Exception;
import racingcar.util.Parsing;

import java.util.List;

public class RacingController {
    private Exception exception = new Exception();
    private ConsolePrint consolePrint = new ConsolePrint();
    private Parsing parsing = new Parsing();
    private Calculation calculation = new Calculation();
    public void startGame() {
        consolePrint.requestCarNameInput();
        String carNameInput = Console.readLine();
        exception.isNameNull(carNameInput);
        List<Car> cars =  parsing.StringToCarList(carNameInput);
        for (Car car : cars) {
            exception.isNameNull(car.getName());
            exception.isNameInRange(car.getName());
        }

        consolePrint.requestTryCountInput();
        String tryCountInput = Console.readLine();
        exception.isInteger(tryCountInput);
        int tryCount = parsing.stringToInt(tryCountInput);
        exception.isGreaterThanZero(tryCount);

        consolePrint.informRacingResult();
        int i = 0;
        while(i++ <= tryCount) {
            for (Car car : cars) {
                int randomNumber = calculation.generateRandomNumberInRange();
                CarStatus carStatus = calculation.judgeCarMoveOrStop(randomNumber);
                car.setMoveCount(carStatus);
                car.setNowMoveTrace(carStatus);

                consolePrint.racingTryResult(car,carStatus);
            }
            System.out.println();
        }

        List<Car> winners = calculation.judgeWhoIsWinner(cars);

        consolePrint.finalWinner(winners);
    }
}
