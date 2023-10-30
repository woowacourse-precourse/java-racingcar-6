package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;


public class CarAction {

    public void moveCars() {
        for (int i = 0; i < Cars.countList.size(); i++) {
            carMoveOrStop(i);
        }
    }

    private void carMoveOrStop(int carListIndex) {
        int randomNumber = createRandomNumber();
        if (randomNumber >= 4) {
            carMoveOneStep(carListIndex);
        }
    }

    private void carMoveOneStep(int carListIndex) {
        Cars.countList.set(carListIndex, Cars.countList.get(carListIndex) + 1);
    }

    private int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
