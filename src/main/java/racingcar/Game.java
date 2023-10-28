package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private InputView inputView;

    private List<Car> cars;

    public Game(InputView inputView) {

        this.inputView = inputView;
        this.cars = new ArrayList<>();
    }

    public void playGame() {

        List<String> carNames = inputView.getCarNames();
        int numberOfMoves = inputView.getNumberOfMoves();

        for (String carName : carNames) {

            cars.add(new Car(carName));
        }

        for (int i = 0; i < numberOfMoves; i++) {

            for (Car car : cars) {

                car.determineCarState();
            }

            inputView.printRaceProgress(cars);
        }

        determineAndPrintWinners(numberOfMoves);
    }

    private void determineAndPrintWinners(int numberOfMoves) {

        StringBuilder winners = new StringBuilder();

        for (Car car : cars) {

            if (numberOfMoves == car.getCarPosition()) {

                if (!winners.isEmpty()) {

                    winners.append(", ");
                }

                winners.append(car.getCarName());
            }
        }

        if (!winners.isEmpty()) {

            winners.insert(0, "최종 우승자 : ");

            System.out.println(winners);
        }
    }
}
