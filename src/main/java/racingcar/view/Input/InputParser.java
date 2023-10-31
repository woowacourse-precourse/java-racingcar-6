package racingcar.view.Input;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.domain.Car;
import racingcar.domain.Cars;

/* readLine() String > Car 객체
*  1. String , 기준으로 쪼개기
*  2. 하나하나를 자료구조에 담기
*  3. 각각을 Car 객체로 만들기
*  4. 예외 case
*     - , 가 연속해서 있을 경우
*     - , 사이에 공백이 있을 경우
*     - 중복된 자동차가 있을 경우: Car에서 하고 있긴 함*/
public class InputParser {
    public static List<Car> convertCarList(String cars) {
        return Stream.of(cars.split(",+"))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public int parseTrialNumber(String number) {
        return Integer.parseInt(number);
    }
}



