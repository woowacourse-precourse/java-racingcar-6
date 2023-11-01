package racingcar.view;

import static racingcar.system.SystemMessage.GAME_RESULT;
import static racingcar.system.SystemMessage.GAME_WINNER;

import java.util.List;
import java.util.Map;
import racingcar.car.Car;
import racingcar.car.CarsStatusDto;

public class OutputView {

    public void responseRaceResultMessage() {
        System.out.println(GAME_RESULT.getMessage());
    }

    public void responseCurrentCarsStatus(CarsStatusDto carsStatusDto) {
        StringBuilder displayBoard = new StringBuilder();
        Map<Car, String> currentCarPositions = carsStatusDto.getCurrentCarsPositions();
        currentCarPositions.forEach(
                (k,v) -> displayBoard
                        .append(k).append(" : ").append(v).append("\n")
        );
        System.out.println(displayBoard);
    }

    public void responseRaceWinner(List<String> winnerList) {
        StringBuilder champion = new StringBuilder();
        champion.append(GAME_WINNER.getMessage());
        for (int count = 0; count < winnerList.size(); count++) {
            if (count > 0) {
                champion.append(", ");
            }
            champion.append(winnerList.get(count));
        }
        System.out.println(champion);
    }
}
