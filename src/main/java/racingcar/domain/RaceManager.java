package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static racingcar.constant.CarForwordConstant.MINIMUM_DICE_VALUE;
import static racingcar.constant.GameResultMessageConstant.EXECUTION_RESULT;

public class RaceManager {

    private final RaceEntry raceEntry;
    private final int forwardCount;
    private final ViewMaker viewMaker;
    private final StringBuilder resultStringBuilder;

    public RaceManager(RaceEntry raceEntry, int forwardCount) {
        this.raceEntry = raceEntry;
        this.forwardCount = forwardCount;
        viewMaker = new ViewMaker();
        resultStringBuilder = new StringBuilder();
    }

    public void doRace() {
        List<Car> entryList = raceEntry.getRaceEntryList();
        resultStringBuilder.append(EXECUTION_RESULT);

        for (int i = 0; i < forwardCount; i++) {

            for (Car car : entryList) {
                if (isCarCanForward()) {
                    car.forward();
                }

                String currentCarName = car.getName();
                int currentCarPosition = car.getCurrentPosition();
                resultStringBuilder.append(viewMaker.makeCurrentPositionView(currentCarName, currentCarPosition));
            }

            resultStringBuilder.append("\n");
        }

        resultStringBuilder.append(viewMaker.makeWinnerView(entryList));
    }

    private boolean isCarCanForward() {
        int dice = Randoms.pickNumberInRange(0, 9);
        return dice >= MINIMUM_DICE_VALUE;
    }

    public String getRaceResult() {
        return resultStringBuilder.toString();
    }
}
