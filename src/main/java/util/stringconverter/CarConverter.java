package util.stringconverter;

import racingcar.model.CarPlayerModel;

public class CarConverter implements StringConverter<CarPlayerModel> {
    @Override
    public String toString(CarPlayerModel object) {
        return object.getCarName();
    }

    @Override
    public CarPlayerModel fromString(String string) {
        return new CarPlayerModel(string);
    }
}
