package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingGame racingGame = new RacingGame();

        racingGame.getCarNameInput();
        int tryNumber = racingGame.getTryNumberInput();

        System.out.println();
        System.out.println("실행 결과");

        for(int i=0; i<tryNumber; i++) {
            racingGame.eachResult();
            racingGame.printEachResult();
        }

        racingGame.printFinalResult();
    }
}
