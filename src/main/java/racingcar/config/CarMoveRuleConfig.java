package racingcar.config;

import racingcar.model.car.CarMoveRule;
import racingcar.model.car.RandomCarMoveRule;

/**
 * 예제
 *
 * <p>CarMoveRule의 구현 클래스를 작성합니다.
 * <pre>
 * {@code AlwaysCarStopRule.java}
 *
 * public class AlwaysCarStopRule implements CarMoveRule {
 *     {@Override}
 *     public boolean isGo() { return false; }
 * }
 * </pre>
 *
 * <p>CarMoveRuleConfig에 클래스 변수를 추가하고 싱글톤 메소드를 작성합니다.
 * <pre>
 * {@code CarMoveRuleConfig.java}
 *
 * private static CarMoveRule alwaysCarStopRule;
 *
 * private static CarMoveRule getAlwaysCarStopRule() {
 *     if (alwaysCarStopRule == null) {
 *         alwaysCarStopRule = new AlwaysCarStopRule();
 *     }
 *     return alwaysCarStopRule;
 * }
 * </pre>
 *
 * <p>{@code setDefault()} 메소드를 사용해 기본 규칙을 설정합니다.
 * <pre>
 * private static void setDefault() { currentRule = getAlwaysCarStopRule(); }
 * </pre>
 */
public class CarMoveRuleConfig {

    private static CarMoveRule currentRule;
    private static CarMoveRule randomRule;

    public static CarMoveRule getCurrentCarMoveRule() {
        if (currentRule == null) {
            setDefault();
        }
        return currentRule;
    }

    private static void setDefault() {
        currentRule = getRandomCarMoveRule();
    }

    public static void setCustomCarMoveRule(CarMoveRule carMoveRule) {
        currentRule = carMoveRule;
    }

    private static CarMoveRule getRandomCarMoveRule() {
        if (randomRule == null) {
            randomRule = new RandomCarMoveRule();
        }
        return randomRule;
    }
}
