package racingcar.domain;

/**
 * User가 경주를 진행할 주체
 */
public class RacingCar {
    private int proceedCount;
    private final StringBuilder visualizedCount;

    public RacingCar() {
        proceedCount=0;
        visualizedCount=new StringBuilder();
    }

    public String visualizeProgress(){
        return String.valueOf(visualizedCount);
    }

    public void proceed() {
        visualizedCount.append("-");
        this.proceedCount++;
    }
}
