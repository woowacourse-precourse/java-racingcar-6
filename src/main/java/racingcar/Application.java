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
}
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ArrayList<Car> carList = new ArrayList<Car>();

        String [] carNameList = Console.readLine().split(",");

    }
}
