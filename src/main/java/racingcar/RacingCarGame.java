package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private static List<String> carStatus;
    /**
     * 게임을 실질적으로 실행하는 메소드입니다.
     *
     * @param carNames 참가하는 자동차들의 이름 리스트
     * @param tryCount 시도할 회수
     */
    public static void play(List<String> carNames, int tryCount) {
        initializeCarStatus(carNames);

        for (int i = 0; i < tryCount; i++) {
            playOneRound(carNames);
        }

        printFinalResult(carStatus, carNames);
    }
    /**
     * 자동차의 초기 상태를 설정하는 메소드입니다.
     *
     * @param carNames 참가하는 자동차들의 이름 리스트
     */
    private static void initializeCarStatus(List<String> carNames) {
        carStatus = new ArrayList<>(carNames.size());
        for (int i = 0; i < carNames.size(); i++) {
            carStatus.add("");
        }
    }
    /**
     * 한 라운드를 실행하는 메소드입니다.
     *
     * @param carNames 참가하는 자동차들의 이름 리스트
     */
    private static void playOneRound(List<String> carNames) {
        printRoundResult(carNames);
    }
    /**
     * 한 라운드의 결과를 출력하는 메소드입니다.
     *
     * @param carNames 참가하는 자동차들의 이름 리스트
     */
    private static void printRoundResult(List<String> carNames) {
        System.out.print("\n" + "회 경주 결과:");

        for (int i = 0; i < carStatus.size(); i++) {
            updateAndPrintCarStatus(i, carNames);
        }
    }
    /**
     * 각 자동차의 상태를 업데이트하고 출력하는 메소드입니다.
     *
     * @param index 현재 자동차의 인덱스
     * @param carNames 참가하는 자동차들의 이름 리스트
     */
    private static void updateAndPrintCarStatus(int index, List<String> carNames) {
        updateCarStatus(index, carNames);
        System.out.println(carNames.get(index) + " : " + carStatus.get(index));
    }
    /**
     * 자동차의 상태를 업데이트하는 메소드입니다.
     *
     * @param index 현재 자동차의 인덱스
     * @param carNames 참가하는 자동차들의 이름 리스트
     */
    private static void updateCarStatus(int index, List<String> carNames) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            carStatus.set(index, carStatus.get(index) + "-");
        } else {
            carStatus.set(index, carStatus.get(index) + " ");
        }
    }
    /**
     * 최종 결과를 출력하는 메소드입니다.
     *
     * @param carStatus 각 자동차의 최종 상태 리스트
     * @param carNames 참가하는 자동차들의 이름 리스트
     */
    private static void printFinalResult(List<String> carStatus, List<String> carNames) {
        System.out.print("\n최종 우승자 : ");
        List<String> winners = findWinners(carStatus, carNames);
        System.out.println(String.join(", ", winners));
    }
    /**
     * 최종 우승자를 찾는 메소드입니다.
     *
     * @param carStatus 각 자동차의 최종 상태 리스트
     * @param carNames 참가하는 자동차들의 이름 리스트
     * @return 최종 우승자의 이름 리스트
     */
    public static List<String> findWinners(List<String> carStatus, List<String> carNames) {
        int maxDistance = 0;
        List<String> winners = new ArrayList<>();

        for (int i = 0; i < carStatus.size(); i++) {
            int distance = carStatus.get(i).replace(" ", "").length();
            if (distance > maxDistance) {
                maxDistance = distance;
                winners.clear();
                winners.add(carNames.get(i));
            } else if (distance == maxDistance) {
                winners.add(carNames.get(i));
            }
        }

        return winners;
    }
}
