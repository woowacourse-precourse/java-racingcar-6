package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static racingcar.type.ErrorCode.*;

public class RacingInfo {
    private List<String> carNames;
    private int turn;

    public RacingInfo(List<String> carNames, int turn) {
        validateInputs(turn, carNames);
        this.carNames = carNames;
        this.turn = turn;
    }

    private void validateInputs(int turn, List<String> carNames) {
        if (turn <= 0) {
            throw new IllegalArgumentException(TURN_IS_MORE_THAN_ZERO.getMessage());
        }

        if (!validateCarName(carNames)) {
            throw new IllegalArgumentException(CAR_NAME_IS_NOT_DUPLICATE_AND_LESS_THAN_5.getMessage());
        }
    }

    private boolean validateCarName(List<String> carList) {
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

    public static RacingInfo enter() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carString = Console.readLine();
        List<String> carNames = parseCarString(carString);

        System.out.println("시도할 회수는 몇회인가요?");
        int turn = Integer.parseInt(Console.readLine());

        return new RacingInfo(carNames, turn);
    }

    private static List<String> parseCarString(String carString) {
        return Arrays.stream(carString.split(","))
                .map(String::trim).collect(Collectors.toList());
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getTurn() {
        return turn;
    }
}
