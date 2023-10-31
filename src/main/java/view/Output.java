package view;

import java.util.List;
import model.Car;

public class Output {

    public static void roundResult(List<Car> carList){

        for(Car car : carList){
            System.out.print(car.getName() + " : ");

            for(int i = 0; i < car.getGo(); i++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();

    }

}
