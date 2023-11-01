package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int maxNameLength = 5;
        int forwardCriterion = 4;
        int lowerBoundRandomNumber = 0;
        int upperBoundRandomNumber = 9;

        RacingGame racingGame = new RacingGame(maxNameLength, forwardCriterion, lowerBoundRandomNumber, upperBoundRandomNumber);
        racingGame.play();
    }
}
