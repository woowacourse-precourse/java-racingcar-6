package racingcar.opportunityvalidator;

public class OpportunityValidator {
    public void validateOpportunity(String opportunity) {
        int numOpportunity = Integer.parseInt(opportunity);
        try {
            if (numOpportunity <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}
