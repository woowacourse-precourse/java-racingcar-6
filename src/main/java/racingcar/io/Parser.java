package racingcar.io;

/**
 * Parses each raw string into appropriate data object.
 */
public class Parser {
    private static final String CAR_NAME_SEPARATOR = ",";

    /**
     * Parses a raw string indicating names of cars to participate in.
     * @param line a raw string to parse. Each name of cars is going to be separated by comma(,).
     * @return given the raw string, an array containing all the names of cars to participate in,
     *      extracted from the string.
     */
    public String[] parseCarNames(String line) {
        return line.split(CAR_NAME_SEPARATOR);
    }

    /**
     * Parses a string indicating an integer into integer data type.
     * @param integer a string to parse into an integer. integer has to be a string in a form of an integer.
     * @return an integer from the parameter, integer.
     */
    public int parseInt(String integer) {
        return Integer.parseInt(integer);
    }
}
