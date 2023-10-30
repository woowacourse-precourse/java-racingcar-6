package racingcar.model;

public class RaceStage {
    private final CarGroup carGroup;

    private RaceStage(CarGroup carGroup) {
        this.carGroup = carGroup;
    }

    public static RaceStage from(CarGroup movedCars) {
        return new RaceStage(movedCars);
    }

    public Winners findWinners() {
        return carGroup.findWinners();
    }

    public CarGroup getCarGroup() {
        return carGroup;
    }
}
