package racingcar.RacingGame;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class RacingGame { // Application에서는 게임만 고를 수 있다.

    GameStartData gameStartData; // 시작 유저입력 데이터
    RacingGameUtil racingGameUtil; // 게임 최종 결과 데이터

    public void GameManager(){ // 총괄적으로 게임을 관리하는 부분.

        this.gameStartData = GameStart(); // 게임 시작 입력 부분

        this.racingGameUtil = GameOperation(gameStartData.userNames,
                gameStartData.userIteration); // 게임 결과 출력 부분

        GameEnd(this.racingGameUtil); // 결과 출력 부분
    }

    public GameStartData GameStart(){ // 맨 처음 입력을 받는 부분

        // GameMethod Utilization
        GameExceptionUtil gameExceptionUtil = new GameExceptionUtil();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = Console.readLine();
        System.out.println("시도할 회수는 몇회인가요?");
        int iteration = gameExceptionUtil.interationValidation(Console.readLine());

        // 결과 출력
        return new GameStartData(Arrays.asList(userInput.split(",")), iteration);

    }

    public RacingGameUtil GameOperation(List<String> userList, int iteration){ // 유저가 보낸 정보를 통해서 게임을 동작시키는 부분

        // 전체적인 게임 메서드 Utilization
        RacingGameUtil racingGameUtil = new RacingGameUtil(userList);
        GameExceptionUtil gameExceptionUtil = new GameExceptionUtil();

        // User 이름 길이 체크.
        racingGameUtil.checkUserNameLength(userList, gameExceptionUtil);

        // 유저 이름에 문제가 없으면 실행이 정상적으로 작동
        System.out.println("실행 결과");
        for(int i = 0; i < iteration; i++){
            racingGameUtil.UpdateUserStatus(); // 회차별 게임 결과 업데이트
            racingGameUtil.PrintGameStatus(); // 회차별 게임 결과 출력
        }

        return racingGameUtil;
    }

    public void GameEnd(RacingGameUtil racingGameUtil){ // 최종 우승자 출력
        int highRecord = racingGameUtil.getWinnerRecord(); // 최고기록

        List<String> WinnerList = racingGameUtil.getWinnerList(highRecord);

        String result = "최종 우승자 : ";
        for(String winner :WinnerList)
            result = result + winner + ", ";

        System.out.println(result.substring(0, result.length()-2));
    }

}
