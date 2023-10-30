package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        requestCarNames();
        String carNames = Console.readLine();
        isCarNameValid(carNames);
        isCarNameStringValid(carNames);
        List<String> carNamesArray = splitStringToArrayList(carNames);
        isCarNameValidLength(carNamesArray);
        isCarNameDuplicate(carNamesArray);

        requestCount();
    }

    static void requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    static void requestCount() {
        System.out.println("시도할 회수는 몇회인가요?");
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


}