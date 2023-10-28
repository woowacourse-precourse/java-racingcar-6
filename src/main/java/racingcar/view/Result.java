package racingcar.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import racingcar.model.Car;

public class Result {
    public void printResult(List<Car> carList){
        for(int i = 0; i < carList.size(); i++){
            Car car = carList.get(i);
            System.out.print(car.getCarName());
            System.out.print(" : ");
            printDistance(car.getDistance());
            System.out.println();
        }
        System.out.println();
    }

    public void printDistance(int distance){
        for(int i = 0; i < distance; i++){
            System.out.print("-");
        }
    }

    public void printWinner(List<Car> carList){
        getSortCarList(carList);
        System.out.print("최종 우승자 : ");
        int maxDistance = carList.get(0).getDistance();
        System.out.println(carList.get(0).getCarName());
        for(int i = 1; i < carList.size(); i++){
            if(maxDistance == carList.get(i).getDistance()){
                System.out.println(", ");
                System.out.println(carList.get(i).getCarName());
            }else{
                break;
            }
        }
    }

    public void getSortCarList(List<Car> carList){
        Collections.sort(carList, new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return Integer.compare(car2.getDistance(), car1.getDistance());
            }
        });
    }
}
