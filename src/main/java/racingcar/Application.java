package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 자동차 이름 입력 요청 문구 출력
        RacingCarGame.printAskingForCarNamesMessage();

        // 자동차 이름 입력 받기
        String carNamesString = RacingCarGame.getUserInput();

        // List에 자동차 이름 넣기
        List<String> carNamesList = RacingCarGame.splitGamePlayers(carNamesString);

        // 이름 길이 예외 처리
        RacingCarGame.validateCarNameLength(carNamesList);

        // 시도 횟수 입력 요청 문구 출력
        RacingCarGame.printAskingForTrialNumberMessage();

        // 시도 횟수 입력 받기
        String trialNumberString = RacingCarGame.getUserInput();

        // int 타입으로 변환하기
        int trialNumberInt = RacingCarGame.convertStringToInt(trialNumberString);
        System.out.println();

        // 실행 결과 문구 출력
        RacingCarGame.printExecutionResult();

        // 자동차별 진행 상황을 기록할 2차원 List 선언
        List<String>[] progressOfCarRacing = new ArrayList[carNamesList.size()];
        for(int i=0; i< carNamesList.size(); i++){
            progressOfCarRacing[i] = new ArrayList<>();
        }

        // 사용자가 입력한 시도 횟수만큼 이동
        RacingCarGame.repeatExecution(trialNumberInt, carNamesList, progressOfCarRacing);

        // 최종 우승자 선발
        List<String> winners = RacingCarGame.selectWinner(progressOfCarRacing, trialNumberInt, carNamesList);

        // 최종 우승자 출력
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
