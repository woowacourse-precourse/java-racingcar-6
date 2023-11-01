package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.dto.CarsDTO;

public class OutputView {
    private static String ONE_TURN_MESSAGE = "실행 결과";
    private static String ANNOUNCE_WINNER = "최종 우승자 : ";

    public static void gameStartMessage() {
        System.out.println(ONE_TURN_MESSAGE);
    }

    public static void oneTurnResult(CarsDTO carsDTO) {
        for (Car car : carsDTO.getCarList()) {
            System.out.println(car.getName() + " : " + car.getCarDistanceChar());
        }
        System.out.println();
    }

    public static void announceWinner(String winnerList) {
        System.out.print(ANNOUNCE_WINNER + winnerList);
    }
}
