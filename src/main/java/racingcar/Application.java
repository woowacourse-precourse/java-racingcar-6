package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.StringJoiner;
import racingcar.domain.Car;
import racingcar.domain.CarGroup;
import racingcar.validator.InputValidator;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CarGroup carGroup = new CarGroup();
        inputCars(carGroup);

        int tryCount = inputCount();
        raceStart(tryCount, carGroup);

        StringJoiner raceWinners = carGroup.getWinners();
        OutputView.printWinners(raceWinners);
    }

    private static void raceStart(int tryCount, CarGroup carGroup) {
        OutputView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            carGroup.moveCars();
            OutputView.printProgress(carGroup);
        }
    }

    private static int inputCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = readLine();
        new InputValidator().validateTryCount(input);
        return Integer.parseInt(input);
    }

    private static void inputCars(CarGroup carGroup) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = readLine();
        for (String carName : cars.split(",")) {
            Car car = new Car(carName);
            carGroup.addCar(car);
        }
    }
}
