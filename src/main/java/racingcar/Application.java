package racingcar;

import java.io.PrintStream;

public class Application {
    public static void main(String[] args) {
        PrintStream printStream = System.out;
        RacingGame game = new RacingGame();

        printStream.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        game.enterCarName();
        
        printStream.println("시도할 회수는 몇회인가요?");
        game.enterMoveCount();
        
        printStream.println();
        printStream.println("실행 결과");
        game.start();
        
        printStream.print("최종 우승자 : ");
        printStream.println(String.join(", ", game.getWinnerNames()));
    }
}
