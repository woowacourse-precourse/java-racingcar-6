package racingcar.dto.request;

public class ActionCountDto {

    private final Integer actionCount;

    public ActionCountDto(final String actionCount) {
        this.actionCount = convertToInteger(actionCount);
    }

    private Integer convertToInteger(final String actionCount) {
        try {
            return Integer.valueOf(actionCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("please enter an integer");
        }
    }

    public Integer getActionCount() {
        return actionCount;
    }
}
