package racingcar.domain.car;

import racingcar.constant.ConstantNumber;
import racingcar.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    List<Car> carList = new ArrayList<>();

    // 자동차 이름 검사 후 추가하기
    public void add(String carName) throws IllegalArgumentException {
        carNameValidation(carName);
        carList.add(new Car(carName));
    }

    // 자동차 이름 검증하기
    public void carNameValidation(String carName) throws IllegalArgumentException {
        isNull(carName);
        isOverSizeCarName(carName);
    }

    // 자동차 이름이 널값인지 확인하기
    public static void isNull(String carName) throws IllegalArgumentException {
        if (carName.isEmpty()){
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_NULL_ERROR.print());
        }
    }

    // 자동차 이름이 5자 이하인지 확인하기
    public static void isOverSizeCarName(String carName) throws IllegalArgumentException {
        if (carName.length() > ConstantNumber.CAR_NAME_MAX_SIZE.value()){
            throw new IllegalArgumentException(ErrorMessage.CRA_NAME_OVER_SIZE_ERROR.print());
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
}
