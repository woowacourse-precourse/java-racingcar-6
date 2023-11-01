package racingcar.model.generator;

/**
 * 경주에 참여하는 자동차들의 전진 여부를 결정하는 값에 대한 규칙을 정의한다.
 */
public interface MovementGenerator {

    /**
     * 자동차의 전진 여부를 결정하는 값을 생성한다.
     *
     * @return 전진 여부를 나타내는 integer 값
     */
    int generateMovement();
}
