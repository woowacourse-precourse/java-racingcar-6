package racingcar;

import java.util.List;

public class CarSimulate {
    public void goSimulate(int randomNumber, int index, List<Integer> track) {
        if (randomNumber >= 4) {
            track.set(index, track.get(index) + 1);
        }

    }

    public void viewCurrentProgress(String[] car, List<Integer> track) {
        for (int i = 0; i < track.size(); i++) {
            System.out.print(car[i] + " : ");
            for (int j = 0; j < track.get(i); j++) {
                System.out.print('-');
            }
            System.out.println();
        }
    }
}
