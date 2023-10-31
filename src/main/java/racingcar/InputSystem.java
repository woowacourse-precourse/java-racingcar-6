package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.regex.Pattern;

public class InputSystem {

    private static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_CNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String SEPARATOR = ",";
    private static final String GAP = "";
    private static final int MAX_LENGTH = 5;

    public InputSystem() {

    }

    public void inputCarName(List<Car> cars) {
        String input = answer(INPUT_NAME_MESSAGE);
        nameValidator(input, cars);
    }

    public int inputTryCNT() {
        String input = answer(INPUT_CNT_MESSAGE);
        cntValidator(input);
        return Integer.parseInt(input);
    }

    public void nameValidator(String input, List<Car> cars) {
        String[] namesArray = input.split(SEPARATOR,-1);
        for(String name : namesArray) {
            if(isNotValidName(name, cars)) {
                throw new IllegalArgumentException();
            } else{
                cars.add(new Car(name));
            }
        }
    }

    public void cntValidator(String input) {
        if(!isNumber(input) || !isUnderMax(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotValidName(String name, List<Car> cars) {
        return isDuplicatedName(name, cars) || isBiggerThanMaxLen(name) || isEmptyName(name);
    }

    private boolean isDuplicatedName(String name, List<Car> cars) {
        for(Car car : cars) {
            if(name.equals(car.getName())) {
                return true;
            }
        }
        return false;
    }

    private boolean isBiggerThanMaxLen(String name) {
        return name.length() > MAX_LENGTH;
    }

    private boolean isEmptyName(String name) {
        return name == null || GAP.equals(name);
    }

    private boolean isNumber(String str) {
        return Pattern.matches("^[0-9]*$",str);
    }

    private boolean isUnderMax(String str) {
        try {
            int value = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private String answer(String str) {
        System.out.println(str);
        return Console.readLine();
    }
}
