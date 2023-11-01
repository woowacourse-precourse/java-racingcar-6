package racingcar;

public class Application {
    public static void main(String[] args) {
        // 자동차 이름 입력
        String[] carNames = SetName.setCarNames();

        // 시도 횟수 입력
        int rounds = SetRound.setRound();

        // 경주 시작
        Game racingGame = new Game(carNames, rounds);
        racingGame.startRace();

        // 경주 결과 출력
        racingGame.printWinners();
    }
}
