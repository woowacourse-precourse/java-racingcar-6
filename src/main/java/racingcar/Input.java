package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private String cars;
    private int trys;

    public Input(String cars, int trys) {
        this.cars = cars;
        this.trys = trys;
    }

    public String getCars() {
        cars = Console.readLine();
        return cars;
    }

    public int getTrys() {
        trys = Integer.parseInt(Console.readLine());
        return trys;
    }


}

