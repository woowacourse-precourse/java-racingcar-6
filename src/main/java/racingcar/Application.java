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

        Race racingGame = new Race(carList,trial);

        updateCarPosition(racingGame);

        printWinners(racingGame.getCarNamesWithMaxPosition());



    }

    private static List<Car> createCarListFromUserInput() {
        String [] name = askCarNames().split(",");
        List<String> nameList = List.of(name);
        List<Car> carList = new ArrayList<>();

        for (String s : nameList) {
            carList.add(new Car(s));
        }

        return carList;
    }

}
