package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class RacingGame {

    public RacingGame() {
    }

    String[] carName;
    public Car[] cars;
    int carCount;
    int tryNumber;
    int currentMax = 0;
    ArrayList<String> winner = new ArrayList<String>();

    public void init() {
        inputCarName();
        inputTryNum();
    }

    public void inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInputs = Console.readLine();
        carName = carNameInputs.split(",");
        carCount = carName.length;
    }

    public void inputTryNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();

        tryNumber = Integer.parseInt(input);
    }
}