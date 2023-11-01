package racingcar;

import java.math.BigInteger;

public class Racingcar {
    private final String name;
    private BigInteger moveDistance;

    public Racingcar(String name){
        this.name = name;
        this.moveDistance = new BigInteger("0");
    }

    public String getName() {
        return name;
    }

    public BigInteger getMoveDistance() {
        return moveDistance;
    }
    public void upMoveDistance(){
        this.moveDistance = this.moveDistance.add(BigInteger.valueOf(1));
    }
}
