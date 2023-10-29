package racingcar;

import java.util.ArrayList;
import java.util.List;

public class User {

    public List<String> carNames = new ArrayList<>();

    public void carNameSplit(String userInput){
        String[] carNameArray = userInput.split(",");

        for(String carName : carNameArray) {
            carNames.add(carName.trim());
        }
    }

}
