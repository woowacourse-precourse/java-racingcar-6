package racingcar;

import static constant.Constant.ATTEMPTS_NUMBER_REQUEST_MESSAGE;
import static constant.Constant.CAR_NAME_REQUEST_MESSAGE;
import static constant.Constant.RUN_RESULT_START_MESSAGE;
import static constant.Constant.WINNER_RESULT_MESSAGE;

import basis.Converter;
import basis.MovingStatus;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Application {
    static Converter converter = new Converter();
    static MovingStatus movingStatus = new MovingStatus();

    public static void main(String[] args) {
        System.out.println(CAR_NAME_REQUEST_MESSAGE);
        String carName = Console.readLine();
        Map<String, String> carNameHashMap = converter.putHashMap(carName);
        System.out.println(ATTEMPTS_NUMBER_REQUEST_MESSAGE);
        String attemptsString = Console.readLine();
        int attemptsNumber = converter.wordToInt(attemptsString);
        System.out.println();
        System.out.println(RUN_RESULT_START_MESSAGE);

        for (int i = 0; i < attemptsNumber; i++) {
            for (Entry<String, String> element : carNameHashMap.entrySet()) {
                String move = movingStatus.decideMove();
                String originalValue = element.getValue();
                String newValue = originalValue + move;
                carNameHashMap.put(element.getKey(), newValue);
                System.out.println(element.getKey() + " : " + element.getValue());
            }
            System.out.println("");
        }

        int largestMove = 0;
        for (Entry<String, String> element : carNameHashMap.entrySet()) {
            int moveLength = element.getValue().length();
            if (moveLength > largestMove) {
                largestMove = moveLength;
            }
        }

        List<String> winnerList = new ArrayList<>();
        for (Entry<String, String> element : carNameHashMap.entrySet()) {
            int moveLength = element.getValue().length();
            if (moveLength == largestMove) {
                winnerList.add(element.getKey());
            }
        }

        System.out.print(WINNER_RESULT_MESSAGE);
        for (int i = 0; i < winnerList.size(); i++) {
            System.out.print(winnerList.get(i));
            if (winnerList.size() > 1) {
                System.out.print(", ");
            }
        }
    }
}
