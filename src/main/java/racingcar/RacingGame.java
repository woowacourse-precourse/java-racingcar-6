package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.List;

public class RacingGame {
    private List<Racer> racers;
    private int timesOfTurn;

    public RacingGame() {
        String racerNames = Console.readLine();
        if (racerNames == null) {
            throw new IllegalArgumentException("Null Input (initial racer names)");
        }

        List<String> racerNameList = sanitizeRacerNames(racerNames);

        this.racers = racerNameList.stream().map(Racer::new).toList();

        String turnInput = Console.readLine();

        try {
            this.timesOfTurn = Integer.parseInt(turnInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("illegal number");
        }

        Console.close();
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
