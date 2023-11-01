package racingcar.result;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.RacingCar;

public class Result {

    private List<RacingCar> result;

    public Result() {
        result = new ArrayList<>();
    }

    private Result(List<RacingCar> result) {
        this.result = result;
    }

    public void add(RacingCar racingCar) {
        result.add(racingCar);
    }

    public Result findWinners() {
        List<RacingCar> winners = new ArrayList<>();
        int maxPosition = 0;

        for (RacingCar racingCar : result) {
            int position = racingCar.getPosition();

            if (position > maxPosition) {
                maxPosition = position;
                winners.clear();
                winners.add(racingCar);
            } else if (position == maxPosition) {
                winners.add(racingCar);
            }
        }

        return new Result(winners);
    }

    public List<String> getNames() {
        return result.stream()
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (RacingCar racingCar : result) {
            stringBuilder.append(racingCar).append("\n");
        }

        return stringBuilder.toString();
    }
}
