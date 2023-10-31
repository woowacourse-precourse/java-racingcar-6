package racingcar.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    // 입력값으로부터 자동차 이름 파싱
    public List<String> parseCarInput(String input) {
        validateCarInput(splitCar(input));
        return splitCar(input);
    }

    // 입력값으로부터 자동차 이름 분리
    private List<String> splitCar(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    // 입력값 5글자이하인지 검증
    public void checkSize(String input) throws IllegalArgumentException {
        if(input.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    // 입력값 빈값인지 검증
    public void checkEmpty(String input) throws IllegalArgumentException {
        if(input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    // 입력값 자동차 이름 검증
    private void validateCarInput(List<String> cars) {
        for(String car : cars) {
            checkEmpty(car);
            checkSize(car);
        }
    }

    // 입력값으로부터 시행 횟수 파싱
    public int parseTrialInput(String input) {
        validateTrialInput(input);
        return parseInt(input);
    }

    // 입력값 정수로 파싱
    private int parseInt(String input) {
        return Integer.parseInt(input);
    }

    // 입력값 정수인지 검증
    public void checkDigit(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    // 입력값 시행 횟수 검증
    private void validateTrialInput(String input) {
        checkEmpty(input);
        checkDigit(input);
    }
}
