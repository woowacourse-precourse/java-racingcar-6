package racingcar.printer;

import racingcar.car.RacingCar;

public class ConsoleRacingPrinter implements RacingPrinter {
    private static final Integer LOOP_START_NUMBER = 0;

    @Override
    public void requestInputRacingCarName() {
        System.out.println(PrintMessage.REQUEST_INPUT_RACING_CAR_NAME);
    }

    @Override
    public void requestInputTryCount() {
        System.out.println(PrintMessage.REQUEST_INPUT_TRY_COUNT);
    }

    @Override
    public void noticeResult() {
        System.out.println(PrintMessage.NOTICE_RESULT);
    }

    @Override
    public void printResultDetail(RacingCar racingCar) {
        System.out.print(racingCar.getName() + PrintMessage.COLON);
        for (int i = LOOP_START_NUMBER; i < racingCar.getMoveCount(); i++) {
            System.out.println(PrintMessage.DASH);
        }
        System.out.println();
    }
}
