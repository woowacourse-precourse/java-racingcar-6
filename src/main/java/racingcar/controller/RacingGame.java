package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.component.Cars;
import racingcar.util.RegexMatcher;

public class RacingGame {
    public static void run() {
        int n;
        String str_n;
        Cars cars = new Cars();

        System.out.println("시도할 회수는 몇회인가요?");
        str_n = Console.readLine();
        if (!RegexMatcher.match("^[1-9]{1,9}$", str_n)) {
            throw new IllegalArgumentException("입력은 양수 정수여야 합니다.");
        }
        n = Integer.parseInt(str_n);

        System.out.println("실행 결과");
        for (int i = 0; i < n; i++) {
            cars.runARound();
            System.out.println();
        }
        cars.totalizeWinnersNames();
    }
}
