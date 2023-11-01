package racingcar.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.domain.wrapper.RaceRound;

public class Race {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NUMBER_OF_ROUND_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String ROUND_RESULT_MESSAGE = "\n시도할 회수는 몇회인가요?";

    private final Cars cars;
    private final RaceRound numberOfRound;

    private Race() {
        this.cars = Cars.create(getCarNameInput());
        this.numberOfRound = RaceRound.create(getNumberOfRoundInput());
    }

    public static Race create() {
        return new Race();
    }

    private static String getCarNameInput() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        return readLine();
    }

    private static String getNumberOfRoundInput() {
        System.out.println(NUMBER_OF_ROUND_INPUT_MESSAGE);
        return readLine();
    }

    public void start() {
        System.out.println(ROUND_RESULT_MESSAGE);
        for (int i = 0; i < numberOfRound.getNumberOfRound(); ++i) {
            roundStart();
            Referee.announceRoundResult(cars.getCars());
        }
        Referee.announceWinners(cars.getCars());
    }

    private void roundStart() {
        for (Car car : cars.getCars()) {
            car.tryMove();
        }
    }
}
