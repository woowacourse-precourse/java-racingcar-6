package racingcar.controller;

import java.util.ArrayList;

public class controllerWhoWin {
    private final String searchChar = "-";
    public ArrayList<String> controllerWhoWin(String[] simulationStr, String[] carNameArray){

        int[] countArray = new int[carNameArray.length];
        for (int i=0;i<simulationStr.length;i++){
            String replaceString = simulationStr[i].replace(searchChar, "");
            int count = simulationStr[i].length() - replaceString.length();
            countArray[i] = count;
        }
        int maxCount = 0;
        ArrayList<String> maxCarName = new ArrayList<String>();
        for (int i=0; i<carNameArray.length;i++){
            if (maxCount < countArray[i]){
                maxCarName.clear();
                maxCarName.add(carNameArray[i]);
                maxCount = countArray[i];
            } else if (maxCount == countArray[i]) {
                maxCarName.add(carNameArray[i]);
            }
        }
        return maxCarName;
    }
}
