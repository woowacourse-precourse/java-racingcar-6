package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;
import racingcar.domain.WinnerResult;
import racingcar.utility.ConstraintValidator;
import racingcar.utility.Parser;
import racingcar.view.View;

import java.util.List;

import static racingcar.view.constants.Notice.*;

public class Game {
    public static void start() {
        // 경주할 자동차 이름 요청 메세지 출력 (Controller -> View)
        View.printNotice(ASK_MULTIPLE_CAR_NAMES);

        // 사용자에게 자동차 이름 요청 (View -> Controller)
        String carNamesInput = Console.readLine();

        // 개별 Car를 담은 일급 컬렉션 Cars 생성 (Controller -> Domain)
        Cars cars = Cars.create(carNamesInput);

        // 시도할 횟수 요청 메세지 출력 (Controller -> View)
        View.printNotice(ASK_GAME_COUNT);
        // 사용자에게 시도할 횟수 요청 (View -> Controller)
        String gameCountInput = Console.readLine();
        System.out.println();

        // 횟수 요청 예외처리
        ConstraintValidator.validateNumber(gameCountInput);

        View.printNotice(RESPONSE_RESULT_MESSAGE);

        int roundCount = Parser.parseRoundCount(gameCountInput);

        for (int i = 0; i < roundCount; i++) {
            cars.playOneRound();
            List<String> results = cars.generateResults();
            View.printResultList(results);
        }

        WinnerResult winnerResult = cars.getWinnerCars();
        System.out.println("winnerResult.getWinnerNames() = " + winnerResult.getWinnerNames());
        Console.close();
    }
}
