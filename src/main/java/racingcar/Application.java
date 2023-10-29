package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.Arrays;


public class Application {
    public static void main(String[] args) {
        Map<String, Integer> carNameAndMovementCountMap = inputCarNames();
        int numberOfRounds = inputNumberOfRounds();

        executeAllRounds(carNameAndMovementCountMap, numberOfRounds);
        selectFinalWinner(carNameAndMovementCountMap);
    }


    /**
     * 기능 1. 자동차 이름 입력 기능
     * 사용자에게 경주할 자동차 이름을 쉼표(,)로 구분해서 입력받고,
     * 이를 검증한 뒤 반환한다.
     * 1) 공백 불가능
     * 2) 길이는 5자리 이하만 가능
     * 3) 중복 불가능
     *
     * @throws IllegalArgumentException 위 검증을 통과하지 못할 시 예외발생
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
     * @throws IllegalArgumentException 위 검증을 통과하지 못할 시 예외발생
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


    /**
     * 기능 3. 자동차 전진 기능
     * 차 이름과 이동 횟수가 담긴 Map과 라운드 실행 횟수를 받아서
     * 라운드 횟수 만큼 경주를 실행해서 이동횟수를 업데이트 한다.
     * 모든 라운드가 끝난 뒤 업데이트 된 Map을 반환한다.
     *
     * @param carNameAndMovementCountMap 차 이름과 이동 횟수가 담긴 Map
     * @param numberOfRounds 라운드 실행 횟수
     * @return 업데이트 된 carNameAndMovementCountMap
     */
    public static Map<String, Integer> executeAllRounds(Map<String, Integer> carNameAndMovementCountMap, int numberOfRounds) {
        System.out.println("실행 결과");
        for (int i = 0; i < numberOfRounds; i++) {
            executeMovement(carNameAndMovementCountMap);
        }
        return carNameAndMovementCountMap;
    }

    private static void executeMovement(Map<String, Integer> carNameAndMovementCountMap) {
        carNameAndMovementCountMap.forEach((carName, movementCount) -> {
            if (Randoms.pickNumberInRange(0, 9) > 3) {
                carNameAndMovementCountMap.put(carName, ++movementCount);
            }
            ;
            printResultAfterMovement(carName, movementCount);
        });
        System.out.println();
    }

    private static void printResultAfterMovement(String carName, Integer movementCount) {
        System.out.print(carName + " : ");

        for (int j = 0; j < movementCount; j++) {
            System.out.print("-");
        }
        System.out.println();
    }


    /**
     * 기능 4. 게임 완료 후 우승자 선출 기능
     * 차 이름과 이동 횟수가 담긴 Map 을 받아서
     * 이동 횟수가 가장 많은 차 이름의 리스트를 반환한다.
     *
     * @param carNameAndMovementCountMap 차 이름, 이동 횟수 맵
     * @return 우승자 이름 리스트
     */
    public static List<String> selectFinalWinner(Map<String, Integer> carNameAndMovementCountMap) {
        List<String> winnerList = new ArrayList<>();

        Integer maxMovementValue = carNameAndMovementCountMap.values()
                .stream()
                .max(Comparator.comparingInt(Integer::intValue))
                .orElseThrow();

        carNameAndMovementCountMap.forEach((carName, movementCount) -> {
            if (Objects.equals(movementCount, maxMovementValue)) {
                winnerList.add(carName);
            }
        });

        printWinnerList(winnerList);
        return winnerList;
    }

    private static void printWinnerList(List<String> winnerList) {
        String result = String.join(", ", winnerList);
        System.out.println("최종 우승자 : " + result);
    }
}