package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        InitData initData = getInitData();

        simulateRace(initData.tryCount(), initData.carNames(), initData.distanceArray());

        int max = findMaxDistance(initData.distanceArray());
        ArrayList<Integer> winner = getWinners(initData.distanceArray(), max);
        // TODO : 우승자 출력

    }

    private static InitData getInitData() {
        System.out.println("경주 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        validateCarNames(carNames);

        System.out.println("시도할 회수는 몇회 인가요?");
        int tryCount = getTryCount();
        int[] distanceArray = new int[carNames.length];
        System.out.println();
        InitData initData = new InitData(carNames, tryCount, distanceArray);
        return initData;
    }

    private record InitData(String[] carNames, int tryCount, int[] distanceArray) {

    }

    private static void validateCarNames(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            if (carNames[i].length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 넘길수 없습니다.");
            }

            if (!carNames[i].matches("^[0-9a-zA-Z]*$")) {
                throw new IllegalArgumentException("자동차 이름은 영어 숫자만 가능 합니다.");
            }
        }
    }

    private static int getTryCount() {
        String response = Console.readLine();
        int tryCount = validateTryCount(response);
        return tryCount;
    }

    private static int validateTryCount(String response) {
        int tryCount;
        try {
            tryCount = Integer.parseInt(response);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("회수는 숫자만 입력 받을수 있습니다.");
        }
        return tryCount;
    }


    private static void simulateRace(int tryCount, String[] carNames, int[] distanceArray) {
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {

            printProgress(carNames, distanceArray);

            System.out.println();
        }
    }

    private static void printProgress(String[] carNames, int[] distanceArray) {
        for (int i = 0; i < carNames.length; i++) {
            if (Randoms.pickNumberInRange(0, 9) > 3) {
                distanceArray[i] = distanceArray[i] + 1;
            }
            System.out.print(carNames[i] + " : ");
            for (int j = 0; j < distanceArray[i]; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }


    public static int findMaxDistance(int[] distanceArray) {
        int max = distanceArray[0];
        for (int i = 1; i < distanceArray.length; i++) {
            if (distanceArray[i] > max) {
                max = distanceArray[i];
            }
        }
        return max;
    }


    public static ArrayList<Integer> getWinners(int[] distanceArray, int max) {
        ArrayList<Integer> winner = new ArrayList<>();
        for (int i = 0; i < distanceArray.length; i++) {
            if (distanceArray[i] == max) {
                winner.add(i);
            }
        }
        return winner;
    }
}
