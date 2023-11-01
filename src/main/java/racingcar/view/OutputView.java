package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.dto.CarsDTO;
import racingcar.utils.GameMessage;

public class OutputView {
    public static void gameStartMessage() {
        System.out.println(GameMessage.ONE_TURN_MESSAGE.getMessage());
    }

    public static void oneTurnResult(CarsDTO carsDTO) {
        for (Car car : carsDTO.getCarList()) {
            System.out.println(car.getName() + " : " + car.getCarDistanceChar());
        }
        System.out.println();
    }

    public static void announceWinner(String winnerList) {
        System.out.print(GameMessage.ANNOUNCE_WINNER.getMessage() + winnerList);
    }
}
