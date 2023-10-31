package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.utils.GameUtil;

public class Game {

    private List<Car> cars = new ArrayList<>();
    private List<Car> winners;
    private int totalTrialCount;
    private int curTrialCount = 0;

    private final GameUtil gameUtil = new GameUtil();

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public void generateCarsByCarNames(String carNames) {
        List<String> carNamesList = gameUtil.splitNamesByComma(carNames);

        for (String carName : carNamesList) {
            Car newCar = new Car(carName);
            cars.add(newCar);
        }
    }

    public void inputTrialCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String trialCountString = Console.readLine();
        totalTrialCount = Integer.parseInt(trialCountString);
    }

    public void judgeWinner() {

    }

    public void printWinner() {

    }

}
