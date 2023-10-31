package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Map;

public class Output {
    public int randomNumber() {
        int randNum = Randoms.pickNumberInRange(0, 9);
        return randNum;
    }

    public void totalPrint(Map<String, Integer> parkingLot, String[] carlist) {
        for (int i = 0; i < parkingLot.size(); i++) {
            routePrint(carlist[i], parkingLot.get(carlist[i]));
        }
        System.out.println();
    }

    public void routePrint(String carName, int carDistance) {
        String distance = "";
        for (int i = 0; i < carDistance; i++) {
            distance += "-";
        }
        System.out.println(carName + " : " + distance);
    }

    public String winner(Map<String, Integer> parkinglot, String[] car_name) {
        String result = "최종 우승자 : ";
        String champion = "";
        int champion_distance = 0;
        for (int i = 0; i < car_name.length; i++) {
            if (champion_distance < parkinglot.get(car_name[i])) {
                champion_distance = parkinglot.get(car_name[i]);
                champion = car_name[i];
            } else if (champion_distance == parkinglot.get(car_name[i]) && champion.equals("")) {
                champion += car_name[i];
            } else if (champion_distance == parkinglot.get(car_name[i])) {
                champion = champion + ", " + car_name[i];
            }
        }
        result += champion;
        return result;
    }
}