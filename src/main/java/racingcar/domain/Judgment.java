package racingcar.domain;

public class Judgment {
    public boolean isGo(int randomNumber){
        if (randomNumber >= 4)
            return true;
        return false;
    }
}
