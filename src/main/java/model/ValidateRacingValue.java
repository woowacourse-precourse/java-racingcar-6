package model;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ValidateRacingValue {
    public static List<String> carNameInputToList(String carNameBundle) {
        String[] carNameArray = carNameBundle.split(",");
        List<String> listCarName = new ArrayList<>(Arrays.asList(carNameArray));
        return listCarName;
    }
    public static List<Integer> raceResultListReset(int carNameSize, List<Integer> raceResult) {
        for(int i = 0; i < carNameSize; i++) {
            raceResult.add(i, 0);
        }
        return raceResult;
    }

}
