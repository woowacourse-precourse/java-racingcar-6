package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.RacingcarService;
import racingcar.view.ReaultView;

import java.util.ArrayList;

public class RacingcarController {

    private final RacingcarService racingcarService;

    private final ReaultView resultView;

    public RacingcarController(RacingcarService racingcarService, ReaultView resultView) {
        this.racingcarService = racingcarService;
        this.resultView = resultView;
    }

    public void run() {
        racingcarService.initStore();
        inputRacingcar();
        testProcess(inputTestTimes());
        outputWinners();
    }

    public void inputRacingcar() {
        resultView.scanRacingcarName();
        String input = Console.readLine();

        racingcarService.joinRacingcar(input);
    }

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

    public void testProcess(int testTimes) {
        System.out.println("실행 결과");
        for (int i = 0; i < testTimes; i++) {
            resultView.printProcess(racingcarService.changeMoving());
        }
    }

    public boolean outputWinners() {
        ArrayList<String> winners = racingcarService.selectWinner();
        resultView.printWinners(winners);

        return true;
    }

}
