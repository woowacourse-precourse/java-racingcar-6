package racingcar.domain;

public class StopOrGo {
    GenerateRandomNum randomNum = new GenerateRandomNum();
    public boolean move(int number) {
        number = randomNum.createRandomNum();
        if (number > 3) {
            return true;
        }
        return false;
    }
}
