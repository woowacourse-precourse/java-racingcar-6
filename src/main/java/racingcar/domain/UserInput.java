package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class UserInput {
    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> nameList = NameValidator.splitComma(input);
        if (!NameValidator.correctNumberOfChar(nameList)) {
            throw new IllegalArgumentException("글자수를 초과 입력하여 게임을 종료합니다.");
        }
        if (!NameValidator.hasOnlyAlphabets(nameList)) {
            throw new IllegalArgumentException("영문자 외의 값을 입력하여 게임을 종료합니다.");
        }
        if (!NameValidator.isNotRedundant(nameList)) {
            throw new IllegalArgumentException("중복된 값을 입력하여 게임을 종료합니다.");
        }
        return nameList;
    }

    public static int setRoundOfGame() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        int round = RoundValidator.checkNaturalNumber(input);
        return round;
    }
}
