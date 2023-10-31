package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class RacingManager {
    int lap;    // 레이싱 횟수

    public List<String> splitCarName(String carName) {
        return Arrays.stream(carName.split(",")).toList();
    }

    public void setLap(int lap) {
        this.lap = lap;
    }

    public void race(List<RacingCar> racingCars) {
        for (int i = 0; i < lap; i++) {
            printResult(racingCars);
            System.out.println();
        }
    }

    private void printResult(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            System.out.println(racingCar.move(Randoms.pickNumberInRange(0, 9)));
        }
    }

    public String finalWinner(List<RacingCar> racingCars) {
        Map<Integer, List<RacingCar>> racingCarByBlockCount = new HashMap<>();
        int winnerBlockCount = 0;
        racingCarByBlockCount.put(winnerBlockCount, new ArrayList<>());
        for (RacingCar racingCar : racingCars) {
            winnerBlockCount = judgeWinnerAndBlockCount(racingCar, racingCarByBlockCount, winnerBlockCount);
        }

        List<String> racingCarName = racingCarByBlockCount.get(winnerBlockCount).stream().map(racingCar ->
                racingCar.name
        ).toList();
        return stringListToString(racingCarName);
    }

    private int judgeWinnerAndBlockCount(RacingCar racingCar, Map<Integer, List<RacingCar>> racingCarByBlockCount, int winnerBlockCount) {
        if (racingCar.blockCount > winnerBlockCount) {
            racingCarByBlockCount.put(racingCar.blockCount, new ArrayList<>());
            winnerBlockCount = racingCar.blockCount;
        }
        racingCarByBlockCount.get(racingCar.blockCount).add(racingCar);
        return winnerBlockCount;
    }

    private String stringListToString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            addString(sb, list, s);
        }
        return sb.toString();
    }

    private void addString(StringBuilder sb, List<String> list, String s) {
        sb.append(s);
        if (list.indexOf(s) != list.size() - 1)
            sb.append(", ");
    }
}
