package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private static final String EXECUTE_RESULT_MESSAGE = "\n실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private final List<Car> carList = new ArrayList<>();
    private final List<String> carNameList;
    private final List<String> winnerList = new ArrayList<>();
    private final int tryCount;

    public Race(List<String> carNameList, int tryCount) {
        this.carNameList = carNameList;
        this.tryCount = tryCount;
    }

    public void start() {
        setCarInstance();
        tryNRound(tryCount);
        decideWinner();
        noticeWinner();
    }

    private void setCarInstance() {
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
    }

    private void tryNRound(int tryCount) {
        System.out.println(EXECUTE_RESULT_MESSAGE);
        for (int i = 0; i < tryCount; i++) {
            tryOneRound();
            System.out.println();
        }
    }

    private void tryOneRound() {
        for (Car car : carList) {
            car.goOrStop();
            car.printNameAndCount();
        }
    }

    private int findMaxGoCount() {
        int maxGoCount = -1;
        for (Car car : carList) {
            int goCount = car.getGoCount();
            if (goCount > maxGoCount) {
                maxGoCount = goCount;
            }
        }
        return maxGoCount;
    }

    private void decideWinner() {
        int maxGoCount = findMaxGoCount();
        for (Car car : carList) {
            if (car.getGoCount() == maxGoCount) {
                winnerList.add(car.getName());
            }
        }
    }

    private void noticeWinner() {
        System.out.print(WINNER_MESSAGE);
        System.out.print(String.join(",", winnerList));
    }
}
