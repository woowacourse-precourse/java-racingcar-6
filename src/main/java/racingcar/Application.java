package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCarGame racingCarGame = new RacingCarGame();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String line = readLine();
        racingCarGame.setRacingCars(line);
        System.out.println("시도할 회수는 몇회인가요?");
        line = readLine();
        racingCarGame.setMoveCnt(line);
        System.out.println();
        System.out.println("실행 결과");
        racingCarGame.printCarRacingProcess();
        racingCarGame.printWinner();
    }
}
