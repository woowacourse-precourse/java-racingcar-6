package racingcar;

import racingcar.car.RacingCar;
import racingcar.printer.ConsoleRacingPrinter;
import racingcar.printer.RacingPrinter;
import racingcar.receiver.ConsoleRacingReceiver;
import racingcar.receiver.RacingReceiver;

import java.util.ArrayList;
import java.util.List;

public class RacingManager {
    private static final int LOOP_START_NUMBER = 0;
    private static final int MINIMUM_TRY_COUNT = 1;
    private static final int MAX_COUNT_INITIAL_NUMBER = 0;

    private final RacingPrinter racingPrinter = new ConsoleRacingPrinter();
    private final RacingReceiver racingReceiver = new ConsoleRacingReceiver();

    private List<RacingCar> racingCars = new ArrayList<>();
    private List<String> winners = new ArrayList<>();

    public void run() {
        racingPrinter.requestInputRacingCarName();
        String[] partedName = splitByComma(racingReceiver.receive());
        for (String name : partedName) {
            racingCars.add(new RacingCar(name));
        }

        racingPrinter.requestInputTryCount();
        int tryCount = validateTryCount(racingReceiver.receive());

        racingPrinter.noticeResult();
        for (int i = LOOP_START_NUMBER; i < tryCount; i++) {
            race();
            racingPrinter.printLine();
        }
        decideWinner();
        racingPrinter.noticeWinner(winners);

    }

    public void race() {
        for (RacingCar racingCar : racingCars) {
            racingCar.moveOrStop();
            racingPrinter.printResultDetail(racingCar);
        }
    }

    private String[] splitByComma(String names) {
        return names.split(",");
    }

    private int validateTryCount(String tryCount) {
        try {
            int numberedTryCount = Integer.parseInt(tryCount);
            if (numberedTryCount < MINIMUM_TRY_COUNT) {
                throw new IllegalArgumentException();
            }
            return numberedTryCount;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void decideWinner() {
        int maxCount = findMaxCount();

        for (RacingCar racingCar : racingCars) {
            isWinner(racingCar, maxCount);
        }
    }

    private void isWinner(RacingCar racingCar, int maxCount) {
        if (racingCar.getMoveCount() == maxCount) {
            winners.add(racingCar.getName());
        }
    }

    private int findMaxCount() {
        int maxCount = MAX_COUNT_INITIAL_NUMBER;
        for (RacingCar racingCar : racingCars) {
            maxCount = Math.max(racingCar.getMoveCount(), maxCount);
        }

        return maxCount;
    }

}
