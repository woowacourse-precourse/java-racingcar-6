package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Service {
    static String[] getCarNamesFromUser(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().split(",");
    }

    static int getTryCountFromUser(){
        System.out.println("시도할 회수는 몇회인가요?");
        try{
            return Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("잘못된 입력입니다. 회수는 숫자로 입력해주세요.");
        }
    }

    static List<Car> createCars(String[] carNames){
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            cars.add(new Car(name));
        }
        return cars;
    }
}
