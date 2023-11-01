package racingcar.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import java.util.Stack;

public class Race {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NUMBER_OF_ROUND_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private final Cars cars;
    private final int numberOfRound;
    private Race() {
        this.cars = Cars.create(getCarNameInput());
        this.numberOfRound = getNumberOfRoundInput();
    }

    public static Race create() {
        return new Race();
    }

    public void start() {
        roundsStart();
        Stack<Car> winners = pickWinners(cars.getCars());
        printWinners(winners);
    }

    private static String getCarNameInput() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        return readLine();
    }

    private static int getNumberOfRoundInput() {
        System.out.println(NUMBER_OF_ROUND_INPUT_MESSAGE);
        String numberOfRoundString = readLine();
        for (int i = 0; i < numberOfRoundString.length(); ++i) {
            char ch = numberOfRoundString.charAt(i);
            if (ch < '0' || ch > '9') {
                throw new IllegalArgumentException();
            }
        }
        return Integer.parseInt(numberOfRoundString);
    }

    private void roundsStart() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < numberOfRound; ++i) {
            for (Car car: cars.getCars()) {
                car.tryMove();
                System.out.println(car.getCarInfo());
            }
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
        System.out.print("최종 우승자 : ");
        System.out.print(cars.get(0).getName());
        for (int i = 1; i < cars.size(); ++i) {
            System.out.print(", " + cars.get(i).getName());
        }
    }
}
