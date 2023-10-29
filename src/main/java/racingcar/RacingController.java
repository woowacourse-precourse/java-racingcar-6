package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class RacingController {
    private Exception exception = new Exception();
    private ConsolePrint consolePrint = new ConsolePrint();
    private Parsing parsing = new Parsing();
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

    }
}
