package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.message.ErrorMessage;
import racingcar.message.GameMessage;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Car> cars;
    private Integer tryCount;
    private Integer turnCount;

    private RacingGame(Builder builder) {
        this.cars = builder.carInput.getCarNames().stream().map(Car::new).collect(Collectors.toList());
        this.tryCount = builder.tryCount;
        this.turnCount = 0;
    }

    public void play() {
        while(!isGameOver()) {
            playOneRound();
            turnCount++;
        }
//        printWinner();
    }

    public List<Car> getWinner() {
        if(!isGameOver()) {
            throw new IllegalStateException(ErrorMessage.GAME_NOT_FINISHED);
        }
        Integer maxPosition = cars.stream().map(Car::getPosition).max(Integer::compareTo).get();
        return this.cars.stream().filter(car -> car.atPosition(maxPosition)).toList();
    }

    private void printWinner() {
        List<Car> winners = getWinner();
        String winnerMsg = GameMessage.getWinnerMessage(winners);
        System.out.println(winnerMsg);
    }

    private void playOneRound() {
        for(Car car : cars) {
            moveIfAble(car);
        }
        printPosition();
    }

    private void printPosition() {
        for(Car car : cars) {
            car.printPosition();
        }
        System.out.println();
    }

    private void moveIfAble(Car car) {
        if (isMoveAble(car)) {
            car.moveForward();
        }
    }

    private boolean isMoveAble(Car car) {
        Integer randNum = Randoms.pickNumberInRange(GameConfig.RANDOM_MIN_NUMBER, GameConfig.RANDOM_MAX_NUMBER);
        boolean isMoveAble = randNum >= GameConfig.MOVE_CONDITION;
        boolean atMaxPosition = car.atPosition(tryCount);

        return isMoveAble && !atMaxPosition;
    }

    private boolean isGameOver() {
        return this.turnCount.equals(this.tryCount);
    }

    public static class Builder {
        private CarInput carInput;
        private Integer tryCount;

        public Builder Builder() {
            return this;
        }

        public Builder carInput(CarInput carInput) {
            this.carInput = carInput;
            return this;
        }

        public Builder tryCount(Integer tryCount) {
            this.tryCount = tryCount;
            return this;
        }

        public RacingGame build() {
            return new RacingGame(this);
        }
    }
}