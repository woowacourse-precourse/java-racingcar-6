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
    public static boolean validateRandomMoreFour() {
        int randomNumber = Randoms.pickNumberInRange(0,9);
        return randomNumber >= 4;
    }
    public static List<Integer> validateRacingResult(List<String>carName, List<Integer>raceResult) {
        for(int i = 0; i < carName.size(); i++) {
            if (validateRandomMoreFour()) {
                raceResult.set(i, raceResult.get(i) + 1);
            }
        }
        return raceResult;
    }
    public static List<String> validateRacingWinner(List<String>carName, List<Integer>raceResult) {
        int WinnerResult = Collections.max(raceResult);
        List<String>loser = new ArrayList<>();
        for(int i = 0; i < carName.size(); i++) {
            if(raceResult.get(i) < WinnerResult) {
                loser.add(carName.get(i));
            }
        }
        carName.removeAll(loser);
        return carName;
    }
}
