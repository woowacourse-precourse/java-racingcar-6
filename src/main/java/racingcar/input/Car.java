package racingcar.input;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;
    private static final int NAME_IS_EMPTY = 0;
    private static final int NAME_IS_ONE = 1;

    public List<String> inputCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = new ArrayList<>();
        String input = readLine();
        for (String name: input.split(",")) {
            carNames.add(name);
        }
        checkException(carNames);
        return carNames;
    }
    public void checkException(List<String> carNames) {
        checkEmpty(carNames);
        checkNameLength(carNames);
        checkDuplication(carNames);
        checkNameIsOne(carNames);
    }
    public void checkNameLength(List<String> carNames) {
        for (int i = 0; i < carNames.size(); i++) {
            String name = carNames.get(i);
            if (name.length() > MAX_NAME_LENGTH || name.length() < MIN_NAME_LENGTH) {
                throw new IllegalArgumentException();
            }
        }
    }
    public void checkEmpty(List<String> carNames) {
        if (carNames.size() == NAME_IS_EMPTY) {
            throw new IllegalArgumentException();
        }
    }
    public void checkDuplication(List<String> carNames) {
        if (carNames.stream().distinct().count() != carNames.size()) {
            throw new IllegalArgumentException();
        }
    }
    public void checkNameIsOne(List<String> carNames) {
        if (carNames.size() == NAME_IS_ONE) {
            throw new IllegalArgumentException();
        }
    }
}
