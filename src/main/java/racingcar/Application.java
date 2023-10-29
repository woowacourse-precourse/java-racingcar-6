package racingcar;


import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        readNames();
    }

    public static String[] readNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");

        if (!isValidString(names)) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다.");
        }

        return names;
    }

    public static boolean isValidString(String[] names) {
        Set<String> uniqueNames = new HashSet<>();

        if (names.length <= 1) {
            return false;
        }

        for (String name : names) {
            if (name.length() > 5) {
                return false;
            }
            if (name.isEmpty()) {
                return false;
            }
            if (!uniqueNames.add(name)) {
                return false;
            }
        }
        
        return true;
    }

}
