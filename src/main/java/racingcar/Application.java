package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> carNameList = inputCarNames();
        int numberOfMoves = inputNumberOfMoves();


    }

    public static int inputNumberOfMoves() {
        System.out.println("시도할 회수는 몇회인가요?");
        String inputNumberOfMovesString = Console.readLine().trim();
        return makeNumberOfMovesInteger(inputNumberOfMovesString);
    }

    private static int makeNumberOfMovesInteger(String inputNumberOfMovesString) {
        return verifyIfIsValidNumber(inputNumberOfMovesString);
    }

    private static int verifyIfIsValidNumber(String inputNumberOfMovesString) {
        int inputNumberOfMoves = 0;

        try {
            inputNumberOfMoves = Integer.parseInt(inputNumberOfMovesString);

            if (inputNumberOfMoves < 1) {
                throw new IllegalArgumentException("1 ~ 2147483647 사이의 유효한 숫자를 입력해 주세요.");
            }

            return inputNumberOfMoves;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1 ~ 2147483647 사이의 유효한 숫자를 입력해 주세요.");
        }
    }

    public static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNamesString = Console.readLine().trim();
        return makeCarNameList(inputCarNamesString);
    }

    private static List<String> makeCarNameList(String inputCarNamesString) {
        verifyIfStartOrEndWithComma(inputCarNamesString);

        List<String> carNameList = new ArrayList<>();
        Arrays.stream(inputCarNamesString.split(","))
                .forEach(carName -> verifyCarName(carNameList, carName));

        return carNameList;
    }

    private static void verifyIfStartOrEndWithComma(String inputCarNameString) {
        if (inputCarNameString.startsWith(",") || inputCarNameString.endsWith(",")) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
    }

    private static void verifyCarName(List<String> carNameList, String carName) {
        String carNameTrim = carName.trim();

        if (carNameTrim.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }

        if (carNameTrim.length() > 5) {
            throw new IllegalArgumentException("자동차 이름의 길이는 5자리 이하 이어야 합니다.");
        }

        if (carNameList.contains(carNameTrim)) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }

        carNameList.add(carNameTrim);
    }
}
