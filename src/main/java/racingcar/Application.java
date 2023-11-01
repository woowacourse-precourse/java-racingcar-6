package racingcar;

import racingcar.domain.Racing;
import racingcar.domain.Register;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Register register = new Register();
        List<String> cars = register.registerCar();

        int raceCount = register.registerRaceCount();

        System.out.println("실행 결과");
        Racing racing = new Racing(cars, raceCount);
        racing.racingProcess();
    }
}
