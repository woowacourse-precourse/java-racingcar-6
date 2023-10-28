package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class GameMachine {

    public GameMachine() {

    }

    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)");
        String inputCarName = Console.readLine();

        Cars cars = new Cars(createCar(inputCarName));

        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());

        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            cars.move();
            System.out.println(cars.statusMessage());
            System.out.println();
        }

        System.out.printf("최종 우승자 : %s", cars.winnerCars());
    }

    // 자동차 이름 부여해서 객체 생성
    public List<Car> createCar(String inputCarName) {
        List<Car> carList = new ArrayList<>();
        String[] nameSplit = inputCarName.split(",");

        for (String name : nameSplit) {
            Car car = new Car(name);
            carList.add(car);
        }

        return carList;
    }

}
