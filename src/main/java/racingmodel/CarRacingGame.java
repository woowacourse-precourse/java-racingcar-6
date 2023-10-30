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

    public List<String> getWinner() {
        return Winners.judgeWinner(carName);
    }

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

    class Winners {

        private Winners() {
        }

        static List<String> judgeWinner(LinkedHashMap<String, StringBuilder> carName) {
            List<String> winners = new ArrayList<>();
            int maxScore = 0;
            for (Map.Entry<String, StringBuilder> entry : carName.entrySet()) {
                changeWinner(winners, entry.getKey(), entry.getValue().length(), maxScore);
            }
            return winners;
        }

        private static void changeWinner(List<String> winners, String player, int length, int maxScore) {
            SaveWinner winnerStatus = judgeNewOrAddOtNot(length, maxScore);

            if (winnerStatus == SaveWinner.ADD_WINNER) {
                winners.add(player);
            } else if (winnerStatus == SaveWinner.NEW_WINNER) {
                winners.clear();
                winners.add(player);
            }
        }

        private static SaveWinner judgeNewOrAddOtNot(int length, int maxScore) {
            if (length > maxScore) {
                return SaveWinner.NEW_WINNER;
            } else if (length == maxScore) {
                return SaveWinner.ADD_WINNER;
            }
            return SaveWinner.NOT;
        }
    }
}
