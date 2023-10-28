package racingcar.domain;

public class StopOrGo {
    public boolean move(int number) {
        if (number > 4) {
            return true;
        }
        return false;
    }
}
