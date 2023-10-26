package racingcar;

import racingcar.view.AttemptInput;
import racingcar.view.NamesInput;
import racingcar.view.Output;

public class RaceManager {

    private static final String ASK_NAME_OF_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)  ";
    private static final String ASK_Attempt_TIMES = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";

    private final RaceCars carList;
    private final AttemptNumber attemptNumber;

    public RaceManager() {
        this.carList = makeList();
        this.attemptNumber = getAttemptNumber();
    }

    private RaceCars makeList() {
        Output.printMessage(ASK_NAME_OF_CARS);
        NamesInput namesInput = new NamesInput();
        return new RaceCars(namesInput.readLine());
    }

    private AttemptNumber getAttemptNumber() {
        Output.printMessage(ASK_Attempt_TIMES);
        AttemptInput attemptInput = new AttemptInput();
        return attemptInput.readLine();
    }

    public void startRace() {
        Output.printMessage(RESULT_MESSAGE);

        for (int i = 0; i < attemptNumber.number(); i++) {
            carList.moveForwardEach();
            carList.printAllCar();
        }

        printWinner();
    }

    private void printWinner() {
        StringBuilder builder = new StringBuilder();
        for (RaceCar car : carList.getMaximumList()) {
            builder.append(car).append(", ");
        }

        Output.printMessage(FINAL_WINNER_MESSAGE + builder);
    }

    @Override
    public String toString() {
        return carList.toString();
    }
}
