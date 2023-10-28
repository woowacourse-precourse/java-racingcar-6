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

    public boolean saveName(String userCarName)
    {
        String[] splitedName = cutName(userCarName);
        makeLinkedHashMap(splitedName);
        return ValidationMan.getInstance().checkException(carName, splitedName.length);
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

    public boolean exceptionCheck(String userTimes)
    {
        return ValidationMan.getInstance().checkException(userTimes);
    }

    public void changeStatus()
    {
        GameChanger.getInstance().changeGame(carName,NumberGenerator.numberGenerate(carName.size()));
    }

    public List<String> getWinner()
    {
        return Winners.judgeWinner(carName);
    }


}
