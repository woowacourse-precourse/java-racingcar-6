package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Register {

    public List<String> registerCar(){

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarName = Console.readLine();

        List<String> cars = List.of(inputCarName.split(","));

        for (String car : cars) {
            checkCarName(car);
        }

        System.out.println(cars);
        return cars;
    }

    private void checkCarName(String car){
        if(car.length() > 6){
            throw new IllegalArgumentException();
        }
    }

    public int registerRaceCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}
