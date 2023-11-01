package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {
    private ArrayList<String> result;

    private RaceResult(ArrayList<String> result) {
        this.result = result;
    }

    public static RaceResult resultString(ArrayList<Car> cars){
        ArrayList<String> result = new ArrayList<>();

        for (Car car : cars) {
            StringBuilder stringBuilder = new StringBuilder();
            String carName = car.getName();
            String carPosition = "-".repeat(car.getPosition());
            stringBuilder.append(carName).append(" : ").append(carPosition);

            result.add(stringBuilder.toString());
        }

        return new RaceResult(result);
    }

    public String raceToString(){
        return String.join("\n", result);
    }

    public static String winnerToString(ArrayList<Car> cars){
        StringBuilder stringBuilder = new StringBuilder("최종 우승자 : ");
        int maxPosition = -1;
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            int carPosition = car.getPosition();

            if (carPosition > maxPosition) {
                maxPosition = carPosition;
                winners.clear();
                winners.add(car.getName());
            } else if (carPosition == maxPosition) {
                winners.add(car.getName());
            }
        }

        stringBuilder.append(String.join(", ", winners));
        return stringBuilder.toString();
    }


}
