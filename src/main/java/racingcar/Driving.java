package racingcar;

import static racingcar.CarFactory.getProductionQuantity;
import static racingcar.MessageManager.getRaceResultMessage;

import java.util.ArrayList;
import java.util.List;

public class Driving {
    public static void drive(MyCar[] objects) {
        for (int i = 0; i < getProductionQuantity(); i++) {
            objects[i].builderForward();
            System.out.println(objects[i]);
        }
    }

    public static MyCar[] race(int inputCount, MyCar[] objects) {
        getRaceResultMessage();
        for (int i = 0; i < inputCount; i++) {
            drive(objects);
            System.out.println();
        }
        return objects;
    }

    public static void raceWinner(int inputCount, MyCar[] objects) {
        MyCar[] finishRaceCars = race(inputCount, objects);
        int maxForwardCount = Integer.MIN_VALUE;
        List<String> winnerNames = new ArrayList<>();

        for (int i = 0; i < getProductionQuantity(); i++) {
            int forwardCount = finishRaceCars[i].getForwardCount();

            if (forwardCount > maxForwardCount) {
                maxForwardCount = forwardCount;
                winnerNames.clear();
                winnerNames.add(finishRaceCars[i].getCarName());
            } else if (forwardCount == maxForwardCount) {
                winnerNames.add(finishRaceCars[i].getCarName());
            }
        }
        System.out.print("최종 우승자 : ");
        String winners = String.join(", ", winnerNames);
        System.out.println(winners);
    }
}
