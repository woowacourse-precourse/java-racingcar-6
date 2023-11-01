package racingcar.collaborator.race.enums;

public enum RaceMessage {

    EXCEPTION_MIN_PARTICIPANTS("최소 참가인원은 2인입니다."),
    ;

    private final String message;

    RaceMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
