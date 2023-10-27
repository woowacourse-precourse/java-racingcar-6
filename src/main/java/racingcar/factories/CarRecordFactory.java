package racingcar.factories;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.CarRecord;
import racingcar.GameRule;

public class CarRecordFactory {

    public static CarRecord createEmptyCarRecord() {
        return new CarRecord();
    }

    public static CarRecord createCarRecord(GameRule rule, String[] tokens) throws IllegalArgumentException {
        CarRecord carRecord = CarRecordFactory.createEmptyCarRecord();
        for (String token: tokens) {
            validate(token);
            carRecord.register(CarFactory.car(rule, token));
        }
        return carRecord;
    }

    private static void validate(String token) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile("^[a-z, A-Z]{1,5}$");
        Matcher matcher = pattern.matcher(token);
        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
    }
}
