package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCarsList{
    private final static String spaceString = " ";
    private final static String blankString = "";
    private final static String commaString = ",";
    private List<RacingCar> racingCarsList = new ArrayList<>();

    RacingCarsList(String racingCarsNameString){
        setRacingCarsList(racingCarsNameString);
    }

    private void setRacingCarsList(String racingCarsNameString) {
        List<String> racingCarsNameList = makeRacingCarsNameList(racingCarsNameString);
        addRacingCarsList(racingCarsNameList);
    }

    private List<String> makeRacingCarsNameList(String racingCarsNameString) {
        return Arrays.asList(racingCarsNameString.replace(spaceString, blankString).split(commaString));
    }

    private void addRacingCarsList(List<String> racingCarsNameList) {
        for (int i = 0; i < racingCarsNameList.size(); ++i) {
            String racingCarName = racingCarsNameList.get(i);
            racingCarsList.add(new RacingCar(racingCarName));
        }
    }
}
