package racingcar.Service;

import camp.nextstep.edu.missionutils.Randoms;

public class CarService {
    int generatedNum;

    public int getGeneratedNum() {

        return generatedNum;
    }

    public void setGeneratedNum(int generatedNum) {

        this.generatedNum = generatedNum;
    }

    public int generateRandomNum() {
        return generatedNum = Randoms.pickNumberInRange(0, 9);
    }

    public boolean forwardOrStop() {
        if (this.generatedNum >= 4) {
            return true;
        } else {
            return false;
        }
    }
}
