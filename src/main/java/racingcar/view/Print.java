package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class Print {

    public void message(String message) {
        System.out.println(message);
    }

    public void result(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            System.out.print(car.getName() + " : ");
            for (int j = 0; j < car.getPosition(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

}
