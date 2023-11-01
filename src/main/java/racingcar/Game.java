package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public void run(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");
        List<Car> cars = validateCarName(names);
        System.out.println("시도할 회수는 몇회인가요?");
        String tryCnt = Console.readLine();

    }

    private List<Car> validateCarName(String[] names){
        List<Car> cars = new ArrayList<>();
        for(String name: names){
            if(name.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            Car car = new Car(name);
            cars.add(car);
        }
        return cars;
    }

}
