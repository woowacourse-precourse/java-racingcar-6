package racingcar;

import java.util.List;

public class Game {

    private InputView inputView;

    private List<Car> cars;

    public void determineAndPrintWinners() {

        int numberOfMoves = inputView.getNumberOfMoves();

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
