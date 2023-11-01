package controller;

import static view.guideMessage.EXECUTION_RESULT;

import model.racingGameModel;
import view.raceStatus;
import view.raceResult;

import java.util.List;

public class game {
    public void gameStart(){
        userInputController userInputController = new userInputController();
        //경주할 자동차 이름 입력
        String[] carNamesArray = userInputController.getRaceCarNames();
        //시도 횟수 입력
        int attemptCount = userInputController.getAttemptCount();
        //racingGameModel class 인스턴스 초기화
        racingGameModel racingGameModel = new racingGameModel(carNamesArray);
        //랜덤값에 따라 게임 현황 업데이트 및 출력
        startRacing(attemptCount, racingGameModel);
        //게임 결과 판독 및 출력
        endRacing(racingGameModel);
    }
    private void startRacing(int attemptCount, racingGameModel racingGameModel){
        raceStatus raceStatus = new raceStatus();
        System.out.println(EXECUTION_RESULT);
        for(int i = 0;i<attemptCount;i++){
            racingGameModel.updateRaceStatus();
            raceStatus.printRaceStatus(racingGameModel);
            System.out.println();
        }
    }
    private void endRacing(racingGameModel racingGameModel){
        List<String> winnerNames = racingGameModel.getWinnerNames();

        raceResult raceResult = new raceResult();
        raceResult.showWinners(winnerNames);
    }
}