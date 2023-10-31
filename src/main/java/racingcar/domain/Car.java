package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Car {
    public List<String> getNames() {
        List<String> names = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String name = Console.readLine();

        List<String> inputNames = splitInputNames(name);
        validateInputNames(inputNames);

        names.addAll(inputNames);
        return names;
    }

    public List<String> splitInputNames(String name) {

        List<String> inputNames = Arrays.asList(name.split(",", -1));
        validateInputNames(inputNames);

        return inputNames;
    }

    public void validateInputNames(List<String> inputNames) {
        checkEmpty(inputNames);
        checkDuplicate(inputNames);
        checkLength(inputNames);
    }

    public void checkEmpty(List<String> inputNames) {
        for (String inputName : inputNames) {
            if (inputName.isEmpty()) {
                throw new IllegalArgumentException("이름에 빈값이 있습니다.");
            }
        }
    }

    public void checkDuplicate(List<String> inputNames) {
        Set<String> uniqueNames = new HashSet<>();
        for (String inputName : inputNames) {
            if (!uniqueNames.add(inputName)) {
                throw new IllegalArgumentException("이름에 중복 값이 있습니다. 서로 다른 이름을 입력해 주세요.");
            }
        }
    }

    public void checkLength(List<String> inputNames) {
        for (String inputName : inputNames) {
            if (inputName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름의 길이를 5 이하로 지정해주세요.");
            }
        }
    }
}
