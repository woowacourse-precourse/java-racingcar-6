package racingcar;

import java.util.List;

public class Game {
    private final Cars cars;
    private final int tryCount;

    public Game(String carNames, int tryCount) {
        cars = new Cars();
        makeCars(carNames);
        this.tryCount = tryCount;
    }

    public void play() {
        for (int i = 0; i < tryCount; i++) {
            playRound();
        }
    }

    private void playRound() {
        for (Car car : cars.getCars()) {
            car.moveForward();
            car.printResult();
        }
        System.out.println();
    }

    private void makeCars(String carNames) {
        for (String carName : carNames.split(Constant.COMMA)) {
            if (cars.contains(carName)) {
                throw new IllegalArgumentException("중복된 이름의 자동차가 존재합니다.");
            }
            cars.addCar(new Car(carName));
        }
    }

    private List<String> findWinners() {
        int maxPosition = cars.findMaxPosition();
        return cars.findWinners(maxPosition);
    }

    public void printFinalResult() {
        List<String> winners = findWinners();
        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }
}
