package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Race {
    private Map<String, Integer> cars;
    private List<String> names;
    private int count;

    private void mapCarNames(){
        cars = new HashMap<>();
        for(String name: names){
            cars.put(name, 0);
        }
    }

    private void getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        names = List.of(input.split(","));
        mapCarNames();
    }

    private void getNumberOfAttempts(){
        System.out.println("시도할 회수는 몇회인가요?");
        count = Integer.parseInt(Console.readLine());
    }

    public void start(){
        getCarNames();

        getNumberOfAttempts();



   }
}
