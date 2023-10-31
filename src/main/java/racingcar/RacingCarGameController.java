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
        String input = Console.readLine();
        String[] split = input.split(",");

        // 2.게임 데이터를 다룰 List 생성
        Map<String, Integer> racingCar = new HashMap<>();

        // 3.자동차 이름 검증
        for (int i = 0; i < split.length; i++) {

            // 3-1.자동차 이름 길이 검증
            if (split[i].length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 5자 이하만 입력 가능합니다.");
            }


            // 3-2.자동차 이름 중복 검증
            if (racingCar.containsKey(split[i])) {
                throw new IllegalArgumentException("중복된 자동차가 존재합니다.");
            }
            racingCar.put(split[i], 0);
        }


        // 4. 이동회수 입력 (숫자만 가능)
        int moveCnt;
        try {
            moveCnt = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {

            // 4-1. 숫자인지 검증
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }


        // 5. 자동차 전진
        for (int i = 0; i < moveCnt; i++) {
            for (String car : racingCar.keySet()) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if (randomNumber >= 4) {
                    racingCar.put(car, racingCar.get(car) + 1);
                }
            }


            // 5-1. 자동차 이동 중 출력
            for (String car : racingCar.keySet()) {
                System.out.print(car + " : ");
                for (int j = 0; j < racingCar.get(car); j++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }

        // 6. 최대 움직인 자동차 찾기 (result)
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

        // 7. 우승자 출력
        String result = resultList.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + result);
    }
}
