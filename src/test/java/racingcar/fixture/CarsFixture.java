package racingcar.fixture;

import java.util.List;

import static racingcar.fixture.NameFixture.*;

public enum CarsFixture {

    // VALID
    CAR_NAMES_LIST(
            List.of(
                    VALID_NAME_1.getName(),
                    VALID_NAME_2.getName(),
                    VALID_NAME_3.getName()
            )
    ),

    // INVALID
    DUPLICATED_CAR_NAMES_LIST(
            List.of(
                    VALID_NAME_1.getName(),
                    VALID_NAME_1.getName()
            )
    );

    private final List<String> carNamesList;

    CarsFixture(List<String> carNamesList) {
        this.carNamesList = carNamesList;
    }

    public List<String> getCarNamesList() {
        return carNamesList;
    }
}
