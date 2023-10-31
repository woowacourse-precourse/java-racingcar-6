package racingcar.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.domain.Car;

public class ValidateService {
    public ValidateService(){}

    public static void isEmpty(final String carName){ //아무것도 입력안했을 경우
        if(carName.isEmpty())throw new IllegalArgumentException();
    }

    public static void hasBlank(final String carName){
        if(carName.contains(" "))throw new IllegalArgumentException();
    }


    public static void isValidLength(final String carName){ //자동차 이름이 1이상 5이하가 아닐 경우
        int carNameLength = carName.length();
        if(carNameLength <= 0 || carNameLength > 5)
            throw new IllegalArgumentException();
    }

    public static void isDuplicateName(Set<String>carNames, final String carName){ //중복된 이름이 있는지 확인
        if(carNames.contains(carName))
            throw new IllegalArgumentException();
        carNames.add(carName);
    }

    public static void isNumber(final String count){ //숫자 아닌 경우 예외 발생
        if(count.matches("^[1-9]\\d*$") == false)
            throw new IllegalArgumentException();
    }
}
