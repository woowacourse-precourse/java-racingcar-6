package racingcar.domain;

public class StopOrGo {
    public boolean move(int number) {
        if (number > 3) {
            return true;
        }
        return false;
    }
}
