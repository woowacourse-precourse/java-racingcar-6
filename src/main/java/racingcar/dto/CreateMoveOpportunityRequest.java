package racingcar.dto;

public class CreateMoveOpportunityRequest {

    int moveOpportunity;

    public CreateMoveOpportunityRequest(String moveOpportunity) {
        try {
            this.moveOpportunity = Integer.parseInt(moveOpportunity);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    public int getMoveOpportunity() {
        return moveOpportunity;
    }
}
