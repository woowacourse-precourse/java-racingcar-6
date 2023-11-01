package racingcar;

import java.util.List;

public class CarSimulate {

    public void goSimulate(int randomNumber, int carIndex, List<Integer> track) {
        if (randomNumber >= 4) {
            int currentPosition = track.get(carIndex);
            track.set(carIndex, currentPosition + 1);
        }

    }

    public void viewCurrentProgress(String[] carNames, List<Integer> track) {
        for (int i = 0; i < track.size(); i++) {
            System.out.print(carNames[i] + " : ");
            for (int j = 0; j < track.get(i); j++) {
                System.out.print('-');
            }
            System.out.println();
        }
    }
}
