package racingcar.validation;

import racingcar.model.Driver;

import java.util.ArrayList;
import java.util.List;

public class ValidationService {

    public List<Driver> inputToDriverList(String driverInputString) {
        String[] driversName = driverInputString.split(",");

        validateInput(driversName);

        return createDriverList(driversName);
    }

    private List<Driver> createDriverList(String[] driversName) {
        List<Driver> driverList = new ArrayList<>();
        for (String driverName : driversName) {
            driverList.add(new Driver(driverName, 0));
        }
        return driverList;
    }

    private void validateInput(String[] driversName) {
        for (String driverName : driversName) {
            validateInputMore5Character(driverName);
            validateInputIsBlank(driverName);
        }
    }

    private void validateInputMore5Character(String driverName) {
        if (driverName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateInputIsBlank(String driverName) {
        if (driverName.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
}
