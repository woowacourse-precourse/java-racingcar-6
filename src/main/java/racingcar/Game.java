package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    List<Car> cars;
    int roundNumber;
    List<Car> winner;

    Game() {
        this.cars = new ArrayList<>();
    }

    void playGame() {
        inputCars();
        inputRoundNumber();
        playRounds();

        getWinners();
        printWinners();
    }

    void inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");

        for (String carName : carNames) {
            if (carName.length() > 5)
                throw new IllegalArgumentException();
            cars.add(new Car(carName));
        }
    }

    void inputRoundNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            this.roundNumber = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    void playRounds() {
        System.out.println("실행 결과");
        Round round = new Round(cars);
        for (int i = 0; i < roundNumber; ++i) {
            round.playRound();
        }
    }

    void getWinners() {
        winner = new ArrayList<>();

        int longestDistance = 0;
        for (Car car : cars) {
            if (car.getMoveDistance() < longestDistance)
                continue;
            if (car.getMoveDistance() > longestDistance) {
                longestDistance = car.getMoveDistance();
                winner.clear();
            }
            winner.add(car);
        }
    }

    void printWinners() {
        System.out.print("최종 우승자 : " + winner.get(0).getName());
        for (int i = 1; i < winner.size(); ++i) {
            System.out.print(", " + winner.get(i).getName());
        }
    }
}
