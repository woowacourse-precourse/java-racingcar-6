package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Race {

    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT = "실행 결과";
    private static final String BAR = "-";
    private static final String COMMA = ", ";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private int raceCount = 0;
    private List<String> racer;
    private int racerCount = 0;
    private List<Integer> barCount = new ArrayList<>();

    public Race() {
        Car car = new Car();
        System.out.println(START_MESSAGE);
        racer = car.getRacerName();
        raceCount = start();
        racerCount = racer.size();
        barCount = init(barCount, racerCount);
        System.out.println(RESULT);

        for (int i = 0; i < raceCount; i++) {
            show(racer, barCount, racerCount);
            System.out.println();
        }
        List<Integer> winnerIndex = showWinnerIndex(barCount);
        int commaCount = checkWinnerSize(winnerIndex);
        List<String> winnerName = winnerName(winnerIndex, racer);
        showWinnerResult(commaCount, winnerName);
    }

    private int start() {

        System.out.println(COUNT_MESSAGE);
        raceCount = Integer.parseInt(readLine());
        return raceCount;

    }

    private List<Integer> init(List<Integer> barCount, int racerCount) {
        for (int i = 0; i < racerCount; i++) {
            barCount.add(0);
        }
        return barCount;
    }

    private void show(List<String> racer, List<Integer> barCount, int racerCount) {
        increaseBar(barCount);
        String nowBar;
        for (int i = 0; i < racerCount; i++) {
            int bar = barCount.get(i);
            nowBar = showBar(bar, BAR);
            System.out.println(racer.get(i) + " : " + nowBar);
        }

    }

    private String showBar(int bar, String BAR) {
        String newBar = "";
        for (int i = 0; i < bar; i++) {
            newBar += BAR;
        }
        return newBar;
    }

    private List<String> winnerName(List<Integer> winnerIndex, List<String> racer) {
        List<String> name = new ArrayList<>();
        for (int nameIndex : winnerIndex) {
            name.add(racer.get(nameIndex));
        }
        return name;
    }

    private List<Integer> increaseBar(List<Integer> barCount) {
        int num = 0;
        for (int i = 0; i < barCount.size(); i++) {
            num = pickNumberInRange(0, 9);
            if (checkUpperFour(num)) {
                int count = barCount.get(i);
                barCount.set(i, count + 1);
            }
        }

        return barCount;
    }

    private boolean checkUpperFour(int num) {
        if (num >= 4) {
            return true;
        }
        return false;
    }

    private int checkWinnerSize(List<Integer> winnerIndex) {
        if (winnerIndex.size() == 1) {
            return 0;
        }
        return winnerIndex.size() - 1;
    }

    private List<Integer> showWinnerIndex(List<Integer> barCount) {
        Integer max = Collections.max(barCount);
        List<Integer> maxIndex = compare(max, barCount);

        return maxIndex;
    }

    private List<Integer> compare(int max, List<Integer> barCount) {
        List<Integer> maxIndex = new ArrayList<>();
        for (int i = 0; i < barCount.size(); i++) {
            if (barCount.get(i) == max) {
                maxIndex.add(i);
            }
        }
        return maxIndex;
    }

    private void showWinnerResult(int commaCount, List<String> winnerName) {
        if (commaCount == 0) {
            showOneWinner(winnerName);
        } else {
            showOneMoreThanWinner(commaCount, winnerName);
        }
    }

    private void showOneWinner(List<String> winnerName) {

        System.out.print(WINNER_MESSAGE + "");
        System.out.println(winnerName.get(0));

    }

    private void showOneMoreThanWinner(int commaCount, List<String> winnerName) {
        System.out.print(WINNER_MESSAGE + "");
        for (int i = 0; i < commaCount; i++) {
            System.out.print(winnerName.get(i) + COMMA);
        }
        System.out.print(winnerName.get(commaCount));
    }


}



