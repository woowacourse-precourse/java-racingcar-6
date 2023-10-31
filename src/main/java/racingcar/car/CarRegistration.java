package racingcar.car;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.model.Car;
import racingcar.car.model.CarName;
import racingcar.car.model.RacingCar;
import racingcar.utils.ErrorMessage;
import racingcar.utils.StringValidator;

public class CarRegistration {
    private static final int MIN_CAR_NAME_LENGTH = 2;
    private static final String DELIMITER = ",";

    private final List<Car> participantList;


    private void validateCarListLength(String[] splitCarName) throws IllegalArgumentException {
        if (splitCarName.length < MIN_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.MINIMUM_CAR_NEEDED);
        }
    }

    private List<CarName> generateCarNameList(String[] splitCarName) throws IllegalArgumentException {
        List<CarName> carNameList = new ArrayList<>();
        for (String carName : splitCarName) {
            carNameList.add(new CarName(carName));
        }
        return carNameList;
    }

    private List<CarName> nameRegistration(String inputCarNames) throws IllegalArgumentException {

        if (StringValidator.isBlank(inputCarNames)) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_IS_BLANK);
        }

        String[] splitCarName = inputCarNames.split(DELIMITER);
        validateCarListLength(splitCarName);

        return generateCarNameList(splitCarName);
    }


    public CarRegistration(String inputCarNames) throws IllegalArgumentException {
        List<CarName> carNameList = nameRegistration(inputCarNames);

        participantList = new ArrayList<>();
        for (CarName carName : carNameList) {
            participantList.add(new RacingCar(carName));
        }
    }

    public List<Car> getRaceParticipants() {
        return participantList;
    }

    @Override
    public String toString() {
        return "CarRegistration{" +
                "participantList=" + participantList +
                '}';
    }
}
