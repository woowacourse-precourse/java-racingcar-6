package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarManagerTest {
    CarManager carManager = new CarManager(new RandomNumberGenerator());
    CarManager carManagerWithFixedNumberGeneratorValueFive = new CarManager(new RandomNumberGeneratorMock(5));
    CarManager carManagerWithFixedNumberGeneratorValueThree = new CarManager(new RandomNumberGeneratorMock(3));

    @Test
    void 입력받은_이름_목록의_레이싱카_목록을_생성한다() {
        // given
        String[] names = {"성겸", "성민", "성우"};

        // when
        carManager.createCars(names);

        // then
        Assertions.assertThat(carManager.getCars().getCarList().size()).isEqualTo(3);
    }

    @Test
    void 저장된_레이싱카들을_규칙에_맞게_이동시킨다_성공_케이스() {
        // given
        String[] names = {"성겸"};
        carManagerWithFixedNumberGeneratorValueFive.createCars(names);

        // when
        carManagerWithFixedNumberGeneratorValueFive.moveCars();

        // then
        Assertions.assertThat(carManagerWithFixedNumberGeneratorValueFive.getCars().getCarList().get(0).getDistance()).isEqualTo(1);
    }

    @Test
    void 저장된_레이싱카들을_규칙에_맞게_이동시킨다_실패_케이스() {
        // given
        String[] names = {"성겸"};
        carManagerWithFixedNumberGeneratorValueThree.createCars(names);

        // when
        carManagerWithFixedNumberGeneratorValueThree.moveCars();

        // then
        Assertions.assertThat(carManagerWithFixedNumberGeneratorValueThree.getCars().getCarList().get(0).getDistance()).isEqualTo(0);
    }

    @Test
    void 우승자를_반환한다() {
        // given
        String[] names = {"성겸", "성민", "성우"};

        // when
        carManager.createCars(names);

        // 성겸 이동 거리 : 2
        carManager.getCars().getCarList().get(0).incrementDistance();
        carManager.getCars().getCarList().get(0).incrementDistance();

        // 성민 이동 거리 : 2
        carManager.getCars().getCarList().get(1).incrementDistance();
        carManager.getCars().getCarList().get(1).incrementDistance();

        // then
        Assertions.assertThat(carManager.getWinners().getCarList().size()).isEqualTo(2);
    }
}

class RandomNumberGeneratorMock extends RandomNumberGenerator {
    private int fixedValue;

    public RandomNumberGeneratorMock(int fixedValue) {
        this.fixedValue = fixedValue;
    }

    @Override
    public Integer getRandomInteger() {
        return fixedValue;
    }
}
