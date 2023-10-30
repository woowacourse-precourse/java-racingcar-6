package racingcar.domain.game;

import static java.util.stream.Collectors.joining;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.player.RacingPlayer;
import racingcar.util.RaceProgressLogger;

public class RacingGame implements Game {
        RacingPlayer player;
        private List<Car> carList;
        private BigInteger laps;

        public RacingGame(RacingPlayer player) {
                this.player = player;
                initGame();
        }

        private void initGame() {
                int LIMIT_NAME_LENGTH = 5;
                carList = player.submitRacingCarList(LIMIT_NAME_LENGTH);
                laps = player.submitLaps();
                System.out.println();
        }

        @Override
        public void start() {
                System.out.println("실행 결과");
                for (int i = 0; i < laps.longValue(); i++) {
                        carList.forEach(Car::move);
                        RaceProgressLogger.printLog(carList);
                        System.out.println();
                }

                finish();
        }

        @Override
        public void finish() {
                List<Car> winners = getWinner();
                String winnerNames = winners.stream().map(Car::getName).collect(joining(", "));
                System.out.println("최종 우승자 : " + winnerNames);
        }

        private List<Car> getWinner() {
                Comparator<Car> comparing = Comparator.comparingLong(Car::getDrivenDistance);
                Car winner = carList.stream().max(comparing).orElseThrow();
                return carList.stream().filter(car -> car.getDrivenDistance() == winner.getDrivenDistance()).toList();

        }
}
