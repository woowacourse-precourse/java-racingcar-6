package racingcar;

import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;

public class Referee {
    private Referee() {
    }

    public static void sayWinners(List<Racer> racers) {
        int maxPosition = 0;
        List<String> winners = new LinkedList<>();

        for (Racer racer : racers) {
            if (racer.getCurrentPosition() > maxPosition) {
                maxPosition = racer.getCurrentPosition();
            }
        }

        for (Racer racer : racers) {
            if (racer.getCurrentPosition() >= maxPosition) {
                winners.add(racer.getName());
            }
        }

        String result = MessageFormat.format("{0} : {1}", Messages.WINNER_IS, String.join(",", winners));
        System.out.println(result);
    }
}
