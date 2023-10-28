package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;
import static racingcar.service.InputService.*;

public class GameService {
    static List<RacingCar> racingCars;
    static long maxLocation;

    public static void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        racingCars = createRacingCars();

        System.out.println("시도할 회수는 몇회인가요?");
        long times = readTimes();

        System.out.println("\n실행 결과");
        playGameForTimes(times);

        System.out.print("최종 우승자 : ");
        findFinalWinner();
    }

    private static List<RacingCar> createRacingCars() {
        List<RacingCar> racingCars = new ArrayList<>();
        String[] carNames = convertToStringArray(readInput());

        for (String carName : carNames)
            racingCars.add(RacingCar.createRacingCar(carName));

        return racingCars;
    }

    private static Long readTimes() {
        return convertToLong(readInput());
    }

    private static void playGameForTimes(Long times) {
        for (int i = 0; i < times; i++) {
            for (RacingCar racingCar : racingCars) {
                int num = Randoms.pickNumberInRange(0, 9);

                if (num >= 4)
                    racingCar.putForward(num);

                maxLocation = max(maxLocation, racingCar.getLocation());
            }
        }
    }

    private static void findFinalWinner() {
        List<RacingCar> winners = new ArrayList<>();

        for (RacingCar racingCar : racingCars)
            if (racingCar.getLocation().equals(maxLocation))
                winners.add(racingCar);

        for (RacingCar winner : winners)
            System.out.print(winner + ", ");
    }
}
