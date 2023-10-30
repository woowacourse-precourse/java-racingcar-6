package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.list;

public class Application {
    public static void main(String[] args) {

        // 경주 할 자동차 이름 입력받기
        String cars = Console.readLine();
        List<String> carArray = List.of(cars.split(","));

        // 입력받은 자동차 이름의 자동차 클래스들 생성하기
        List<Car> carList = new ArrayList<>();

        for (int i=0; i<carArray.size(); i++){
            final Car car = new Car(carArray.get(i));
            carList.add(car);
        }



    }
}
