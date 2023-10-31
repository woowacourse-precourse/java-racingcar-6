package racingcar.domain;

public class TypeCasting {
    public static RacingCars stringToRacingCars(String stringCars) {
        RacingCars racingcars = new RacingCars();
        String[] stringArrayCars = stringCars.split(",");
        for (String car : stringArrayCars) {
            racingcars.add(new RacingCar(car));
        }
        return racingcars;
    }
}
