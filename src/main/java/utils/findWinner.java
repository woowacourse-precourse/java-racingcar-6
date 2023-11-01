package utils;

import java.util.ArrayList;

public class findWinner {
    public static ArrayList<String> getMostMovedCar(ArrayList<String> carDistanceList) {
        String longestDistance = "";
        ArrayList<String> mostMovedCar = new ArrayList<>();

        for (String carInfo : carDistanceList) {
            char separator = ':';

            int separatorIndex = carInfo.indexOf(separator);
            String carNameString = carInfo.substring(0, separatorIndex - 1);
            String distanceString = carInfo.substring(separatorIndex + 2, carInfo.length());

            if (longestDistance.length() < distanceString.length()) {
                mostMovedCar.clear();
            }
            if (longestDistance.length() <= distanceString.length()) {
                longestDistance = distanceString;
                mostMovedCar.add(carNameString);
            }
        }
        return mostMovedCar;
    }

    public static String getRaceResult(ArrayList<String> carDistanceList) {
        ArrayList<String> mostMovedCarName = getMostMovedCar(carDistanceList);

        String winnerName= "";
        for (String carName : mostMovedCarName) {
            if (!winnerName.isEmpty()) {
                winnerName = winnerName.concat(", " + carName);
            } else {
                winnerName = winnerName.concat(carName);
            }
        }
        return "최종 우승자 : " + winnerName;
    }
}
