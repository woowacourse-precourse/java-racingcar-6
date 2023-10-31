package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingSystem s = new RacingSystem();
        s.input();
        s.racingStart();
        s.printWinners();
    }
}
