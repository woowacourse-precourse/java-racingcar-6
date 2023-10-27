package racingcar.view;

import static racingcar.utils.InputValidator.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Car;

public class RacingCarView implements CarView {
    @Override
    public String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine();
        String[] splitedInputCars = cars.split(",");

        carNameValidate(splitedInputCars);

        return splitedInputCars;
    }

    @Override
    public int inputGameCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String count = Console.readLine();

        gameCountValidate(count);

        return Integer.parseInt(count);
    }

    @Override
    public void outputRaceResult(List<Car> cars) {
        for (Car car : cars) {
            String graphicOfDistance = DistanceFormat.DISTANCE_FORMAT.repeat(car.getDistance());
            System.out.println(car.getName() + " : " + graphicOfDistance);
        }
        System.out.println();
    }

    @Override
    public void outputWinners() {

    }
}
