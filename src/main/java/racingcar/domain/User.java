package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class User {
    public static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String ATTEMPTS_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String CAR_NAME_ERROR_MESSAGE = "이름이 5자를 초과하는 자동차가 있습니다.";
    public static final String ATTEMPTS_INT_ERROR_MESSAGE = "입력한 회수가 정수가 아닙니다.";
    public static final String ATTEMPTS_NEGATIVE_ERROR_MESSAGE = "음의 정수를 입력하실 수 없습니다.";
    private String[] carsNameArray;
    private int attempts;

    public void setCarsName() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String carsNameString = Console.readLine();
        splitCarsName(carsNameString);
    }

    public void splitCarsName(String carsNameString) {
        carsNameArray = carsNameString.split(",");
        checkCarNameUnderFive();
    }

    private void checkCarNameUnderFive() {
        for(String carName : carsNameArray) {
            if(carName.length() > 5) {
                throw new IllegalArgumentException(CAR_NAME_ERROR_MESSAGE);
            }
        }
    }

    public String[] getCarsNameArray() {
        return carsNameArray;
    }


    public void setAttempts() {
        System.out.println(ATTEMPTS_INPUT_MESSAGE);
        String input = Console.readLine();
        checkAttempts(input);
    }

    public void checkAttempts(String input) {
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(ATTEMPTS_INT_ERROR_MESSAGE);
        }
        if(Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException(ATTEMPTS_NEGATIVE_ERROR_MESSAGE);
        }
    }

    public int getAttempts() {
        return attempts;
    }
}