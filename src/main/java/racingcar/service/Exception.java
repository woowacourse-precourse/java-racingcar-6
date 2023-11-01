package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.CarList;

import java.util.ArrayList;
import java.util.List;

public class Exception {

    //자동차이름 5글자 이하 아닐 때
    public void carNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름의 길이는 5글자 이하만 가능합니다.");
        }
    }

    //자동차이름 숫자일때
    public void carNameIsDigit(String carName) {
        if (carName.matches("\\d+")) {
            throw new IllegalArgumentException("자동차 이름은 숫자로 구성될 수 없습니다.");
        }
    }

    public void noInputCarNameException(String carName) {
        if (carName.isEmpty() == true) {
            throw new IllegalArgumentException("자동차 이름을 입력바랍니다.");

        }
    }

    public void noInputTryNumberException(String tryNumber) {
        if (tryNumber.isEmpty() == true) {
            throw new IllegalArgumentException("시도횟수을 입력바랍니다.");

        }
    }

    public void duplicateCarNameException(String inputCars) {
        List<String> carNames = new ArrayList<>();
        for (String carName : inputCars.split(",")) {
            if (carNames.contains(carName)) {
                throw new IllegalArgumentException("자동차 이름이 중복됐습니다.");
            }
            carNames.add(carName);
        }
    }



    public void noDigitTryNumberException(String tryNumber) {
        for (char c : tryNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("시도횟수로 숫자를 입력해주세요.");
            }
        }
    }
}
