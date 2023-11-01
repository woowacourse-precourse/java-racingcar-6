package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputDesk {
    private List<String> cars = new ArrayList<>();
    private int count;
    private final int ERR_NUM = Integer.MIN_VALUE;
    private final int MAX_CAR_NAME_LENGTH = 5;
    private final int MIN_CAR_NAME_LENGTH = 1;

    public List<String> getCars() {
        return cars;
    }

    public int getCount() {
        return count;
    }

    public boolean checkIsNull(String inputStr) {
        if (inputStr == null || inputStr.length() == 0) {
            throw new IllegalArgumentException("사용자 입력값 null");
        }
        return true;
    }

    public boolean checkIsInt(String inputStr) {
        try {
            Integer.parseInt(inputStr);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사용자 입력값 Int형 아님");
        }

    }

    public void checkIllegalArgumentException(String carName) {

        if (carName == null || carName.length() <= MIN_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름 길이 0");
        }

        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름 길이 5 초과");
        }

    }

    public void checkIllegalArgumentException(int inputCount) {
        if (inputCount < 1) {
            throw new IllegalArgumentException("시도할 회수 입력값 0 이하");
        }
    }

    public int validateInputCount(String inputStr) {
        int inputCount = ERR_NUM;

        try {
            if (checkIsNull(inputStr) && checkIsInt(inputStr)) {
                inputCount = Integer.parseInt(inputStr);
                checkIllegalArgumentException(inputCount);
            }
        } catch (IllegalArgumentException e) {
            inputCount = ERR_NUM;
            throw e;
        } finally {
            return inputCount;
        }
    }

    public List inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try {
            String inputStr = Console.readLine();
            checkIsNull(inputStr);
            String[] strArr = inputStr.split(",");

            for (int i = 0; i < strArr.length; i++) {
                checkIllegalArgumentException(strArr[i]);
                cars.add(strArr[i]);
            }
            return cars;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public void inputCounts() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            String inputStr = Console.readLine();
            count = validateInputCount(inputStr);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

}
