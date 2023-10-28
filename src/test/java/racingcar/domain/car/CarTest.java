package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차 객체를 생성할 수 있다.")
    public void carTest() {
        // given
        String name = "myCar";
        // when
        Car car = new Car(name);
        // then
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getMoveCount()).isZero();
    }

    @DisplayName("입력값이 4 이상이면 하나 증가한다.")
    @ParameterizedTest(name ="{0}를 입력시 자동차가 한칸 움직인다.")
    @ValueSource(ints = {4,5,6,7,8,9})
    public void moveCar(int controlValue) {
        // given
        Car car = createCar("myCar");
        // when
        car.controlMovement(controlValue);
        // then
        assertThat(car.getMoveCount()).isOne();
    }

    @DisplayName("입력값이 4 미만이면 증가하지 않는다.")
    @ParameterizedTest(name ="{0}를 입력시 자동차가 움직이지 않는다.")
    @ValueSource(ints = {0,1,2,3})
    public void stopCar(int controlValue) {
        // given
        Car car = createCar("myCar");
        // when
        car.controlMovement(controlValue);
        // then
        assertThat(car.getMoveCount()).isZero();
    }
    
    @TestFactory
    @DisplayName("자동차가 움직인 횟수로 다른 자동차와 비교할 수 있다.")
    public Collection<DynamicTest> compareTo() {

        return List.of(
                DynamicTest.dynamicTest("움직인 거리의 차이가 출력된다. (1-0)=1", () -> {
                    //given
                    Car haen = createCar("haen");
                    haen.controlMovement(4);
                    Car pobi = createCar("pobi");
                    //when
                    int result = haen.compareTo(pobi);
                    //then
                    assertThat(result).isOne();
                }),
                DynamicTest.dynamicTest("움직인 거리가 같으면 0이 출력된다. (0-0)=0", () -> {
                    //given
                    Car haen = createCar("haen");
                    Car pobi = createCar("pobi");
                    //when
                    int result = haen.compareTo(pobi);
                    //then
                    assertThat(result).isZero();
                }),
                DynamicTest.dynamicTest("움직인 거리의 차이가 출력된다. (0-1)=-1", () -> {
                    //given
                    Car haen = createCar("haen");
                    Car pobi = createCar("pobi");
                    pobi.controlMovement(4);
                    //when
                    int result = haen.compareTo(pobi);
                    //then
                    assertThat(result).isEqualTo(-1);
                })
        );
    }

    @Test
    @DisplayName("움직인 거리가 같으면 True가 반환된다.")
    public void findSameCarTrue() {
        // given
        Car haen = createCar("haen");
        Car pobi = createCar("pobi");
        // when
        boolean isSameToPobi = haen.findSameCar(pobi);
        // then
        assertThat(isSameToPobi).isTrue();
    }

    @Test
    @DisplayName("움직인 거리가 다르면 False가 반환된다.")
    public void findSameCarFalse() {
        // given
        Car haen = createCar("haen");
        Car pobi = createCar("pobi");
        pobi.controlMovement(4);
        // when
        boolean isSameToPobi = haen.findSameCar(pobi);
        // then
        assertThat(isSameToPobi).isFalse();
    }

    private Car createCar(String name){
        return new Car(name);
    }

}