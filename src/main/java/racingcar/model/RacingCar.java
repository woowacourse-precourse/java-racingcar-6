package racingcar.model;


import racingcar.util.Constants;
import racingcar.util.ExceptionMessages;

import javax.print.attribute.standard.MediaSize;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RacingCar {

    private int distance;
    private String name;
    private static final Pattern NAME = Pattern.compile(Constants.COMMA_MATCH_REGEX + Constants.PARSER_REGEX + Constants.COMMA_MATCH_REGEX);

    public int getDistance() {
        return this.distance;
    }

    public String getName() {
        return this.name;
    }

    private RacingCar(String name) {
        this.name = name;
        this.distance = Constants.CAR_INIT_DISTANCE;
    }

    public static RacingCar from(String name) {
        if (!validateCarName(name)) {
            throw new IllegalArgumentException(ExceptionMessages.NAME_RANGE_EXCEPTION);
        }
        return new RacingCar(name);
    }

    private static boolean validateCarName(String name) {
        return checkNotEmpty(name) && checkLength(name) && checkSymbol(name);
    }

    private static boolean checkSymbol(String name) {
        Matcher matcher = NAME.matcher(name);
        return !matcher.matches();
    }

    private static boolean checkNotEmpty(String name) {
        return name.trim().length() != Constants.NAME_MIN_LENGTH;
    }

    private static boolean checkLength(String name) {
        return name.length() <= Constants.NAME_MAX_LENGTH;
    }

    public void move(NumberGenerator numberGenerator) {
        int playType = numberGenerator.generate();
        if (PlayType.findByNum(playType) == PlayType.GO) {
            distance++;
        }
        return;
    }
}
