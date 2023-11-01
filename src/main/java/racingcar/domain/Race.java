package racingcar.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import java.util.Stack;
import racingcar.domain.wrapper.RaceRound;

public class Race {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NUMBER_OF_ROUND_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String ROUND_RESULT_MESSAGE = "\n시도할 회수는 몇회인가요?";
    private static final String RACE_RESULT_MESSAGE = "최종 우승자 : ";

    private final Cars cars;
    private final RaceRound numberOfRound;
    private Race() {
        this.cars = Cars.create(getCarNameInput());
        this.numberOfRound = RaceRound.create(getNumberOfRoundInput());
    }

    public static Race create() {
        return new Race();
    }

    public void start() {
        System.out.println(ROUND_RESULT_MESSAGE);
        for (int i = 0; i < numberOfRound.getNumberOfRound(); ++i) {
            roundStart();
        }
        Stack<Car> winners = pickWinners(cars.getCars());
        printWinners(winners);
    }

    private static String getCarNameInput() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        return readLine();
    }

    private static String getNumberOfRoundInput() {
        System.out.println(NUMBER_OF_ROUND_INPUT_MESSAGE);
        return readLine();
    }

    private void roundStart() {
        for (Car car: cars.getCars()) {
            car.tryMove();
            System.out.println(car.getCarInfo());
        }
    }

    private Stack<Car> pickWinners(List<Car> cars) {
        Stack<Car> winners = new Stack<>();
        for (Car car: cars) {
            while (!winners.empty() && winners.peek().getMovedDistance() < car.getMovedDistance()) {
                winners.pop();
            }
            if (winners.empty() || winners.peek().getMovedDistance() == car.getMovedDistance()) {
                winners.push(car);
            }
        }
        return winners;
    }

    private void printWinners(Stack<Car> cars) {
        System.out.print(RACE_RESULT_MESSAGE);
        System.out.print(cars.get(0).getName());
        for (int i = 1; i < cars.size(); ++i) {
            System.out.print(", " + cars.get(i).getName());
        }
    }
}
