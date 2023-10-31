package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.constants.GameConstants;
import racingcar.service.RacingCarGameService;
import racingcar.domain.Car;
import racingcar.domain.GameResult;
import racingcar.validator.GameValidator;
import racingcar.view.in.GameInputMessage;
import racingcar.view.in.GameInputView;
import racingcar.view.out.GameOutputView;

public class RacingCarGameController {
    private final RacingCarGameService racingCarGameService;

    public RacingCarGameController(RacingCarGameService racingCarGameService) {
        this.racingCarGameService = racingCarGameService;
    }

    public void start() {
        // 1. 자동차 이름 입력
        String input = GameInputView.requestInput(GameInputMessage.INPUT_CAR_NAME);

        // 2.게임 데이터를 다룰 List 생성
        List<Car> carList = Arrays.stream(input.split(GameConstants.COMMA_SEPARATOR))
                .peek(GameValidator::validationCarNameLength)
                .map(Car::registerCar)
                .collect(Collectors.toList());


        // 3. 이동회수 입력 (숫자만 가능)
        String moveCntString = GameInputView.requestInput(GameInputMessage.INPUT_RACE_COUNT);
        GameValidator.validationMoveCntIsNumber(moveCntString);
        int moveCnt = Integer.parseInt(moveCntString);

        // 4. 자동차 전진
        GameOutputView.printRaceStart();
        for (int i = 0; i < moveCnt; i++) {
            carList = racingCarGameService.forwardOrStop(carList);

            carList.stream()
                    .forEach(car -> GameOutputView.printGameProceeding(car.getName(), car.getDistance()));

            GameOutputView.printGapLine();
        }

        // 5. 최대 움직인 자동차 찾기 (result)
        GameResult gameResult = racingCarGameService.winnerResult(carList);

        // 6. 우승자 출력
        gameResult.gameResultPrint();
    }
}
