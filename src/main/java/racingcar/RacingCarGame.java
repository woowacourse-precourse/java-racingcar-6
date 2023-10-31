package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.constants.Rule.*;

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

        int progress[] = new int[carNames.length];
        for (int i = 0; i < tryCount; i++) {
            updateProgress(progress);
            Console.printProgress(carNames, progress);
        }
    }

    /**
     * 자동차 경주 진행
     *
     * @param progress
     */
    private static void updateProgress(int progress[]) {
        for (int i = 0; i < progress.length; i++) {
            progress[i] += goOrStop();
        }
    }

    /**
     * 전진 또는 멈춤을 결정하는 메서드
     *
     * @return 전진 또는 멈춤
     */
    private static int goOrStop() {
        if (getRandomNumber() >= ADVANCE_CONDITION) {
            return 1;
        }
        return 0;
    }

    /**
     * 랜덤 숫자 생성
     *
     * @return 랜덤 숫자
     */
    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER);
    }
}
