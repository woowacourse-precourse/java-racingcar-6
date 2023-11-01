package racingcar;

import racingcar.domain.Car;
import racingcar.game.Race;

import java.util.ArrayList;
import java.util.List;

import static racingcar.game.CarRaceExecutor.updateCarPosition;
import static racingcar.view.InputView.askCarNames;
import static racingcar.view.InputView.askRunningCnt;
import static racingcar.view.OutputView.*;


public class Application {
    public static void main(String[] args) {

        List<Car> carList = createCarListFromUserInput();

        int trial = askRunningCnt();
        System.out.print("\n");

        Race racingGame = new Race(carList, trial);

        System.out.println("실행 결과");
        updateCarPosition(racingGame);

        printWinners(racingGame.getCarNamesWithMaxPosition());

    }

    private static List<Car> createCarListFromUserInput() {
        String[] name = askCarNames().split(",");
        List<String> nameList = List.of(name);
        List<Car> carList = new ArrayList<>();

        for (String carName : nameList) {
            if (carList.stream().anyMatch(car -> car.getName().equals(carName))) {
                throw new IllegalArgumentException("중복된 이름을 입력하셨습니다. : " + carName);
            } else {
                carList.add(new Car(carName));
            }

        }

        return carList;
    }

}
