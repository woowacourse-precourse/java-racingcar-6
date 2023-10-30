package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.CarNumberHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        // 사용자로부터 자동차 이름을 입력 받는다.
        requestCarNames();
        String carNames = Console.readLine();
        isInputEmpty(carNames);
        isCarNameValid(carNames);
        isCarNameStringValid(carNames);
        List<String> carNamesArray = splitStringToArrayList(carNames);
        isCarNameValidLength(carNamesArray);
        isCarNameDuplicate(carNamesArray);
        // 사용자로부터 시도할 횟수를 입력 받는다.
        requestCount();
        String StringCount = Console.readLine();
        isInputEmpty(StringCount);
        int userCount = getUserCount(StringCount);

    }

    static void requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    static void requestCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    static void isInputEmpty(String input) throws IllegalArgumentException {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[error] 값을 입력하세요.");
        }
    }

    static void isCarNameValid(String carNames) throws IllegalArgumentException {
        for (int i = 0; i < carNames.length(); i++) {
            if (carNames.charAt(i) >= 'a' && carNames.charAt(i) <= 'z') {
                continue;
            } else if (carNames.charAt(i) >= '0' && carNames.charAt(i) <= '9') {
                continue;
            } else if (carNames.charAt(i) == ',') {
                continue;
            } else {
                throw new IllegalArgumentException("[error] 숫자나 영어로 이루어진 자동차 이름을 입력하세요.");
            }
        }
    }

    static void isCarNameStringValid(String carNames) throws IllegalArgumentException {
        int carNameStringLength = carNames.length();
        if (carNames.charAt(0) == ',' || carNames.charAt(carNameStringLength - 1) == ',') {
            throw new IllegalArgumentException("[error] 잘못된 형식의 입력입니다.");
        }
    }

    static List<String> splitStringToArrayList(String carNames) {
        String[] carNamesStringArray = carNames.split(",");
        List<String> carNamesArray = new ArrayList<>(Arrays.asList(carNamesStringArray));
        return carNamesArray;
    }

    static void isCarNameDuplicate(List<String> carNamesArray) throws IllegalArgumentException {
        Set<String> set = new HashSet<>();
        for (String carName : carNamesArray) {
            if (!set.add(carName)) {
                throw new IllegalArgumentException("[error] 자동차 이름이 중복되었습니다.");
            }
        }
    }

    static void isCarNameValidLength(List<String> carNamesArray) throws IllegalArgumentException {
        for (String carName : carNamesArray) {
            if (carName.isEmpty() || carName.length() > 5) {
                throw new IllegalArgumentException("[error] 자동차 이름의 길이는 1이상 5이하 이어야 합니다");
            }
        }
    }

    static int getUserCount(String stringCount) throws IllegalArgumentException {
        if (stringCount.charAt(0) == '0') {
            throw new IllegalArgumentException("[error] 시도 횟수는 1이상의 정수 이어야 합니다.");
        }
        for (int i = 1; i < stringCount.length(); i++) {
            if (!(stringCount.charAt(i) >= '0' && stringCount.charAt(i) <= '9')) {
                throw new IllegalArgumentException("[error] 시도 횟수는 1이상의 정수 이어야 합니다.");
            }
        }
        return Integer.parseInt(stringCount);
    }
}