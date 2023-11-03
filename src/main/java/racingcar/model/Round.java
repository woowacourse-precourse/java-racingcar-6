package racingcar.model;

public class Round {
    private Integer round;

    public Round(String round){
        validate(round);
        this.round = Integer.parseInt(round);
    }

    public Boolean isContinue(){
        if (round > 0){
            round --;
            return true;
        }
        return false;
    }

    private void validate(String value){
        validateType(value);
        validateRange(value);
    }

    private void validateType(String value){
        if (value != null && !value.matches("^[0-9]+")){
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(String value){
        if (0 >= Integer.parseInt(value)) {
            throw new IllegalArgumentException();
        }
    }
}
