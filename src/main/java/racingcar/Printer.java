package racingcar;

import java.util.List;

public class Printer {
    public void printCurrent(List<Car>carList){
        for(Car car : carList){
            System.out.print(car.getName() + " : ");
            printMovedDistance(car);
            System.out.println();
        }
    }
    private void printMovedDistance(Car car){
        for(int i=0;i<car.getLocation();i++){
            System.out.print("-");
        }
    }
}
