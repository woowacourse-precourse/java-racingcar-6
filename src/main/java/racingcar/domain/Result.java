package racingcar.domain;

public class Result {

    private CarGroup carGroup;
    private int roundNumber;

    public Result(CarGroup carGroup, int roundNumber) {
        this.carGroup = carGroup;
        this.roundNumber = roundNumber;
    }

    public CarGroup getCarGroup() {
        return carGroup;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

}
