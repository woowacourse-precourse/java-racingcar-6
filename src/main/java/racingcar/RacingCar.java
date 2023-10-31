package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    public void execute() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNameArr = getCarName();

        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = readTryCount();

        System.out.println("");
        System.out.println("실행 결과");
        int[] carResult = executeRacingGame(tryCount, carNameArr);

        List<String> winners = getWinnersResult(carResult, carNameArr);

        System.out.println("최종 우승자 : " + getWinnerString(winners));
    }


    public String[] getCarName() {
        String[] carNameArr = Console.readLine().split(",");
        for (String carName : carNameArr) {
            if (carName.contains(" ")) {
                throw new IllegalArgumentException();
            }

            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        return carNameArr;
    }

    public int readTryCount() {
        int tryCount = 0;
        try {
            tryCount = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        if (tryCount == 0) {
            throw new IllegalArgumentException();
        }
        return tryCount;
    }

    public int[] executeRacingGame(int tryCount, String[] carNameArr) {
        int[] carResult = new int[carNameArr.length];
        for (int i = 0; i < tryCount; i++) {
            executeRacing(carResult);
            printRacingResult(carNameArr, carResult);
            System.out.println("");
        }
        return carResult;
    }

    public void executeRacing(int[] carResult) {
        for (int idx = 0; idx < carResult.length; idx++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                carResult[idx] = carResult[idx] + 1;
            }
        }
    }

    public void printRacingResult(String[] carNameArr, int[] carResult) {
        for (int idx = 0; idx < carNameArr.length; idx++) {
            System.out.println(carNameArr[idx] + " : " + getResultString(carResult[idx]));
        }
    }

    public String getResultString(int result) {
        String resultString = "";
        for (int i = 0; i < result; i++) {
            resultString += "-";
        }
        return resultString;
    }

    public List<String> getWinnersResult(int[] carResult, String[] carNameArr) {
        int maxResult = -1;
        List<String> winners = new ArrayList<>();

        for (int idx = 0; idx < carResult.length; idx++) {
            if (maxResult == carResult[idx]) {
                winners.add(carNameArr[idx]);
                continue;
            }

            int beforeMax = maxResult;
            maxResult = Math.max(maxResult, carResult[idx]);
            if (maxResult > beforeMax) {
                winners.clear();
                winners.add(carNameArr[idx]);
            }
        }
        return winners;
    }
    
    public String getWinnerString(List<String> winners) {
        return String.join(", ", winners);
    }
}