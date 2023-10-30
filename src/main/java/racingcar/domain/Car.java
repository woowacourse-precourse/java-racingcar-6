package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exeption.CustomizedException;

import java.util.ArrayList;
import java.util.List;

public class Car {
    public static String selectCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.");
        String cars = Console.readLine();
        return cars;
    }
    public static List<String> makeRacingCarList() {
        String cars = selectCars();
        List<String> carList =new ArrayList<>();
        String[] carArray = cars.split(",");
        for(int i = 0 ; i< carArray.length;i++){
            carList.add(carArray[i]);
        }
        System.out.println(carList);
        CustomizedException.numberUpException(carList);
        return carList;
    }

}