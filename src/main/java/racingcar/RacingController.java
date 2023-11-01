package racingcar;

import java.util.List;

public class RacingController {

    private final Racing racing = new Racing();

    void setRacingCarName(String inputNames) {
        String[] splitNames = inputNames.split(",");
        racing.initParticipants(splitNames);
    }

    void setRacingPlayCount(int playCount) {
        racing.initPlayCount(playCount);
    }

    List<String> getRacingPlayResults() {
        return racing.getPlayResults();
    }

    List<String> getWinners() {
        return racing.getWinnerNames();
    }

}
