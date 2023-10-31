package racingcar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputData {

    private enum Message {
        INPUT_CAR("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        INPUT_TIME("시도할 횟수는 몇회인가요?"),
        EXCEPTION_CAR_NAME("1~5 길이의 영어로 된 이름을 ,로 구분하여 중복과 공백없이 입력 해 주세요."),
        EXCEPTION_EXECUTION_TIME("양의 정수를 입력 해 주세요"),
        EXCEPTION_INPUT_JUST_ONE("2개 이상 자동차를 입력해 주세요."),
        COMMA(",");

        private final String message;

        Message(String message) {
            this.message = message;
        }

    }

    private final String CAR_REGEX = "^[a-zA-Z]${1,5}";

    private ArrayList<String> car = new ArrayList<>();
    private int executionTime;

    public void inputCarName() {
        System.out.println(Message.INPUT_CAR.message);
        String carName = Console.readLine();
        containComma(carName);
        splitToArray(carName);
        validateCarName(car);
    }

    private void containComma(String carName) {
        if (!carName.contains(Message.COMMA.message)) {
            throw new IllegalArgumentException(Message.EXCEPTION_INPUT_JUST_ONE.message);
        }
    }

    private void splitToArray(String carName) {
        String[] splitCar = carName.split(Message.COMMA.message);
        car.addAll(List.of(splitCar));
    }

    private void validateCarName(ArrayList<String> car) {
        validateDuplication(car);
        for (String eachCar : car) {
            validateRegex(eachCar);
        }
    }

    private void validateDuplication(ArrayList<String> car) {
        HashSet<String> carSet = new HashSet<>(car);
        if (car.size() != carSet.size()) {
            throw new IllegalArgumentException(Message.EXCEPTION_CAR_NAME.message);
        }
    }

    private void validateRegex(String car) {
        if (!car.matches(CAR_REGEX)) {
            throw new IllegalArgumentException(Message.EXCEPTION_CAR_NAME.message);
        }
    }

    public void inputExecutionTime() {
        System.out.println(Message.INPUT_TIME.message);

        try {
            executionTime = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(Message.EXCEPTION_EXECUTION_TIME.message);
        }

        validateExecutionTime(executionTime);

    }

    private void validateExecutionTime(int executionTime) {
        if (!(executionTime > 0)) {
            throw new IllegalArgumentException(Message.EXCEPTION_EXECUTION_TIME.message);
        }
    }

    ArrayList<String> returnCarName() {
        return car;
    }

    int returnExecutionTime() {
        return executionTime;
    }

}
