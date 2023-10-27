package racingmodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class GameChanger {
    private final static int GO_NUMBER = 4;

    private GameChanger() {
    }

    private final static GameChanger singleChanger = new GameChanger();

    static GameChanger getInstance() {
        return singleChanger;
    }

    void changeGame(LinkedHashMap<String, StringBuilder> car,
                    List<Integer> generatedNumbers) {
        Iterator temp = generatedNumbers.iterator();

        for (Map.Entry<String, StringBuilder> entry : car.entrySet()) {
            if (changeStatus(getNumber(temp)) == GoOrNot.GO) {
             car.put(entry.getKey(), entry.getValue().append("-"));
            }
        }
    }

    int getNumber(Iterator<Integer> temp)
    {
        if(temp.hasNext())
        {
            return temp.next();
        }
    }

    private GoOrNot changeStatus(int generatedNumber) {
        if (generatedNumber >= GO_NUMBER) {
            return GoOrNot.GO;
        }
        return GoOrNot.NOTGO;
    }
}
