package racingcar.io.enums;

import racingcar.generic.RacerProgress;

public enum RaceTotalProgressViewMessage {

    NEW_LINE(System.lineSeparator()),
    BLANK_AND_NEW_LINE(System.lineSeparator().repeat(2)),
    MESSAGE_RACE_RESULT("실행 결과"),
    FORMAT_NAME_AND_MILEAGE("%s : %s"),
    PROGRESS_MILEAGE("-"),
    MESSAGE_WINNERS("최종 우승자 : "),
    DELIMITER_WINNERS(", "),
    ;

    private final String message;

    RaceTotalProgressViewMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }

    public static String makeRacingRecord(RacerProgress racerProgress) {
        return String.format(FORMAT_NAME_AND_MILEAGE.get(),
                racerProgress.name(),
                getProgressBarOn(racerProgress));
    }

    private static String getProgressBarOn(RacerProgress racerProgress) {
        return PROGRESS_MILEAGE.get().repeat(racerProgress.mileage());
    }

    public static String makeWinnersMessage(String totalWinners) {
        return NEW_LINE.get() + MESSAGE_WINNERS.get() + totalWinners;
    }

}
