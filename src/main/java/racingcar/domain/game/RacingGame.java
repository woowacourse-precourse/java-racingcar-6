package racingcar.domain.game;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.RacingCar;
import racingcar.domain.judgement.Judgement;
import racingcar.domain.player.RacingPlayer;
import racingcar.util.RaceProgressLogger;
import racingcar.util.RandomNumberUtil;

/**
 * Racing game 의 개념 객체를 나타내는 클래스입니다.
 */
public class RacingGame implements Game {
        /**
         * 게임에 참가하는 플레이어 입니다.
         */
        private final RacingPlayer player;

        /**
         * 게임에 결과를 결정하는 심판입니다.
         */
        private final Judgement judgement;

        /**
         * 게임에 참여하는 자동차 리스트입니다.
         */
        private List<Car> carList;

        /**
         * 경주를 진행할 laps 를 의미합니다.
         */
        private BigInteger laps;

        /**
         * 경주 게임의 생성자로, 게임에 필요한 초기화 작업을 위해서 init 메서드를 호출합니다.
         *
         * @param judgement 게임 심판
         * @param player    게임 참가 플레이어
         */
        public RacingGame(final Judgement judgement, final RacingPlayer player) {
                if (judgement == null || player == null) {
                        throw new IllegalArgumentException("Null은 허용되지 않습니다.");
                }

                this.judgement = judgement;
                this.player = player;
                initGame();
        }

        /**
         * 게임에 필요한 정보를 초기화합니다. 플레이어로 부터 laps 응답 받습니다. readyToRacingCar 메서드를 호출합니다.
         */
        private void initGame() {
                readyToRacingCar();
                setLaps();
                System.out.println();
        }

        /**
         * 플레이어로 부터 laps 를 응답받습니다.
         */
        private void setLaps() {
                laps = player.submitLaps();
        }

        /**
         * 경주에 참여할 자동차를 생성합니다.
         */
        private void readyToRacingCar() {
                List<String> carNameList = getCarNameListFromPlayer();
                carList = carNameList.stream()
                        .map(name -> new RacingCar(name, RandomNumberUtil.getInstance()))
                        .collect(Collectors.toList());
        }

        /**
         * 플레이어로 부터 자동차 이름을 응답 받고,
         *
         * @return 자동차 이름 리스트
         */
        private List<String> getCarNameListFromPlayer() {
                int LIMIT_NAME_LENGTH = 5;
                return player.submitRacingCarNameList(LIMIT_NAME_LENGTH);
        }

        /**
         * 경주 게임을 시작합니다. 정해진 laps 만큼 반복 후 반복이 끝나면 finish 메서드를 호출합니다.
         */
        @Override
        public void start() {
                System.out.println("실행 결과");
                for (int i = 0; i < laps.longValue(); i++) {
                        goAllCar();
                        RaceProgressLogger.printLog(carList);
                        System.out.println();
                }

                finish();
        }

        /**
         * 자동차에게 출발신호를 알립니다.
         */
        private void goAllCar() {
                carList.forEach(Car::move);
        }

        /**
         * 경주 게임을 종료합니다. 심판에게 게임의 결과 발표를 요청합니다.
         */
        @Override
        public void finish() {
                judgement.announcementWinner(carList);
        }
}
