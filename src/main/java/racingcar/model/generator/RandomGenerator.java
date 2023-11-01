package racingcar.model.generator;

import static racingcar.util.GameConstants.MAXIMUM_GENERATED_NUM;
import static racingcar.util.GameConstants.MINIMUM_GENERATED_NUM;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * {@code MovementGenerator}의 구현부이다.
 * 랜덤으로 값을 생성하는 규칙에 따라 전진 여부 값을 생성한다.
 */
public class RandomGenerator implements MovementGenerator{

    /**
     * 정의된 최솟값과 최댓값을 통해 랜덤으로 전진 여부 값을 생성한다.
     * missionUtils 라이브러리의 Randoms utility를 사용하여 랜덤 값을 생성한다.
     *
     * @return MINIMUM_GENERATED_NUM과 MAXIMUM_GENERATED_NUM 사이의 랜덤한 integer 값
     */
    @Override
    public int generateMovement() {
        return Randoms.pickNumberInRange(MINIMUM_GENERATED_NUM, MAXIMUM_GENERATED_NUM);
    }
}
