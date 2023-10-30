package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

public class Car {
    public static String selectCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.");
        String cars = Console.readLine();
        return cars;
    }


}