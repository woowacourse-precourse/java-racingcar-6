package Service;

import domain.Car;

import java.util.List;

public class RaceState {
    public static void state(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            System.out.print(carList.get(i).getName() + " : ");
            for (int j = 0; j < carList.get(i).getRaceCount(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
