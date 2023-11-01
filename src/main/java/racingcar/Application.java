package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");

        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());

        // 자동차 생성 및 게임 진행
        RacingGame racingGame = new RacingGame(carNames);
        racingGame.playGame(tryCount);

        // 결과 출력
        System.out.println("실행 결과");
        racingGame.printGameResult();
        System.out.println("최종 우승자 : " + racingGame.getWinners());
    }
}

class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}

class RacingGame {
    private final Car[] cars;
    private final StringBuilder gameResult;

    public RacingGame(String[] carNames) {
        cars = new Car[carNames.length];
        gameResult = new StringBuilder();

        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
    }

    public void playGame(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.move();
            }
            printRoundResult();
        }
    }

    public void printRoundResult() {
        for (Car car : cars) {
            gameResult.append(car.getName()).append(" : ").append("-".repeat(car.getPosition())).append("\n");
        }
        gameResult.append("\n");
    }

    public void printGameResult() {
        System.out.println(gameResult.toString());
    }

    public String getWinners() {
        int maxPosition = getMaxPosition();
        StringBuilder winners = new StringBuilder();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                if (winners.length() > 0) {
                    winners.append(", ");
                }
                winners.append(car.getName());
            }
        }

        return winners.toString();
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
}
