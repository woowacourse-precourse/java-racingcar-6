package study;

public class RandomsWrapper implements RandomNumberGenerator {
    @Override
    public int pickNumberInRange(int min, int max) {
        // 실제 Randoms.pickNumberInRange() 메서드 호출 대신 여기에서 조작 가능
        return 4; // 예시로 항상 4를 반환하도록 설정
    }
}
