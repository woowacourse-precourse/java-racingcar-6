package racingcar;

import racingcar.enums.GameStatus;

import java.util.*;

/**
 * 자동차 경주 게임
 */
public class RacingGame {

    private GameStatus status;

    private List<RacingCar> participants;

    public RacingGame(GameStatus status) {
        this.status = status;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public List<RacingCar> getParticipants() {
        return participants;
    }

    public void setParticipants(List<RacingCar> participants) {
        this.participants = participants;
    }

    /**
     * 경주 게임을 시작한다.
     * @param moveCount
     */
    public GameResult start(int moveCount) {
        status = GameStatus.PLAYING;

        System.out.println("실행 결과");

        for (int i = 0; i < moveCount; i++) {
            participants.forEach(racingCar -> racingCar.move());
            participants.forEach(RacingCar::printResult);
        }

        status = GameStatus.END;

        GameResult gameResult = chooseWinners();
        List<RacingCar> winners = gameResult.getWinners();
        System.out.println(String.format("최종 우승자 : %s", String.join(", ", winners.stream().map(RacingCar::getName).toArray(String[]::new))));

        return gameResult;
    }

    /**
     * 결과에 따라 우승자를 고른다.
     * @return 우승자 자동차 list
     */
    public GameResult chooseWinners() {
        // key가 전진 횟수
        Map<Integer, List<RacingCar>> participantsByGoCount = new HashMap<>();
        int maxNum = 0;
        for (RacingCar car : participants) {
            if (car.getMoveResult() > maxNum) {
                maxNum = car.getMoveResult();
            }
            participantsByGoCount.computeIfAbsent(car.getMoveResult(), k -> new ArrayList<>()).add(car);
        }
        return new GameResult(participantsByGoCount.get(maxNum));
    }

}
