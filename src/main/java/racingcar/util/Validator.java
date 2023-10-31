package racingcar.util;

public class Validator {
    public Forward forward;

    public Validator() {
        forward = new Forward();
    }

    public boolean is_forward() {
        if (this.forward.get_Num() >= 4) {
            return true;
        }
        return false;
    }
}
