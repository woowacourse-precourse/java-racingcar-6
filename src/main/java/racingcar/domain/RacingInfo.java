package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RacingInfo {
    private List<String> carNames;
    private int turn;

    public List<String> getCarNames() {
        return carNames;
    }

    public int getTurn() {
        return turn;
    }

    public RacingInfo(List<String> carNames, int turn) {
        this.carNames = carNames;
        this.turn = turn;
    }

    public static RacingInfo enter() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = Arrays.stream(Console.readLine().split(","))
                .map(String::trim).collect(Collectors.toList());
        if (!validateCarName(carNames)) {
            throw new IllegalArgumentException("중복되지 않는 자동차 이름을 입력해주세요.");
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int turn = Integer.parseInt(Console.readLine());
        if (turn <= 0) {
            throw new IllegalArgumentException("0보다 큰 회수를 입력해주세요.");
        }

        return new RacingInfo(carNames, turn);
    }

    private static boolean validateCarName(List<String> carList) {
        Set<String> set = new HashSet<>();
        for (String carStr : carList) {
            // 자동차 이름 5자 이하 체크
            if (carStr.length() > 5) {
                return false;
            }

            // 자동차 이름 중복 체크
            if (set.contains(carStr)) {
                return false;
            }
            set.add(carStr);
        }
        return true;
    }
}
