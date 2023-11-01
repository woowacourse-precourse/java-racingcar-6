package racingcar.dto;

public record UserAttemptCountsDto(String attemptCounts) {

    public UserAttemptCountsDto(String attemptCounts) {
        this.attemptCounts = attemptCounts;
    }
}
