package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Game;

public class OutputView {

    /* 자동차별 라운드 결과 출력 */
    public static void printStatusOfRaceCar(Car car) {
        System.out.print(car.name() + " : ");
        for (int i = 0; i < car.position(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /* 최종 우승자 출력 */
    public static void printGameWinner(Game game) {
        System.out.println("");
    }
}
