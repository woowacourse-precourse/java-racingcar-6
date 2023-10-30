package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        requestCarNames();
        String CarNames = Console.readLine();
        isCarNamesValid(CarNames);
        
        requestCount();
    }

    static void requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    static void requestCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }


    static void isCarNamesValid(String CarNames) {
        for (int i = 0; i < CarNames.length(); i++) {
            if (CarNames.charAt(i) >= 'a' && CarNames.charAt(i) <= 'z') {
                continue;
            } else if (CarNames.charAt(i) >= '0' && CarNames.charAt(i) <= '9') {
                continue;
            } else if (CarNames.charAt(i) == ',') {
                continue;
            } else {
                throw new IllegalArgumentException("숫자나 영어로 이루어진 자동차 이름을 입력하세요.");
            }
        }
    }
}