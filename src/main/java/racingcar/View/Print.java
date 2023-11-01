package racingcar.View;

import racingcar.Model.Car;

import java.util.ArrayList;
import java.util.List;

public class Print {
    public void inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public void howMuchRepeat() {
        System.out.println("시도할 회수는 몇회인가요?");
    }
    public void runningResult() {
        System.out.println("");
        System.out.println("실행 결과");
    }
    public void step(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getForwardValue(); i++) {
                System.out.print("-");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public void winner(List<Car> winningCars) {
        if (winningCars.size() == 1) {
            singleCarOutput(winningCars);
        } else if (winningCars.size() > 1) {
            multiCarsOutput(winningCars);
        } else {
            throw new IllegalArgumentException();
        }
    }



    public void singleCarOutput(List<Car> winningCars) {
        System.out.println("최종 우승자 : " + winningCars.get(0).getName());
    }
    public void multiCarsOutput(List<Car> winningCars) {
        System.out.print("최종 우승자 : ");
        for (Car car : winningCars) {
            if (car == winningCars.get(winningCars.size() - 1)) {
                System.out.println(car.getName());
            } else {
                System.out.print(car.getName() + ", ");
            }
        }
    }
}
