package racingcar.domain;

public class GameResult {

    private static final String ENTER = System.lineSeparator();
    private static final String POSITION_SIGN = "-";
    private static final String MESSAGE_FORM = "%s : %s" + ENTER;
    private final StringBuilder result;

    public GameResult() {
        result = new StringBuilder();
    }

    public void generateResult(final Cars cars) {
        cars.getCar()
                .forEach(car -> result.append(
                        String.format(MESSAGE_FORM, car.getName(), convertPositionToSign(car.getPosition()))
                ));
        result.append(ENTER);
    }

    public String getResult() {
        return result.toString();
    }

    private String convertPositionToSign(int position) {
        return POSITION_SIGN.repeat(position);
    }
}
