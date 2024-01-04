package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class RacingProcess {
    public static final int MOVE_FORWARD_NUMBER = 4;

    public static void goForwardRandom(Car car) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= MOVE_FORWARD_NUMBER) {
            car.move();
        }
    }

    public String makingStatusBar(Car car) {
        String result;
        String progressBar = " : ";

        for (int i = 0; i < car.getProgress(); i++) {
            progressBar += "-";
        }
        result = car.getName() + progressBar;

        return result;
    }

    public void doRace(int rounds, List<Car> carList) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < rounds; i++) {
            for (int j = 0; j < carList.size(); j++) {
                Car car = carList.get(j);
                goForwardRandom(car);
                UserConsole.printRaceStatus(makingStatusBar(car));
            }
            System.out.println(" ");
        }
    }
}
