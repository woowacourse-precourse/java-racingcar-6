package racingcar;

import java.util.List;
import java.util.TreeSet;

public class RacingCar implements Comparable {
    String name;
    int advance;

    public RacingCar (String name) {
        this.name = name;
        this.advance = 0;
    }

    public void goForward () {
        this.advance++;
    }

    //		public static 메서드
    public static TreeSet<RacingCar> createRacingCarSetFromParticipantList (List<String> names) {
        TreeSet<RacingCar> participants = new TreeSet<>();

        for (String name : names) {
            RacingCar applicant = new RacingCar(name);
            participants.add(applicant);
        }

        return participants;
    }

    @Override
    public int compareTo (Object o) {
        RacingCar competitor = (RacingCar) o;

        if(name.equals(competitor.name)) {
            return 0;
        }

        if(competitor.advance < this.advance) {
            return -1;
        } else {
            return 1;
        }

    }
}