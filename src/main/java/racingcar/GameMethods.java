package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class GameMethods {
    /**
     * 난수 생성해서 배열에 저장
     *
     * @param numberOfCars
     * @return
     */
    public static int[] makeRandNum(int numberOfCars) {
        int[] howFar = new int[numberOfCars];
        for (int j = 0; j < numberOfCars; j++) {
            howFar[j] = Randoms.pickNumberInRange(0, 9);
        }
        return howFar;
    }

    /**
     * 난수가 4 이상일 때 "-" 추가
     *
     * @param numberOfCars
     * @param movedDistance
     * @param howFar
     */
    public static void goOrStop(int numberOfCars, String[] movedDistance, int[] howFar) {
        for (int i = 0; i < numberOfCars; i++) {
            if (howFar[i] >= 4) {
                movedDistance[i] += "-";
            }
        }
    }

    /**
     * 이긴 사람 정해서 ArrayList에 저장
     *
     * @param movedDistance
     * @param carNames
     * @return
     */
    public static ArrayList<String> decideWinner(String[] movedDistance, String[] carNames) {
        int max = 0;
        ArrayList<String> winningCandidate = new ArrayList<>();

        for (int i = 0; i < movedDistance.length; i++) {
            if (max < movedDistance[i].length()) {
                max = movedDistance[i].length();
                winningCandidate.clear();
                winningCandidate.add(carNames[i]);
            } else if (max == movedDistance[i].length()) {
                winningCandidate.add(carNames[i]);
            }
        }

        return winningCandidate;
    }

    /**
     * 최종 우승자 출력 포맷 만들기
     *
     * @param winningCandidate
     * @return
     */
    public static StringBuilder winnerPrintForm(ArrayList<String> winningCandidate) {
        StringBuilder winners = new StringBuilder();
        winners.append("최종 우승자 :");
        for (int i = 0; i < winningCandidate.size(); i++) {
            winners.append(" ").append(winningCandidate.get(i)).append(",");
        }
        winners.deleteCharAt(winners.length() - 1);

        return winners;
    }
}
