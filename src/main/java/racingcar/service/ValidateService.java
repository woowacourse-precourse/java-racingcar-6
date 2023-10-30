package racingcar.service;

public class ValidateService {
    public ValidateService(){}

    public static void isEmpty(final String carName){ //아무것도 입력안했을 경우
        if(carName.isEmpty())throw new IllegalArgumentException();
    }


    public static void isValidLength(final String carName){ //자동차 이름이 1이상 5이하가 아닐 경우
        int carNameLength = carName.length();
        if(carNameLength <= 0 || carNameLength > 5)
            throw new IllegalArgumentException();
    }
}
