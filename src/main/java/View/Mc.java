package View;

import Model.Car;

import java.util.ArrayList;
import java.util.List;

public class Mc {

    public void showResult(List<Car> carList) {
        for(Car car: carList) {
            System.out.println(car.getName() + ":" + car.getPosition());
        }
        System.out.println();
    }

    public void showChampion(List<Car> winners) {
        if (winners.size() == 1) {
            System.out.print("최종 우승자 : " + winners.get(0).getName());
        } else {
            System.out.print("최종 우승자 : ");
            for (int i = 0; i < winners.size(); i++) {
                System.out.print(winners.get(i).getName());
                if (i < winners.size() - 1) {
                    System.out.print(", ");
                }
            }
        }
    }
}
