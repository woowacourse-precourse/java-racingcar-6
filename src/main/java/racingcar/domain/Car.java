package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Car {
    public List<String> getNames() {
        List<String> names = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String name = Console.readLine();

        List<String> inputNames = Arrays.asList(name.split(","));

        checkEmpty(inputNames);

        names = inputNames;

        return names;
    }

    public void checkEmpty(List<String> inputNames) {
        try {
            List<String> notNullNames = new ArrayList<>();

            for (int n = 0; n < inputNames.size(); n++) {
                if (inputNames.get(n).isEmpty()) {
                    throw new IllegalArgumentException("이름에 빈값이 있습니다.");
                }
                notNullNames.add(inputNames.get(n));
            }

            checkDuplicate(notNullNames);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void checkDuplicate(List<String> notNullNames) {
        try {
            List<String> notDuplicateNames = new ArrayList<>();

            for (int n = 0; n < notNullNames.size(); n++){
                if (notDuplicateNames.contains(notNullNames.get(n))) {
                    throw new IllegalArgumentException("서로 다른 이름을 입력해 주세요.");
                }
                notDuplicateNames.add(notNullNames.get(n));
            }

            checkLength(notDuplicateNames);

        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void checkLength(List<String> notDuplicateNames) {
        try {
            List<String> correctLengthNames = new ArrayList<>();

            for (int n = 0; n < notDuplicateNames.size(); n++){
                if (notDuplicateNames.get(n).length() > 5) {
                    throw new IllegalArgumentException("자동차 이름의 길이를 5 이하로 지정해주세요.");
                }
                correctLengthNames.add(notDuplicateNames.get(n));
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
