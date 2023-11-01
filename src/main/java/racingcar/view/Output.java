package racingcar.view;

import racingcar.domain.Cars;
import racingcar.domain.Winner;

public class Output {

    public static void printCarsNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printRoundInputMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printCars(final Cars cars) {
        System.out.println(cars);
    }

    public static void printWinners(final Winner winner) {
        System.out.println("최종 우승자 : " + winner);
    }
}
