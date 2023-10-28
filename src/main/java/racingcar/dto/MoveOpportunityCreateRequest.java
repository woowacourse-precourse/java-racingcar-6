package racingcar.dto;

public class MoveOpportunityCreateRequest {

    int moveOpportunity;

    public MoveOpportunityCreateRequest(String moveOpportunity) {
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
