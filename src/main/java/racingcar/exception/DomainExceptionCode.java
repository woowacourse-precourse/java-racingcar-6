package racingcar.exception;

public enum DomainExceptionCode {
    LAP_MUST_BE_GREATER_THAN_ZERO("LAP은 0보다 작을 수 없습니다.");

    private final String message;

    DomainExceptionCode(String message) {
        this.message = message;
    }


    public DomainException invoke() {
        return new DomainException(this.message);
    }
}
