package racingcar.domain.model;

public record AttemptsNumber(int attempts) {

    public AttemptsNumber(String attempts){
        this(Integer.parseInt(attempts));
    }
}
