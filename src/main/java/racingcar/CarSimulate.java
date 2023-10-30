package racingcar;

import java.util.List;

public class CarSimulate {
    int randomnum;

    public void goSimulate(int numberOfCars, List<Integer> track) {
        for (int i = 0; i < numberOfCars; i++) {
            RandNum randnum = new RandNum();
            randomnum = randnum.createRandomNumber();
            if (randomnum >= 4) {
                track.set(i, track.get(i) + 1);
            }

        }
    }

    public void viewCurrentProgress(int numberOfCars, String[] car, List<Integer> track) {
        for (int i = 0; i < numberOfCars; i++) {
            System.out.print(car[i] + " : ");
            for (int j = 0; j < track.get(i); j++) {
                System.out.print('-');
            }

            System.out.println();
        }

    }

}
