package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class User {
    public static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String CAR_NAME_ERROR_MESSAGE = "이름이 5자를 초과하는 자동차가 있습니다.";
    private String[] carsNameArray;

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
}