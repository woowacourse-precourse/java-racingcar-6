package racingcar;

import racingcar.Entity.Car;
import racingcar.constant.CarStatus;
import racingcar.util.Calculation;
import racingcar.util.ConsolePrint;
import racingcar.util.Exception;
import racingcar.util.Parsing;

import java.util.List;

public class RacingService {
    private Exception exception = new Exception();
    private ConsolePrint consolePrint = new ConsolePrint();
    private Parsing parsing = new Parsing();
    private Calculation calculation = new Calculation();

    public void playRacing(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = calculation.generateRandomNumberInRange();

            CarStatus carStatus = calculation.judgeCarMoveOrStop(randomNumber); // 랜덤 숫자별 전진 & 중지 상태 반환
            car.setMoveCount(carStatus);
            car.setNowMoveTrace(carStatus);
        }

        consolePrint.racingTryResult(cars);
    }

    public List<Car> carInputExceptionAndParsing(String carNameInput) {
        exception.isNameNull(carNameInput);
        List<Car> cars = parsing.StringToCarList(carNameInput);
        for (Car car : cars) {
            exception.isNameNull(car.getName());
            exception.isNameInRange(car.getName());
        }

        return cars;
    }

    public int tryCountExceptionAndParsing(String tryCountInput) {
        exception.isInteger(tryCountInput);
        int tryCount = parsing.stringToInt(tryCountInput);
        exception.isGreaterThanZero(tryCount);

        return tryCount;
    }
}
