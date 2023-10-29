package racingcar;

import racingcar.domain.Register;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Register register = new Register();
        List<String> cars = register.registerCar();

        int raceCount = register.registerRaceCount();
        System.out.println(raceCount);
    }
}
