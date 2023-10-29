package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Judgement {
    public static List<String> getNamesFromUser(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        List<String> names = separateCarNames(carNames);
        checkNameIsValid(carNames);

    }

    private static List<String> separateCarNames(String carNames) {
    }

    private static void checkNameIsValid(String carNames) {
    }
}
