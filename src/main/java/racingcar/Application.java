package racingcar;


import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.RacingGameController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final Scanner scanner = new Scanner(System.in);
        RacingGameController racingGameController = new RacingGameController();
        try {
            racingGameController.run(scanner);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    }
}
