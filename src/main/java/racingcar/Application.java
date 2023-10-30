package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public String[] inputCarNames() {
        String[] cars = Console.readLine().split(",");
        return cars;
    }
    public static void main(String[] args) {
    }
}
