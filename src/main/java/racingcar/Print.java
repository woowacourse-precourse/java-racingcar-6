package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Print {
    public void status(List<Car> cars){
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getLocation(); i++) {
                System.out.print("-");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public void result(List<Car> cars){
        int maxDistance = 0;
        for (Car car : cars) {
            if (car.getLocation() > maxDistance) {
                maxDistance = car.getLocation();
            }
        }

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getLocation() == maxDistance) {
                winners.add(car.getName());
            }
        }

        System.out.print("최종 우승자 : ");
        System.out.print(String.join(", ", winners));
    }
}