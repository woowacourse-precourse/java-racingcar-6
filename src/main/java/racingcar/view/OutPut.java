package racingcar.view;

import java.util.List;
import racingcar.repository.CarRaceResultsSave;
import racingcar.race.Car;
import racingcar.util.FinalWinner;

public class OutPut {

    private static final String ENTER_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ENTER_TRY_TIMES = "시도할 회수는 몇회인가요?";
    private static final String EXECUTION_RESULTS = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자 : ";

    private final CarRaceResultsSave carRaceResultsSave;
    private final Car car;
    private final FinalWinner finalWinner;
    private final Input input;


    public OutPut(CarRaceResultsSave carRaceResultsSave, Car car, FinalWinner finalWinner,
                  Input input) {
        this.carRaceResultsSave = carRaceResultsSave;
        this.car = car;
        this.finalWinner = finalWinner;
        this.input = input;
    }

    public void racingGuide() {

        System.out.println(ENTER_CAR_NAME);
        List<String> carNames = input.carName();

        System.out.println(ENTER_TRY_TIMES);
        int numberOfAttempts = input.numberTimesTry();

        System.out.println("\n" + EXECUTION_RESULTS);
        carRaceResultsSave.carMovingDistanceCalculation(carNames, numberOfAttempts);

        System.out.printf(FINAL_WINNER);
        finalWinner.carsDistanceComparison(car.getCarsDistanceData(),numberOfAttempts);

    }

}



