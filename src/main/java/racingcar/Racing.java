package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Racing {
    // Class instance
    Car car;
    Output output;

    // Constructor
    public Racing() {
        car = new Car();
        output = new Output();
    }

    //method
    public void start() {
        getUserCarNameByConsole();
    }

    public void getUserCarNameByConsole() {
        String consoleInput = Console.readLine();
        car.insertUserName(consoleInput);
    }

}
