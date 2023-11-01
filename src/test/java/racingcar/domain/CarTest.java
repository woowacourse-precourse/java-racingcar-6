package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"유선준준준준", "5글자가넘어요"})
    void Car_생성자는_길이가_5자_이하가_아니면_IllegalArgumentException을_발생시킨_후_애플리케이션은_종료된다(String name) {
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"유선준", "5글자임"})
    void Car_생성자는_길이가_5자_이하가_맞으면_Car_객체를_생성한다(String name) {
        assertThat(new Car(name)).isInstanceOf(Car.class);
    }

    @Test
    void move_메서드는_랜덤한_숫자가_4이상이_나오면_position을_증가시킨다() {
        NumberGenerator numberGenerator = new IncreasePositionNumber();

        car.movePosition(numberGenerator.generate());

        assertEquals(car.getPosition(), 1);
    }

    @Test
    void move_메서드는_랜덤한_숫자가_4이하가_나오면_position을_증가시키지_않는다() {
        NumberGenerator numberGenerator = new NotIncreasePositionNumber();

        car.movePosition(numberGenerator.generate());

        assertEquals(car.getPosition(), 0);
    }

    @Test
    void isSamePosition_메서드는_자동차의_position이랑_같으면_true를_반환한다() {
        car.movePosition(5);

        assertTrue(car.isSamePosition(1));
    }

    @Test
    void comparePosition_메서드는_자동차의_position과_maxPosition을_비교하여_더_큰_값을_반환한다() {
        car.movePosition(5);

        assertEquals(car.compareAndReturnMaxPosition(5), 5);
    }
}
