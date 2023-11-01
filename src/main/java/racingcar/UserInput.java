package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class UserInput {

    /**
     * 기능 1. 자동차 이름 입력 기능
     * 사용자에게 경주할 자동차 이름을 쉼표(,)로 구분해서 입력받고,
     * 이를 검증한 뒤 반환한다.
     * 1) 길이는 1 ~ 5자리 만 가능
     * 2) 중복 불가능
     *
     * @throws IllegalArgumentException 위 검증을 통과하지 못할 시 예외 발생
     * @return 입력 받은 자동차 이름을 key값으로 하고 각 value값이 0으로 초기화 된 Map
     */
    public static Map<String, Integer> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNamesString = Console.readLine().trim();
        return makeCarNameMap(inputCarNamesString);
    }

    private static Map<String, Integer> makeCarNameMap(String inputCarNamesString) {
        verifyIfStartOrEndWithComma(inputCarNamesString);

        Map<String, Integer> carNameMap = new LinkedHashMap<>();
        Arrays.stream(inputCarNamesString.split(","))
                .forEach(carName -> verifyCarName(carNameMap, carName));

        return carNameMap;
    }

    private static void verifyIfStartOrEndWithComma(String inputCarNameString) {
        if (inputCarNameString.startsWith(",") || inputCarNameString.endsWith(",")) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
    }

    private static void verifyCarName(Map<String, Integer> carNameMap, String carName) {
        String carNameTrim = carName.trim();

        if (carNameTrim.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }

        if (carNameTrim.length() > 5) {
            throw new IllegalArgumentException("자동차 이름의 길이는 5자리 이하 이어야 합니다.");
        }

        if (carNameMap.containsKey(carNameTrim)) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }

        carNameMap.put(carNameTrim, 0);
    }


    /**
     * 기능 2. 시도 횟수 입력 기능
     * 사용자에게 몇번의 라운드를 실행할 것인지 입력받고,
     * 이를 검증한 뒤 반환한다.
     * 1) 숫자만 입력 가능
     * 2) 1 이상, 2147483647(MAX_INTEGER 값) 이하의 값만 가능
     *
     * @throws IllegalArgumentException 위 검증을 통과하지 못할 시 예외 발생
     * @return 입력 받은 라운드 횟수
     */
    public static int inputNumberOfRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        String inputNumberOfRoundsString = Console.readLine().trim();
        return verifyIfIsValidNumber(inputNumberOfRoundsString);
    }

    private static int verifyIfIsValidNumber(String inputNumberOfRoundsString) {
        int inputNumberOfRounds = 0;

        try {
            inputNumberOfRounds = Integer.parseInt(inputNumberOfRoundsString);

            if (inputNumberOfRounds < 1) {
                throw new IllegalArgumentException("1 ~ 2147483647 사이의 유효한 숫자를 입력해 주세요.");
            }
            System.out.println();
            return inputNumberOfRounds;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1 ~ 2147483647 사이의 유효한 숫자를 입력해 주세요.");
        }
    }
}
