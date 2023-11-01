package utils;

import java.util.ArrayList;

public class carRaceLog {
    // 참가자 리스트 생성
    public static ArrayList<String> initCarDistanceList(String carNameInput) {
        ArrayList<String> carDistanceList = new ArrayList<>();
        String [] carNames = carNameInput.split(",");

        for (String carName : carNames) {
            if (!carName.isEmpty()) {
                carDistanceList.add(carName.trim() + " : ");
            }
        }
        return carDistanceList;
    }

    // 결과 업데이트
    public static ArrayList<String> updateCarDistanceList (int index, ArrayList<String> carDistanceList) {
        String currentDistance = carDistanceList.get(index);
        carDistanceList.set(index, currentDistance + "-");
        return carDistanceList;
    }
}
