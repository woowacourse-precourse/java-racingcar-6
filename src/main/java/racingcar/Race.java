package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Race {
    private List<Car> cars;

    public void play() {
        cars = getCars();
        int attempt = getAttemptNumber();

    }


    private int getAttemptNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        isValidateInput(input);
        return Integer.parseInt(input);
    }

    private void isValidateInput(String input) {
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c < '0' || c > '9') {
                throw new IllegalArgumentException();
            }
        }
    }


    private List<Car> getCars() {
        return Car.getNames();
    }

}
