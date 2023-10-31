package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.service.RacingCarGameService;
import racingcar.domain.Car;
import racingcar.domain.GameResult;
import racingcar.view.in.GameInputMessage;
import racingcar.view.in.GameInputView;
import racingcar.view.out.GameOutputView;

public class RacingCarGameController {
    private final RacingCarGameService racingCarGameService;
    private final GameInputView inputView;
    private final GameOutputView  gameOutputView;

    public RacingCarGameController(RacingCarGameService racingCarGameService, GameInputView inputView,
                                   GameOutputView gameOutputView) {
        this.racingCarGameService = racingCarGameService;
        this.inputView = inputView;
        this.gameOutputView = gameOutputView;
    }

    public void start() {
        // 1. 자동차 이름 입력
        String input = inputView.requestInput(GameInputMessage.INPUT_CAR_NAME);

        // 2.게임 데이터를 다룰 List 생성
        List<Car> carList = Arrays.stream(input.split(","))
                .peek(this::validationCarNameLength)
                .map(Car::registerCar)
                .collect(Collectors.toList());


        // 3. 이동회수 입력 (숫자만 가능)
        String moveCntString = inputView.requestInput(GameInputMessage.INPUT_RACE_COUNT);
        // TODO : Validation 객체 생성
        int moveCnt = Integer.parseInt(moveCntString);

        // 4. 자동차 전진
        gameOutputView.printRaceStart();
        for (int i = 0; i < moveCnt; i++) {
            carList = racingCarGameService.forwardOrStop(carList);

            carList.stream()
                    .forEach(car -> gameOutputView.printGameProceeding(car.getName(), car.getDistance()));

            gameOutputView.printGapLine();
        }

        // 5. 최대 움직인 자동차 찾기 (result)
        GameResult gameResult = racingCarGameService.winnerResult(carList);

        // 6. 우승자 출력
        gameResult.gameResultPrint();
    }

    private void validationCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하만 입력 가능합니다.");
        }
    }
}
