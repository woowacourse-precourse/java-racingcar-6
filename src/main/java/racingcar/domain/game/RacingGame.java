package racingcar.domain.game;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.RacingCar;
import racingcar.domain.judgement.Judgement;
import racingcar.domain.player.RacingPlayer;
import racingcar.util.RaceProgressLogger;
import racingcar.util.RandomNumber;

public class RacingGame implements Game {
        private final RacingPlayer player;
        private final Judgement judgement;
        private final RandomNumber util;
        private List<Car> carList;
        private BigInteger laps;

        public RacingGame(final Judgement judgement, final RacingPlayer player, RandomNumber util) {
                this.judgement = judgement;
                this.player = player;
                this.util = util;
                initGame();
        }

        private void initGame() {
                readyToRacingCar();
                laps = player.submitLaps();
                System.out.println();
        }

        private void readyToRacingCar() {
                int LIMIT_NAME_LENGTH = 5;
                List<String> carNameList = player.submitRacingCarNameList(LIMIT_NAME_LENGTH);
                carList = carNameList.stream().map(name -> new RacingCar(name, util)).collect(Collectors.toList());
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
                judgement.announcementWinner(carList);
        }
}
