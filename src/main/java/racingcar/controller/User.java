package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.utility.Constants.COMMA;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.CarStorage;

public class User {
    public User() {}
    public void inputCarNames() throws IllegalArgumentException {
        String carNames = readLine();
        String[] splitCars = carNames.split(COMMA);

        for (String car: splitCars) {
            car = car.replace(" ", "");

            InputException.checkExistCar(car); // 이미 존재하는 차 이름인지 확인
            InputException.checkNameLength(car); // 이름의 길이가 5 이하인지 확인
            InputException.checkOnlyInt(car); // 이름이 정수로만 되어있지 않은지 확인

            CarStorage.addCar(new Car(car));
        }
    }
    public Integer inputTryCount() {
        Integer tryCount = Integer.parseInt(readLine());
        return tryCount;
    }
    public Integer pickRandomInt() {
        Integer random = Randoms.pickNumberInRange(0,9);
        return random;
    }
}
