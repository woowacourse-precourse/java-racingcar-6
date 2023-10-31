package racingcar.printer;

import racingcar.car.RacingCar;

import java.util.List;

public class ConsoleRacingPrinter implements RacingPrinter {
    private static final int LOOP_START_NUMBER = 0;
    private static final int NEXT_INDEX = 1;

    @Override
    public void requestInputRacingCarName() {
        System.out.println(PrintMessage.REQUEST_INPUT_RACING_CAR_NAME.getValue());
    }

    @Override
    public void requestInputTryCount() {
        System.out.println(PrintMessage.REQUEST_INPUT_TRY_COUNT.getValue());
    }

    @Override
    public void noticeResult() {
        System.out.println(PrintMessage.NOTICE_RESULT.getValue());
    }

    @Override
    public void printResultDetail(RacingCar racingCar) {
        System.out.print(racingCar.getName() + PrintMessage.COLON.getValue());
        for (int i = LOOP_START_NUMBER; i < racingCar.getMoveCount(); i++) {
            System.out.print(PrintMessage.DASH.getValue());
        }
        System.out.println();
    }

    @Override
    public void printLine() {
        System.out.println();
    }

    @Override
    public void noticeWinner(List<String> racingCars) {
        System.out.print(PrintMessage.NOTICE_WINNER.getValue());
        for (int i = LOOP_START_NUMBER; i < racingCars.size(); i++) {
            System.out.print(racingCars.get(i));

            if (i + NEXT_INDEX != racingCars.size()) {
                System.out.print(PrintMessage.COMMA.getValue());
            }
        }
    }
}
