package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<String> names;

    public List<Car> mapCarNames(){
        List<Car> cars = new ArrayList<>();
        for(String name: names){
            Car car = new Car(name);
            cars.add(car);
        }
        return cars;
    }

    public List<Car> setCarNames(List<Car> cars){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        names = List.of(input.split(","));
        Validator validator = new Validator();
        validator.validateUserinput(input, names);
        return mapCarNames();
    }
    public int setNumberOfAttempts(){
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }




}
