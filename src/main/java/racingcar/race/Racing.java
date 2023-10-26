package racingcar.race;

import java.util.List;

public class Racing {

    public void showRaceResult(List<String> driverList, int lapsToDrive) {
        for (int passedLaps = 0; passedLaps < lapsToDrive; passedLaps++) {
            String raceResult = generateRaceStatusForAllDrivers(driverList, passedLaps);
            System.out.println(raceResult);
        }
    }

    public String generateRaceStatusForAllDrivers(List<String> driverList, int passedLaps) {
        String raceResult = "";

        for (String driver : driverList) {
            raceResult += driver + " : ";
            String driverStatus = generateRaceStatus(passedLaps);
            raceResult += driverStatus + "\n";
        }

        return raceResult;
    }

    public String generateRaceStatus(int passedLaps) {
        String raceStatus = "";
        for (int i = 0; i < passedLaps; i++) {
            raceStatus += "-";
        }
        return raceStatus;
    }
}
