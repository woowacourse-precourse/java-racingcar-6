package racingcar.domain;

import java.util.List;

import static racingcar.constant.GameResultConstant.EXECUTION_RESULT;

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
                String currentCarName = car.getName();
                int currentCarPosition = car.forward();
                resultStringBuilder.append(viewMaker.makeCurrentPositionView(currentCarName, currentCarPosition));
            }

            resultStringBuilder.append("\n");
        }

        resultStringBuilder.append(viewMaker.makeWinnerView(entryList));
    }

    public String getRaceResult() {
        return resultStringBuilder.toString();
    }
}
