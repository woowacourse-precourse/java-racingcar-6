package racingcar;

public class ThrowException {

    private final String emptyAnnouncement = "입력값이 없습니다.";
    private final String nameOverlapAnnouncement = "자동차 이름이 중복됩니다.";
    private final String tryNumberAnnouncement = "0보다 큰 숫자로 입력해주세요.";
    private final String nameLengthAnnouncement = "자동차 이름을 5자 이하로 입력해주세요.";

    public void throwEmpty() {
        throw new IllegalArgumentException(emptyAnnouncement);
    }

    public void throwNameOverlap() {
        throw new IllegalArgumentException(nameOverlapAnnouncement);
    }

    public void throwTryNumber() {
        throw new IllegalArgumentException(tryNumberAnnouncement);
    }

    public void throwNameLength() {
        throw new IllegalArgumentException(nameLengthAnnouncement);
    }
}
