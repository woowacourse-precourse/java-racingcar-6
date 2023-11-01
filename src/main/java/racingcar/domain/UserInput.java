package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class UserInput {
    public static List<String> setCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> nameList;
        try {
            String input = Console.readLine();
            NameValidator nameValidator = new NameValidator();
            nameList = nameValidator.validate(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 값을 입력하여 게임을 종료합니다.");
        }
        return nameList;
    }

    public int setRoundOfGame() {
        System.out.println("시도할 회수는 몇회인가요?");
        int round;
        try {
            String input = Console.readLine();
            RoundValidator roundValidator = new RoundValidator();
            round = roundValidator.validate(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 값을 입력하여 게임을 종료합니다.");
        }
        return round;
    }
}
