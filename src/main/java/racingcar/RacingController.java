package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class RacingController {

    List<Car> cars = new ArrayList<>();
    int tryCount;
    int highScore = 0;
    List<Car> highestCars = new ArrayList<>();

    public void gameStart() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputName();
        inputTryCount();

        System.out.println("실행 결과");
        resultOutput();
        findWinner();

    }

    public void inputName() {
        List<String> carNames = List.of(Console.readLine().split(","));
        // 자동차 이름 검사 로직
        for (String name : carNames) {
            if (name == null || name.isBlank()) throw new IllegalArgumentException();
            if (name.length() > 5) throw new IllegalArgumentException();
        }
        carNames.forEach(name -> cars.add(new Car(name)));
    }

    public void inputTryCount() {
        // 시도 회수 검사 로직
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            tryCount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (tryCount == 0) throw new IllegalArgumentException();
    }

    public void resultOutput() {
        // 실행 결과 출력 로직
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
    }

    public void findWinner() {
        for (Car car : cars) {
            if (car.getScore() > highScore) {
                highScore = car.getScore();
                highestCars.clear();
                highestCars.add(car);
            } else if (car.getScore() == highScore) {
                highestCars.add(car);
            }
        }
        // 다수의 우승자일 경우 , 추가 로직
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < highestCars.size(); i++) {
            System.out.print(highestCars.get(i).getName());
            if (i < highestCars.size() - 1) {
                System.out.print(",");
            }
        }
    }

}
