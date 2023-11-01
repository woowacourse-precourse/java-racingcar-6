package racingcar.underhood;

import racingcar.underhood.CarRecord;

public class Referee {

    private CarRecord carRecord;

    public Referee(CarRecord carRecord) {
        this.carRecord = carRecord;
    }

    public String announceAllWinners() {
        return carRecord.getLeadingCarRecord().toString();
    }
}
