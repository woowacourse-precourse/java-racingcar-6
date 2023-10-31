package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.service.RacingCarGameService;
import racingcar.domain.Car;
import racingcar.domain.GameResult;

public class RacingCarGameController {
    private final RacingCarGameService racingCarGameService;

    public RacingCarGameController(RacingCarGameService racingCarGameService) {
        this.racingCarGameService = racingCarGameService;
    }

    public void start() {
        // 1. 자동차 이름 입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        // 2.게임 데이터를 다룰 List 생성
        List<Car> carList = Arrays.stream(input.split(","))
                .peek(this::validationCarNameLength)
                .map(Car::registerCar)
                .collect(Collectors.toList());


        // 3. 이동회수 입력 (숫자만 가능)
        int moveCnt = inputMoveCount();

        // 4. 자동차 전진
        System.out.println("실행 결과");
        for (int i = 0; i < moveCnt; i++) {
            carList = racingCarGameService.forwardOrStop(carList);

            for (Car car : carList) {
                System.out.printf("%s : %s\n", car.getName(), "-".repeat(car.getDistance()));
            }
            System.out.println();
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

    private int inputMoveCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }
}
