package race;

import java.util.List;
import view.Input;

public class Run {

    private static final String ENTER_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_TIMES = "시도할 회수는 몇회인가요?";
    private static final String EXECUTION_RESULTS = "실행 결과";

    Input input;
    Race race;

    public Run(Input input, Race race) {
        this.input = input;
        this.race = race;
        start();
    }

    public void start() {

        System.out.println(ENTER_CAR_NAME);
        List<String> carNames = input.carName();

        System.out.println(TRY_TIMES);
        int numberOfAttempts = input.numberTry();

        System.out.println(EXECUTION_RESULTS);
        race.result(carNames, numberOfAttempts);

    }


}
