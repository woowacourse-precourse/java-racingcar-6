package racingcar.Model;

import java.util.ArrayList;
import java.util.List;
import racingcar.Utils.GameConstants;

public class CarsList {
    private List<Car> carsList = new ArrayList<>();

    public CarsList() {

    }

    public List<Car> getCarsList(String[] texts) {
        createCarsList(texts);
        return carsList;
    }

    public void createCarsList(String[] texts) {
        for (String text : texts) {
            if (text.length() > GameConstants.MAX_NAME_COUNT || text.length() == 0) {
                throw new IllegalArgumentException();
            }

            carsList.add(new Car(text));
        }
    }
}
