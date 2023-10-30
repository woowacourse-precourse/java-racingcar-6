package racingcar;

import racingcar.model.Car;
import java.util.ArrayList;
import java.util.List;
import static camp.nextstep.edu.missionutils.Console.readLine;

class Game {
    private List<Car> cars = new ArrayList<>();
    private int numberOfAttempts;

    public Game(String carNames, int numberOfAttempts) {
        initializeCars(carNames);
        this.numberOfAttempts = numberOfAttempts;
    }

    private void initializeCars(String carNames) {
        String[] names = carNames.split(",");
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }
    }

    public void startGame() {
        System.out.println("실행 결과");
        for (int attempt = 0; attempt < numberOfAttempts; attempt++) {
            for (Car car : cars) {
                car.move();
                car.currentLocation();
            }
            System.out.println();
        }
    }

    public void printWinners() {
        int maxForwardCount = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getForwardCount() > maxForwardCount) {
                maxForwardCount = car.getForwardCount();
                winners.clear();
                winners.add(car.getName());
            } else if (car.getForwardCount() == maxForwardCount) {
                winners.add(car.getName());
            }
        }

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = readLine();

        System.out.println("시도할 회수는 몇회인가요?");
        int numberOfAttempts = Integer.parseInt(readLine());

        System.out.println();
        Game racingGame = new Game(carNames, numberOfAttempts);
        racingGame.startGame();
        racingGame.printWinners();

    }
}
