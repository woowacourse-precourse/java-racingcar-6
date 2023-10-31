package racingcar.dto.request;

public class ActionCountDto {

    private final Integer actionCount;

    public ActionCountDto(final String actionCount) {
        Integer integerCount =  convertToInteger(actionCount);
        validateRange(integerCount);

        this.actionCount = integerCount;
    }

    private Integer convertToInteger(final String actionCount) {
        try {
            return Integer.valueOf(actionCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("please enter an integer");
        }
    }

    private void validateRange(final Integer actionCount) {
        if(actionCount < 0) {
            throw new IllegalArgumentException("please enter a non-negative integer");
        }
    }

    public Integer getActionCount() {
        return actionCount;
    }
}
