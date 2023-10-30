package racingcar;

import java.util.List;
import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class CarNameInput {
    final List<String> nameList;
    final int maxNameLength = 5;


    CarNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String nameString = Console.readLine();
        nameList = Arrays.asList(nameString.split(","));
    }

    public boolean isValidNameLength() {
        for (String carName : nameList) {
            if (carName.length() == 0 || carName.length() > maxNameLength) return false;
        }
        return true;
    }

    public boolean isBlankString() {
        for (String carName : nameList) {
            if (carName.isBlank()) return true;
        }
        return false;
    }


    public void carNameException() throws IllegalArgumentException {
        if (!isValidNameLength() || isBlankString()) throw new IllegalArgumentException();
    }

    public List<String> getNameList(){
        return nameList;
    }


}