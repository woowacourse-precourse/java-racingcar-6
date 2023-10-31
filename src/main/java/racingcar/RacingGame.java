package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class RacingGame {
    private List<Racer> racers;
    private final int timesOfTurn;

    public RacingGame() {
        System.out.println(Messages.PLEASE_INPUT_RACERS);
        String racerNames = Console.readLine();
        if (racerNames == null) {
            throw new IllegalArgumentException("Null Input (initial racer names)");
        }

        List<String> racerNameList = sanitizeRacerNames(racerNames);

        this.racers = racerNameList.stream().map(Racer::new).toList();

        System.out.println(Messages.PLEASE_INPUT_TURNS);
        String turnInput = Console.readLine();

        try {
            this.timesOfTurn = Integer.parseInt(turnInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("illegal number");
        }

        Console.close();
    }

    public void play() {
        System.out.println(Messages.RACING_RESULT);
        for (int i = 0; i < timesOfTurn; i++) {
            racers.forEach(Racer::proceedTurn);
            System.out.println();
        }

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
        
        String result = MessageFormat.format("최종 우승자 : {0}", String.join(",", winners));
        System.out.println(result);
    }

    private static List<String> sanitizeRacerNames(String racerNames) {
        List<String> racerNameList = List.of(racerNames.split(",", -1));
        HashSet<String> duplicateCheckSet = new HashSet<>();
        for (String racerName : racerNameList) {
            if (racerName.isBlank() || racerName.isEmpty()) {
                throw new IllegalArgumentException("illegal racer name");
            }
            if (!duplicateCheckSet.add(racerName)) {
                throw new IllegalArgumentException("duplicated Name");
            }
            if (racerName.length() > 5) {
                throw new IllegalArgumentException("Too long name (racer)");
            }
        }
        return racerNameList;
    }
}
