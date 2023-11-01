package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.component.Cars;

public class RacingGame {
    public static void run() {
        int n;
        Cars cars = new Cars();

        System.out.println("시도할 회수는 몇회인가요?");
        n = Integer.parseInt(Console.readLine());

        System.out.println("실행 결과");
        for (int i = 0; i < n; i++) {
            cars.runARound();
            System.out.println();
        }
        cars.totalizeWinnersNames();
    }
}
