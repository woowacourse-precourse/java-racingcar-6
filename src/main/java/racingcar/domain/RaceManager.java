package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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
        List<String> winners = makeWinnerList(entryList);
        resultStringBuilder.append(viewMaker.makeWinnerView(winners));
    }

    public List<String> makeWinnerList(List<Car> entryList) {
        Car WinnerCar = entryList.stream().
                max(Comparator.comparingInt(Car::getCurrentPosition)).
                orElseThrow(NoSuchElementException::new);

        return entryList.stream().
                filter(car -> car.getCurrentPosition() == WinnerCar.getCurrentPosition()).
                map(Car::getName).
                collect(Collectors.toList());
    }

    private boolean isCarCanForward() {
        int dice = Randoms.pickNumberInRange(0, 9);
        return dice >= MINIMUM_DICE_VALUE;
    }

    public String getRaceResult() {
        return resultStringBuilder.toString();
    }
}
