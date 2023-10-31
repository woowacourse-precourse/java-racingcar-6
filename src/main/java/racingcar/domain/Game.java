package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Game {

    private List<Car> cars;
    private List<Car> winners;
    private int totalTrialCount;
    private int curTrialCount = 0;

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public void inputTrialCount() {

    }

    public void judgeWinner() {

    }

    public void printWinner() {

    }

}
