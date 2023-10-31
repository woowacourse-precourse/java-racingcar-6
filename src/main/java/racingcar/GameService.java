package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    private final List<Car> cars = new ArrayList<>();
    private final int tryCount;

    public GameService(String [] names, int tryCount) {
        String[] carNames = names;
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        this.tryCount = tryCount;
    }

    public void run() {
        for (int i = 0; i < tryCount; i++) {
            playRound(i + 1);
        }
        determineWinner();
    }

    private void playRound(int round) {
        for (Car car : cars) {
            car.move();
        }
        printRoundResult(round);
    }

    private void printRoundResult(int round) {
        System.out.println("실행 결과");
        for (Car car : cars) {
            System.out.printf("%s : %s%n", car.getName(), car.getProgress());
        }
        System.out.println();
    }

     void determineWinner() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        printWinners(winners);
    }

    void printWinners(List<String> winners) {
        String winnersString = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnersString);
    }
}
