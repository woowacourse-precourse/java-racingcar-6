package racingcar.View;

import racingcar.Model.Car;

import java.util.*;

public class OutputView {
    public void outputResult(List<Car> cars) {
        for (Car car : cars) {
            printCarResult(car);
        }
        System.out.println("");
    }

    public void outputWinner(List<Car> cars) {
        Collections.sort(cars, ((o1, o2) -> o1.getLocation() - o2.getLocation()));
        int maxNum = cars.get(cars.size() - 1).getLocation();
        List<String> members = new ArrayList<>();
        for (Car car : cars) {
            if (car.getLocation() == maxNum) {
                members.add(car.getName());
            }
        }
        String winner = String.join(",", members);
        System.out.println("최종 우승자 : " + winner);
    }

    private void printCarResult(Car car) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < car.getLocation(); i++) {
            sb.append("-");
        }
        System.out.println(car.getName() + " : " + sb);
    }


}
