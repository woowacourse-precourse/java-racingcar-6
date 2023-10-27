package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import static racingcar.view.constants.Notice.ASK_GAME_COUNT;
import static racingcar.view.constants.Notice.ASK_MULTIPLE_CAR_NAMES;

public class Game {
    public static void start() {
        // 경주할 자동차 이름 요청 메세지 출력 (Controller -> View)
        OutputView.printNotice(ASK_MULTIPLE_CAR_NAMES);

        // 사용자에게 자동차 이름 요청 (View -> Controller)
        String carNamesInput = InputView.playerInput();

        // 개별 Car를 담은 일급 컬렉션 Cars 생성 (Controller -> Domain)
        Cars cars = Cars.create(carNamesInput);

        // 시도할 횟수 요청 메세지 출력 (Controller -> View)
        OutputView.printNotice(ASK_GAME_COUNT);

        // 사용자에게 시도할 횟수 요청 (View -> Controller)
        String gameCountInput = InputView.playerInput();

        // 횟수 요청 예외처리
        Validator.validateNumber(gameCountInput);
    }
}
