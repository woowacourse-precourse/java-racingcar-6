package racingcar;

public class CarRegistration {
    private final RaceParticipants raceParticipants;
    public CarRegistration(CarNameRegistration carNames) {
        this.raceParticipants = new RaceParticipants();

        for (CarName carName : carNames.getCarNameList()) {
            raceParticipants.addCar(new Car(carName));
        }
    }
    public RaceParticipants getRaceParticipants() {
        return raceParticipants;
    }

}
