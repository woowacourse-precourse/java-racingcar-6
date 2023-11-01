package racingcar;

import java.util.List;
import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class CarNameInput {
    final List<String> nameList;

    CarNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String nameString = Console.readLine();
        nameList = Arrays.asList(nameString.split(","));
    }

    public List<String> getNameList() {
        return nameList;
    }

    public void exceptionHandling() {
        new CarNameException().isException(nameList);
    }

}