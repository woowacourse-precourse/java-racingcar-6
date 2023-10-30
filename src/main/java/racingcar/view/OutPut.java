package racingcar.view;

import java.util.List;
import racingcar.repository.SaveCarRaceResults;

public class OutPut {

    private static final String ENTER_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ENTER_TRY_TIMES = "시도할 회수는 몇회인가요?";
    private static final String EXECUTION_RESULTS = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자 : ";

    private final Input input;
    private final SaveCarRaceResults saveCarRaceResults;


    public OutPut(Input input, SaveCarRaceResults saveCarRaceResults) {
        this.input = input;
        this.saveCarRaceResults = saveCarRaceResults;
    }

    public void racingGuide() {

        System.out.println(ENTER_CAR_NAME);
        List<String> carNames = input.carName();

        System.out.println(ENTER_TRY_TIMES);
        int numberOfAttempts = input.numberTimesTry();

        System.out.println("\n" + EXECUTION_RESULTS);
        saveCarRaceResults.carMovingDistanceCalculation(carNames, numberOfAttempts);
        System.out.println(FINAL_WINNER);


    }


}



