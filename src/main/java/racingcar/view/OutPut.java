package racingcar.view;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import racingcar.util.CarRacingStarts;

public class OutPut {

    private static final String ENTER_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ENTER_TRY_TIMES = "시도할 회수는 몇회인가요?";
    private static final String EXECUTION_RESULTS = "실행 결과";

    private final CarRacingStarts carRacingStarts;
    private final Input input;


    public OutPut(CarRacingStarts carRacingStarts, Input input) {
        this.carRacingStarts = carRacingStarts;
        this.input = input;
    }

    public void racingGuide() {

        System.out.println(ENTER_CAR_NAME);
        List<String> carNames = input.carName();

        System.out.println(ENTER_TRY_TIMES);
        int numberOfAttempts = input.numberTimesTry();

        System.out.println(EXECUTION_RESULTS);
        result(carNames, numberOfAttempts);
    }

    public void result(List<String> carNames, int tryTimes) {

        while (tryTimes > 0) {
            carRacingStarts.creation(carNames);
            carDistanceCheck();
            System.out.println();
            tryTimes--;
        }

    }

    public void carDistanceCheck() {
        for (Entry<String, String> map : getCarMoveCheck().entrySet()) {
            System.out.printf("%s : %s\n", map.getKey(), map.getValue());
        }
    }

    private Map<String, String> getCarMoveCheck() {
        return carRacingStarts.getCarMoveCheck();
    }

}



