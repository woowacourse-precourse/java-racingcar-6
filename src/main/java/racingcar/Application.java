package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

class Car{
    private String name;
    private String distance;

    Car(String name, String distance){
        this.name = name;
        this.distance = distance;
    }

    String getName(){
        return this.name;
    }

    String getDistance(){
        return this.distance;
    }

}

class InsertionNameAndResetDistance{
    public static void resetNameAndDistance(ArrayList<Car> carList, String [] carNameList){
        int i;
        for(i = 0; i < carNameList.length; i++){
            carList.add(new Car(carNameList[i], ""));
        }
    }
}

class RacingCar{
    public static void start() {
        ArrayList<Car> carList = new ArrayList<Car>();

        String[] carNameList = Console.readLine().split(",");

        InsertionNameAndResetDistance.resetNameAndDistance(carList, carNameList);

        int i;
        for(i = 0; i < carList.size(); i++)
            System.out.println(carList.get(i).getName());
    }
}

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCar.start();
        int trying = Integer.parseInt(Console.readLine());
    }
}
