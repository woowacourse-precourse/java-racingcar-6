package racingmodel;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import util.NumberGenerator;
import validation.ValidationMan;

public class MainModel {
    private LinkedHashMap<String, StringBuilder> carName = null;

    public MainModel() {
        carName = new LinkedHashMap<String, StringBuilder>();
    }

    public LinkedHashMap<String, StringBuilder> getCarName() {
        return carName;
    }

    public void saveName(String userCarName)
    {
        String[] splitedName = cutName(userCarName);
        makeLinkedHashMap(splitedName);
        ValidationMan.getInstance().checkException(carName, splitedName.length);
    }

    private String[] cutName(String userCarName)
    {
        return userCarName.split(",");
    }

    private void makeLinkedHashMap(String[] userCarName)
    {
        for(String i : userCarName)
        {
            carName.put(i, new StringBuilder(""));
        }
    }

    public void exceptionCheck(String userTimes)
    {
        ValidationMan.getInstance().checkException(userTimes);
    }

    public void changeStatus()
    {
        GameChanger.getInstance().changeGame(carName,NumberGenerator.numberGenerate(carName.size()));
    }

    public List<String> getWinner()
    {
        List<String> winners = new ArrayList<>();
        int maxScore = 0;
        for (Map.Entry<String, StringBuilder> entry : carName.entrySet()) {
            String player = entry.getKey();
            StringBuilder score = entry.getValue();
            int length = score.length();
            if (length > maxScore) {
                maxScore = length;
                winners.clear();
                winners.add(player);
            }
            else if (length == maxScore) {
                winners.add(player);
            }
        }
        return winners;
    }

}
