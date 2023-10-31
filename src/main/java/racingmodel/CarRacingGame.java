package racingmodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import util.NumberGenerator;

public class CarRacingGame {
    private LinkedHashMap<String, StringBuilder> carName = null;
    static int GO_NUMBER = 4;

    public CarRacingGame(LinkedHashMap<String, StringBuilder> carName) {
        this.carName = carName;
    }

    public LinkedHashMap<String, StringBuilder> getCarName() {
        return new LinkedHashMap<>(carName);
    }

    public void changeGame() {
        Iterator<Integer> temp = NumberGenerator.numberGenerate(carName.size()).iterator();
        carName.forEach((key, value) -> {
            if (changeStatus(getNumber(temp)) == GoOrNot.GO) {
            carName.put(key, value.append("-"));
        }});
    }

    private int getNumber(Iterator<Integer> temp) {
        if (temp.hasNext()) {
            return temp.next();
        }
        return -1;
    }

    private GoOrNot changeStatus(int generatedNumber) {
        if (generatedNumber >= GO_NUMBER) {
            return GoOrNot.GO;
        }
        return GoOrNot.NOTGO;
    }
}

