package racingcar;

import java.util.ArrayList;
import java.util.List;
import org.junit.platform.commons.util.StringUtils;

public class CarNameRegistration {
    private static final int MIN_CAR_NAME_LENGTH = 2;
    private static final String splitChar = ",";

    private List<CarName> carNameList;

//    public CarNameRegistration() {
//        carNameList = new ArrayList<>();
//    }
    public CarNameRegistration(String inputCarNames) throws IllegalArgumentException {
        carNameList = new ArrayList<>();
        // static import 가능?
        if (StringUtils.isBlank(inputCarNames)) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_IS_BLANK);
        }
        String[] splitCarName = inputCarNames.split(splitChar);
        validateInputCarName(splitCarName);
        addToCarNameList(splitCarName);
    }

    private void validateInputCarName(String[] splitCarName) throws IllegalArgumentException {
        if (splitCarName.length < MIN_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.MINIMUM_CAR_NEEDED);
        }
    }

    private void addToCarNameList(String[] splitCarName) throws IllegalArgumentException {
        carNameList = new ArrayList<>();
        for (String carName : splitCarName) {
            carNameList.add(new CarName(carName));
        }
    }


    public List<CarName> getCarNameList() {
        return carNameList;
    }


}
