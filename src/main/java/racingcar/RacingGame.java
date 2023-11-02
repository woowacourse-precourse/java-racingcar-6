package racingcar;

import racingcar.carlist.RacingCarList;
import racingcar.management.RacingGameManager;
import racingcar.user.User;
import racingcar.util.print.messages.GameMessages;
import racingcar.validation.Validator;

public class RacingGame {

    private final User user;
    private final Validator validator;
    private final RacingCarList racingCarList;
    private RacingGameManager gameManager;

    public RacingGame(User user, RacingCarList racingCarList) {
        this.user = user;
        this.validator = new Validator(user);
        this.racingCarList = racingCarList;
    }

    public void startGame() {
        setGame();
        setGameManager();
        // 실행 결과
        playRacingGame();
    }

    private void setGameManager() {
        // RacingGameManager의 객체 생성 코드를 추가
        this.gameManager = new RacingGameManager(user, racingCarList);

    }

    private  void playRacingGame() {
        gameManager.runRace();
    }

    private void setGame() {
        // 자동차 이름 입력
        GameMessages.printRequestForCarNames();
        user.settingRacingCarNames();
        validator.checkCarNamesLength();
        validator.checkCarNamesCount();
        // 진행할 라운드 횟수
        GameMessages.printRequestForRacingRoundsMessage();
        user.settingRacingRound();
    }

}
