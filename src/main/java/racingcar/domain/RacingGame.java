package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class RacingGame {

    private List<String> resultList;
    private List<String> winner = new ArrayList<>();
    private InputDesk inputDesk;
    private Announcer announcer;
    private final int RAND_NUM_MAX = 9;
    private final int RAND_NUM_MIN = 0;
    private final int RAND_NUM_THRESHOLD = 4;

    public RacingGame() {

    }

    public List<String> initResultList(int numOfCars) {
        List<String> initList = new ArrayList<>();
        for (int i = 0; i < numOfCars; i++) {
            initList.add("");
        }
        return initList;
    }

    public void move(List cars,List resultList) {
        int randNum;
        for (int i = 0; i < cars.size(); i++) {
            randNum = Randoms.pickNumberInRange(RAND_NUM_MIN, RAND_NUM_MAX);
            decideMoveByRandValue(randNum,i, resultList);
        }
    }

    public String decideMoveByRandValue(int randNum, int index, List<String> resultList) {
        if (randNum >= RAND_NUM_THRESHOLD) {
            resultList.set(index, resultList.get(index) + "-");
            return resultList.get(index) + "-";
        }
        return resultList.get(index);
    }

    public List<String> chooseWinners(List<String> winner, List<String> resultList, List<String> cars) {

        int maxLen = 0;
        for (int i = 0; i < resultList.size(); i++) {
            if (resultList.get(i).length() > maxLen) {
                maxLen = resultList.get(i).length();
                winner.clear();
                winner.add(cars.get(i));
                continue;
            }
            if (resultList.get(i).length() == maxLen) {
                winner.add(cars.get(i));
                continue;
            }
        }
        return winner;
    }

    public void repeatOneSetGameUntilCount(int count) {
        for (int i = 0; i < count; i++) {
            move(inputDesk.getCars(),resultList);
            announcer.resultMessage();
            announcer.result(resultList, inputDesk.getCars());
        }
    }

    public void start() {
        inputDesk = new InputDesk();
        announcer = new Announcer();

        try {
            inputDesk.inputCars();
            inputDesk.inputCounts();
            resultList = initResultList(inputDesk.getCars().size());
            repeatOneSetGameUntilCount(inputDesk.getCount());
            chooseWinners(winner,resultList,inputDesk.getCars());
            announcer.winner(winner);
        } catch (IllegalArgumentException e) {
            throw e;
        }

    }

}
