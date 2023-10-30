package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        Circuit circuit = new Circuit();
        String input = Console.readLine();
        circuit.makeCarList(input);
        String repeat = Console.readLine();
    }
}
