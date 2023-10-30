package racingmodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import util.NumberGenerator;

public class CarRacingGame {
    private LinkedHashMap<String, StringBuilder> carName = null;

    public CarRacingGame(LinkedHashMap<String, StringBuilder> carName) {
        this.carName = carName;
    }

    public LinkedHashMap<String, StringBuilder> getCarName() {
        return new LinkedHashMap<>(carName);
    }

    public void changeStatus() {
        GameChanger.changeGame(carName, NumberGenerator.numberGenerate(carName.size()));
    }

    /**
     * 게임의 상황을 바꾸는 책임을 가지고 있는 클래스입니다.
     */
    class GameChanger {
        private final static int GO_NUMBER = 4;

        private GameChanger() {
        }

        static void changeGame(LinkedHashMap<String, StringBuilder> car,
                               List<Integer> generatedNumbers) {
            Iterator temp = generatedNumbers.iterator();

            for (Map.Entry<String, StringBuilder> entry : car.entrySet()) {
                if (changeStatus(getNumber(temp)) == GoOrNot.GO) {
                    car.put(entry.getKey(), entry.getValue().append("-"));

                }
            }
        }

        private static int getNumber(Iterator<Integer> temp) {
            if (temp.hasNext()) {
                return temp.next();
            }
            return -1;
        }

        private static GoOrNot changeStatus(int generatedNumber) {
            if (generatedNumber >= GO_NUMBER) {
                return GoOrNot.GO;
            }
            return GoOrNot.NOTGO;
        }
    }
}
