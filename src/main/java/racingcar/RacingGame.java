package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Car> cars;
    private int attempts;

    public RacingGame(List<Car> cars, int attempts) {
        this.cars = cars;
        this.attempts = attempts;
    }

    public void playGame() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < attempts; i++) {
            playRound();
        }
    }

    private void playRound() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.attemptToMove(randomNumber);
            System.out.println(car);
        }
        System.out.println();
    }

    public void announceWinners() {
        int maxPosition = getMaxPosition();
        String winners = getWinners(maxPosition);
        System.out.println("최종 우승자 : " + winners);
    }

    private int getMaxPosition() {
        return cars.stream().mapToInt(Car::getPosition).max().orElse(0);
    }

    private String getWinners(int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
