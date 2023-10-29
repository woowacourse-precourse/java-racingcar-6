package racingcar;

public class AdvancingMachine {
    Integer controlValue;
    Integer movingDistance;

    AdvancingMachine(Integer controlValue, Integer movingDistance) {
        this.controlValue = controlValue;
        this.movingDistance = movingDistance;
    }
    void Advance(Car car){
        if(IsAdvance(car.currentValue)){
            car.advance(movingDistance);
        }
    }
    boolean IsAdvance(Integer randomNumber) {
        return (randomNumber >= controlValue);
    }

}
