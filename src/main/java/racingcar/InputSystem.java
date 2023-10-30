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
        String[] names = input.split(SEPARATOR);

        for (String name : names) {
            if (!isNotValidNames(name, cars)) {
                cars.add(new Car(name));
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public int inputTryCNT() {
        String input = answer(INPUT_CNT_MESSAGE);
        if (!isNotNumber(input)) {
            return Integer.parseInt(input);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private String answer(String str) {
        System.out.println(str);
        return Console.readLine();
    }

    private boolean isNotValidNames(String name, List<Car> cars) {
        return  isEmptyName(name)
                || isBiggerThanMax(name)
                || isDuplicatedName(name, cars);
    }

    private boolean isEmptyName(String name) {
        return name == null || GAP.equals(name);
    }

    private boolean isDuplicatedName(String name, List<Car> cars) {
        for (Car car : cars) {
            if (name.equals(car.getName())) {
                return true;
            } else {
                continue;
            }
        }
        return false;
    }

    private boolean isBiggerThanMax(String name) {
        return name.length() > MAX_LENGTH;
    }

    private boolean isNotNumber(String str) {
        Pattern pattern = Pattern.compile("^[0-9]*$");
        return pattern.matcher(str).matches();
    }

}
