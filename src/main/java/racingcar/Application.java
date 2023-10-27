package racingcar;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] input = Console.readLine().split(",");
        ArrayList<Car> carList = new ArrayList<>();
        for(String name : input) {
            carList.add(new Car(name, 0));
        }
    }
}
