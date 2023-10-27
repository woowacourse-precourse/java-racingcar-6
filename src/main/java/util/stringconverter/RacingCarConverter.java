package util.stringconverter;

import racingcar.RacingCarPlayer;

public class RacingCarConverter implements StringConverter<RacingCarPlayer> {
    @Override
    public String toString(RacingCarPlayer object) {
        return object.getCarName();
    }

    @Override
    public RacingCarPlayer fromString(String string) {
        return new RacingCarPlayer(string, 0);
    }
}
