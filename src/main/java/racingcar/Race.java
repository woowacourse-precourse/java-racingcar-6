package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private static final String start_message = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private int raceCount=0;
    private List<String> racer = new ArrayList<>();
    public Race() {
        Car car = new Car();
        car.getRacerName();
    }

}



