package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String inputName = Console.readLine();
        Car car = new Car(inputName);
        System.out.println(car);

    }
}
