package racingcar;

public class RacingCarGame {
    /**
     * 게임 플레이 메서드
     */
    public static void play() {
        Console.printInputCarName();
        String carNames[] = Console.readCarName();

        Console.printInputTryCount();
        int tryCount = Console.readTryCount();

        gameStart(carNames, tryCount);
        Console.printWinners(null);
    }

    /**
     * 게임 시작 메서드
     *
     * @param carNames 자동차 이름 리스트
     * @param tryCount 시도 횟수
     */
    public static void gameStart(String carNames[], int tryCount) {
        Console.printResult();
    }
}
