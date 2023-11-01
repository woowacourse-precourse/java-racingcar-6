package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class UserInput {
    public static List<String> setCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> nameList = NameValidator.validate(input);
        return nameList;
    }

    public static int setRoundOfGame() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        int round = RoundValidator.checkNaturalNumber(input);
        return round;
    }
}
