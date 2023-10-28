package racingcar.domain;

public class TypeCasting {
    public static RacingCars stringToRacingCars(String stringCars) {
        // validate(cars);
        RacingCars result = new RacingCars();
        String[] stringArrayCars = stringCars.split(",");
        for (String car : stringArrayCars) {
            result.add(new RacingCar(car));
        }
        return result;
    }

    public static int stringToInteger(String number) {
        // validate(number);
        return Integer.parseInt(number);
    }
}
