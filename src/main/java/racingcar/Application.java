package racingcar;

import racingcar.controller.GameController;
import racingcar.model.Car;
import racingcar.view.ConsoleView;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        ConsoleView consoleView = new ConsoleView();

        consoleView.printWelcomeMessage();
        String carNameInput = Console.readLine();
        int tryCount = consoleView.getTryCount();

        GameController race = new GameController();
        String[] carNames = carNameInput.split(",");
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해야 합니다.");
            }
            Car car = new Car(name);
            race.addCar(car);
        }

        race.moveCars(tryCount);

        consoleView.printRaceResult(race);
    }
}
