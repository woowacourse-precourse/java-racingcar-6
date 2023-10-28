package racingcar.View;

import racingcar.Model.Car;

import java.util.*;

public class OutputView {
    public void outputResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(carResult(car));
        }
        System.out.println("");
    }

    public void outputWinner(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }

    public String carResult(Car car) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < car.getLocation(); i++) {
            sb.append("-");
        }
        return car.getName() + " : " + sb;
    }


}
