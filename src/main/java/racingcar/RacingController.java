package racingcar;

public class RacingController {

    private final Racing racing = new Racing();

    void setRacingCarName(String inputNames) {
        String[] splitNames = inputNames.split(",");
        racing.initParticipants(splitNames);
    }

    void setRacingPlayCount(int playCount) {
        racing.initPlayCount(playCount);
    }

}
