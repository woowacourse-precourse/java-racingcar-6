package racingcar;

import camp.nextstep.edu.missionutils.Console;
public class Input {
    String Cars;
    int NumberOfAttempt;
    public void inputCars(){
        Cars = Console.readLine();
    }

    public void inputNumberOfAttempt(){
        NumberOfAttempt = Integer.parseInt(Console.readLine());
    }
}
