package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Racing;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.list;

public class Application {
    public static void main(String[] args) {

        // 경주 할 자동차 이름 입력받기
        final String cars = Console.readLine();
        final List<String> carArray = List.of(cars.split(","));

        // 입력받은 자동차 이름의 자동차 클래스들 생성하기
        final List<Car> carList = new ArrayList<>();

        for (int i=0; i<carArray.size(); i++){
            final Car car = new Car(carArray.get(i));
            carList.add(car);
        }

        // 자동차 경주 게임 객체 생성해 자동차 리스트 저장하기
        final Racing racingGame = new Racing(carList);

    }
}
