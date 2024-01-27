package game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InGame {

    Map<String, Integer> carsMap = null;

    public InGame(Map<String, Integer> carsMap) {
        this.carsMap = carsMap;
    }

    public void addCarsMapStep() {
        for (String car : carsMap.keySet()) {
            addCarStep(car);
        }
    }

    public String getStepString (String carName) {

        StringBuffer sb = new StringBuffer();
        int step = carsMap.get(carName);

        sb.append("-".repeat(step));

        return sb.toString();
    };

    public int getMaxStep () {

        int maxStep = 0;
        for(String key : carsMap.keySet()) {
            maxStep = Math.max(maxStep, carsMap.get(key));
        }

        return maxStep;
    }

    public String[] getFinalWinner (int maxStep) {

        List<String> winnerList = new ArrayList<>();

        for(String key : carsMap.keySet()) {
            addWinnerAtList(key, maxStep, winnerList);
        }

        return winnerList.toArray(new String[0]);
    }




    private void addCarStep(String car) {
        int randonNum = Randoms.pickNumberInRange(0, 9);
        if(randonNum >= 4)
            carsMap.put(car, carsMap.get(car) + 1);
    }

    private void addWinnerAtList (String car, int maxStep, List<String> winnerList) {
        if(carsMap.get(car) == maxStep)
            winnerList.add(car);
    }
}
