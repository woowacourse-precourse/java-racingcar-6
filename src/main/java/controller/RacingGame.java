package controller;

import static view.GuideMessage.EXECUTION_RESULT;

import java.util.List;
import model.GameModel;
import view.RaceResult;
import view.RaceStatus;

public class RacingGame {
    public void gameStart() {
        UserInput userInput = new UserInput();
        //경주할 자동차 이름 입력
        String[] carNamesArray = userInput.getRaceCarNames();
        //시도 횟수 입력
        int attemptCount = userInput.getAttemptCount();
        //gameModel class 인스턴스 초기화
        GameModel gameModel = new GameModel(carNamesArray);
        //랜덤값에 따라 게임 현황 업데이트 및 출력
        startRacing(attemptCount, gameModel);
        //게임 결과 판독 및 출력
        endRacing(gameModel);
    }

    private void startRacing(int attemptCount, GameModel gameModel) {
        RaceStatus raceStatus = new RaceStatus();
        System.out.println(EXECUTION_RESULT);
        for (int i = 0; i < attemptCount; i++) {
            gameModel.updateRaceStatus();
            raceStatus.printRaceStatus(gameModel);
            System.out.println();
        }
    }

    private void endRacing(GameModel gameModel) {
        List<String> winnerNames = gameModel.getWinnerNames();

        RaceResult raceResult = new RaceResult();
        raceResult.showWinners(winnerNames);
    }
}