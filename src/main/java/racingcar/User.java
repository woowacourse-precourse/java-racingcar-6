package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class User {
    Validation validation = new Validation();

    public List<String> GiveCarName() {
        List<String> carNames;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInsert = Console.readLine();
        carNames = Arrays.asList(userInsert.split(","));
        if (!validation.isLessThanSix(carNames)) {
            throw new IllegalArgumentException("5글자 이하로 입력해주세요.");
        }
        return carNames;
    }
}
