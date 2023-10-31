package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class RacingController {

    List<Car> cars = new ArrayList<>();
    int tryCount;

    public void gameStart() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        List<String> carNames = List.of(Console.readLine().split(","));
        carNames.forEach(name -> cars.add(new Car(name)));

        // 자동차 이름 검사 로직
        for (String name : carNames) {
            if (name == null || name.isBlank()) throw new IllegalArgumentException();
            if (name.length() > 5) throw new IllegalArgumentException();
        }

        // 시도 회수 검사 로직
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            tryCount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (tryCount == 0) throw new IllegalArgumentException();

        System.out.println("실행 결과");

        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.move();
                System.out.print(car.getName() + " : ");
                for (int n = 0; n < car.getScore(); n++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }

        List<Car> highestCars = new ArrayList<>();
        int highScore = 0;

        for (Car car : cars) {
            if (car.getScore() > highScore) {
                highScore = car.getScore();
                highestCars.clear();
                highestCars.add(car);
            } else if(car.getScore() == highScore){
                highestCars.add(car);
            }
        }

        System.out.print("최종 우승자 : ");
        for (Car car : highestCars) {
            System.out.print(car.getName());
        }
    }


}
