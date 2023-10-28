package racingcar.Model.Car;

import Config.AppConfig;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarName {

    private final String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }
    private void validateName(String carName){
        Pattern pattern = Pattern.compile(AppConfig.CAR_NAME_FORMAT);
        Matcher matcher = pattern.matcher(carName);
        if (matcher.matches()){
            return;
        }
        throw new IllegalArgumentException();
    }

    public String getName() {
        return name;
    }
}
