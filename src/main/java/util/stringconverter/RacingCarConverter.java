package util.stringconverter;

import racingcar.model.RacingCarPlayerModel;

public class RacingCarConverter implements StringConverter<RacingCarPlayerModel> {
    @Override
    public String toString(RacingCarPlayerModel object) {
        return object.getCarName();
    }

    @Override
    public RacingCarPlayerModel fromString(String string) {
        return new RacingCarPlayerModel(string);
    }
}
