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

class CheckNames{
    public static boolean CheckNamesInCarList(ArrayList<Car> carList){
        int result = 0;

        for(int i = 0; i < carList.size(); i++)
            if (carList.get(i).getName().length() > 5){
                result = 1;
                break;
            }

        if (result == 1)
            return true;
        else
            return false;
    }
}

class RacingCar{
    public static void start() {
        ArrayList<Car> carList = new ArrayList<Car>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNameList = Console.readLine().split(",");
        InsertionNameAndResetDistance.resetNameAndDistance(carList, carNameList);

        System.out.println("시도할 회수는 몇회인가요?");
        int trying = Integer.parseInt(Console.readLine());

        if (CheckNames.CheckNamesInCarList(carList))
            throw new IllegalArgumentException();


    }
}

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCar.start();
    }
}
