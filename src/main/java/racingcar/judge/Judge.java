package racingcar.judge;

import racingcar.drive.Drive;

import java.util.ArrayList;
import java.util.List;

public class Judge {

    public List<String> getWinners(List<String> driverList, String input) {
        int lapsToDrive = Integer.parseInt(input);
        List<String> winners = new ArrayList<>();
        int maxLaps = 0;

        for (String driver : driverList) {
            Drive drive = new Drive();
            int lapsDriven = drive.lapsToDrive(input);

            if (lapsDriven > maxLaps) {
                maxLaps = lapsDriven;
                winners.clear();
                winners.add(driver);
            } else if (lapsDriven == maxLaps) {
                winners.add(driver);
            }
        }

        return winners;
    }
}
