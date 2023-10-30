package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public String[] inputCarNames() {
        String[] cars = Console.readLine().split(",");
        return cars;
    }

    public int inputNumber() {
        return Integer.parseInt(Console.readLine());
    }
    public static void main(String[] args) {
    }
}
