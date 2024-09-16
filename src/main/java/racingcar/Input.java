package racingcar;

import static racingcar.MESSAGE.INPUT_CARS;
import static racingcar.MESSAGE.INPUT_TRYS;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private String[] cars;
    private int trys;


    public String[] getCars() {
        System.out.println(INPUT_CARS.getMessage());
        String inputNames = Console.readLine();
        String[] carNames = inputNames.split(",");
        return carNames;
    }

    public int getTrys() {
        System.out.println(INPUT_TRYS.getMessage());
        int tryCount = Integer.parseInt(Console.readLine());
        return tryCount;
    }

}
