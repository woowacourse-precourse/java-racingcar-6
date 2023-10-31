package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.RacingcarService;
import racingcar.view.ResultView;

import java.util.ArrayList;

public class RacingcarController {

    private final RacingcarService racingcarService;

    private final ResultView resultView;

    // DIP
    public RacingcarController(RacingcarService racingcarService, ResultView resultView) {
        this.racingcarService = racingcarService;
        this.resultView = resultView;
    }

    // 전체 동작 실행
    public void run() {
        racingcarService.initStore();
        inputRacingcar();
        testProcess(inputTestTimes());
        outputWinners();
    }

    // 자동차 이름 입력
    public void inputRacingcar() {
        resultView.scanRacingcarName();
        String input = Console.readLine();

        racingcarService.joinRacingcar(input);
    }

    // 시도 회수 입력
    public int inputTestTimes() {
        resultView.scanTestTimes();

        int testTimes = 0;

        try {
            testTimes = Integer.parseInt(Console.readLine());

        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 입력값이 잘못되었습니다.");
        }

        return testTimes;
    }

    // 실행 결과 동작 및 내용 출력
    public void testProcess(int testTimes) {
        System.out.println("실행 결과");
        for (int i = 0; i < testTimes; i++) {
            resultView.printProcess(racingcarService.changeMoving());
        }
    }

    // 우승자 판별 및 내용 출력
    public boolean outputWinners() {
        ArrayList<String> winners = racingcarService.selectWinner();
        resultView.printWinners(winners);

        return true;
    }

}
