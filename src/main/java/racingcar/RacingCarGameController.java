package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.domain.Car;

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
        for (int i = 0; i < moveCnt; i++) {
            for (String car : racingCar.keySet()) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if (randomNumber >= 4) {
                    racingCar.put(car, racingCar.get(car) + 1);
                }
            }


            // 4-1. 자동차 이동 중 출력
            for (String car : racingCar.keySet()) {
                System.out.print(car + " : ");
                for (int j = 0; j < racingCar.get(car); j++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }

        // 5. 최대 움직인 자동차 찾기 (result)
        int maxValue = racingCar.values().stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(Integer.MIN_VALUE);

        List<String> resultList = new ArrayList<>();

        for (String car : racingCar.keySet()) {
            if (racingCar.get(car) == maxValue) {
                resultList.add(car);
            }
        }

        // 6. 우승자 출력
        String result = resultList.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + result);
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
