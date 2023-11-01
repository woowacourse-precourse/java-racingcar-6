package racingcar.view;

import static racingcar.view.Print.ASKING_CAR_NAME;
import static racingcar.view.Print.ASKING_NUMBER_OF_TRIAL;
import static racingcar.view.Print.RACE_RESULT;
import static racingcar.view.Print.FINAL_WINNERS;

import racingcar.dto.RaceStatus;
import java.util.List;

public class OutputConsoleView {

    public void printAskingCarName() {
        System.out.println(ASKING_CAR_NAME);
    }

    public void printAskingNumberOfTrial() {
        System.out.println(ASKING_NUMBER_OF_TRIAL);
    }

    public void printRaceResult() {
        System.out.println("\n" + RACE_RESULT);
    }

    public void printRaceStatus(List<RaceStatus> raceStatuses) {
        StringBuilder sb = new StringBuilder();
        raceStatuses.stream()
                .forEach(raceStatus -> sb.append(printCarNameAndDistance(raceStatus)).append("\n"));
        System.out.println(sb);
    }

    private String printCarNameAndDistance(RaceStatus raceStatus) {
        StringBuilder sb = new StringBuilder();
        sb.append(raceStatus.getName()).append(" : ");

        int count = raceStatus.getDistance();
        for (int i = 0; i < count; i++) {
            sb.append("-");
        }

        return sb.toString();
    }

    public void printFinalWinners(List<String> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append(FINAL_WINNERS);
        for (int i = 0; i < winners.size(); i++) {
            sb.append(winners.get(i));
            if(i < winners.size() - 1) sb.append(", ");
        }

        System.out.println(sb);
    }


}
