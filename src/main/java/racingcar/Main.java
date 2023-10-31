package racingcar;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    Generator generator;
    Moving moving;
    CarNames carNames;

    public void setup() {
        carNames = new CarNames();
        moving = new Moving();
        generator = new Generator();

    }

    public void run() {
        Message.startMessage();
        List<String> carList = carNames.inputCarNames();
        int carListSize = carList.size();
        List<Integer> winCount = new ArrayList<>(Collections.nCopies(carListSize, 0));

        Message.countMessage();
        int movingCount = moving.inputMovingNumber();

        racing(carListSize, winCount, carList, movingCount);

        List<Integer> winnerIndex = judgeWinner(carListSize, winCount);
        Message.winnerMessage(carList,winnerIndex);

        System.out.println();

    }

    public void racing (int size, List<Integer> winCount, List<String> carList, int movingCount) {
        for (int i =0; i < movingCount; i++) {
            racingDetail(size, winCount);
            Message.racingMessage(size, winCount, carList);
        }
    }

    private void racingDetail (int size, List<Integer> winCount) {
        for (int i =0; i < size; i++) {
            int nowWinCount = winCount.get(i);
            if (judgeNumber()) {
                winCount.set(i, nowWinCount + 1);
            }
        }
    }


    private boolean judgeNumber() {
        int randomNumber = generator.numberGenerator();
        return randomNumber >=4;
    }

    public List<Integer> judgeWinner (int size, List<Integer> winCount) {
        List<Integer> winner = new ArrayList<>();
        int maxwin = Collections.max(winCount);
        for (int i=0; i<size; i++) {
            if (winCount.get(i) == maxwin) {
                winner.add(i);
            }
        }
        return winner;
    }
}
