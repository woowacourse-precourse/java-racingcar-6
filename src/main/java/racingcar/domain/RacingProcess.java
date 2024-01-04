package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class RacingProcess {
    public static void goForwardRandom(Car car) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            car.move();
        }
    }

    public String makingStatusBar(Car car) {
        String progressbar = "";
        for (int i = 0; i < car.getProgress(); i++) {
            progressbar += "-";
        }
        String result = car.getName() + " : " + progressbar;
        return result;
    }

    public void doRace(int rounds, ArrayList<Car> carList) {
        for (int i = 0; i < rounds; i++) {
            for (int j = 0; j < carList.size(); j++) {
                goForwardRandom(carList.get(j));
                UserConsole.printRaceStatus(makingStatusBar(carList.get(j)));
            }
            System.out.println(" ");
        }
    }
}
