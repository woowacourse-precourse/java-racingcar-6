package racingcar.util;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class Parser {


    public List<String> parseCarName(String input) {

        /* 양 끝에 공백이 있는 경우에는 사용자의 실수라고 생각하여 공백을 없애고 입력한다. */

        List<String> list = new ArrayList<>();
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            if (carName.length() < 1 || carName.length() > 5) {
                throw new IllegalArgumentException("적합하지 않은 차 이름입니다:  " + carName);
            }
            list.add(carName.trim());
        }

        return list;
    }


    public int parseAttempt(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("해당 시도 횟수는 숫자로 변환될 수 없는 입력값입니다: " + input);
        }

    }

    public List<Car> parseStringToCar(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }


}
