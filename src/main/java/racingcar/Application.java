package racingcar;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String readLine = readLine();
        List<String> list = Arrays.asList(readLine.split(","));
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            cars.add(new Car(name));
        }

        System.out.println(cars);
    }
}
