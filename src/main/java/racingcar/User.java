package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class User {
    Validation validation = new Validation();

    public List<String> giveCarName() {
        List<String> carNames;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInsert = Console.readLine();
        carNames = Arrays.asList(userInsert.split(","));

        if (validation.isValidName(carNames)) {
            return carNames;
        }
        throw new IllegalArgumentException("게임이 종료됩니다.");
    }

    public Long numberOfRepeats() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String input = Console.readLine();
        Long number;
        if (validation.isValidNumber(input)) {
            number = Long.parseLong(input);
            return number;
        }
        throw new IllegalArgumentException("횟수 입력이 잘못되었습니다");
    }
}
