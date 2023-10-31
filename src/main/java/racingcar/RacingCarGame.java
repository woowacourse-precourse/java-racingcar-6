package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static racingcar.constants.Rule.*;

public class RacingCarGame {
    /**
     * 게임 플레이 메서드
     */
    public static void play() {
        Console.printInputCarName();
        String carNames[] = Console.readCarName();
        int progress[] = new int[carNames.length];

        Console.printInputTryCount();
        int tryCount = Console.readTryCount();

        running(tryCount, carNames, progress);
        Console.printWinners(findWinners(carNames, progress));
    }

    /**
     * 자동차 경주 진행
     *
     * @param carNames 자동차 이름 리스트
     * @param tryCount 시도 횟수
     */
    private static void running(int tryCount, String carNames[], int progress[]) {
        Console.printResult();

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
     * 우승자 찾기
     *
     * @param carNames 자동차 이름 리스트
     * @param progress 진행 상황 리스트
     * @return 우승자 리스트
     */
    private static List<String> findWinners(String carNames[], int progress[]) {
        int maxProgress = Arrays.stream(progress).max().getAsInt();
        return Stream.iterate(0, i -> i + 1)
                .limit(progress.length)
                .filter(i -> progress[i] == maxProgress)
                .map(i -> carNames[i])
                .toList();
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
