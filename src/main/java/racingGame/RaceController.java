package racingGame;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class RaceController {

    RaceService raceService = new RaceService();
    RaceUtil util = new RaceUtil();

    List<RaceVO> carNames = new ArrayList<>();
    int totalTrialCount;
    public void start() throws IllegalArgumentException {
        setGame();
        startGame();
        endGame();
    }

    private void setGame() {
        String[] names;
        // 자동차 이름 입력받기 (조건: 5글자 이하, "," 로 구분)
        try{
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            names = Console.readLine().split(",");
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        // 자동차 이름 5글자인지 여부 체크 후 리스트에 추가
        util.checkNameLength(carNames, names);

        // 시도할 횟수 입력 받기
        try{
            System.out.println("시도할 회수는 몇회인가요?");
            this.totalTrialCount = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        System.out.println();
    }
    private void startGame() {
        System.out.println("실행 결과");

        // 시도할 횟수만큼 반복
        for(int i=0; i<totalTrialCount; ++i) {
            for(RaceVO racer : carNames) {
                // 레이서 전진여부 체크
                raceService.goForward(racer);

                // 레이서 정보 출력
                raceService.printRacer(racer);
            }
            System.out.println();
        }
    }
    private void endGame() {
        // 승자 검사
        List<String> winners = raceService.checkWinner(carNames);

        // 최종 우승자 출력
        System.out.print("최종 우승자 : ");
        raceService.showWinners(winners);
    }
}
