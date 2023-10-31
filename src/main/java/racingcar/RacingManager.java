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

    private final RacingPrinter racingPrinter = new ConsoleRacingPrinter();
    private final RacingReceiver racingReceiver = new ConsoleRacingReceiver();

    private List<RacingCar> racingCars = new ArrayList<>();

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
            if (numberedTryCount < 1) {
                throw new IllegalArgumentException();
            }
            return numberedTryCount;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

}
