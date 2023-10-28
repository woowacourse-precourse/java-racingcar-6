package racingcar.domain.game;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.dto.CarDto;
import racingcar.domain.dto.CarsDto;
import racingcar.util.MoveStrategy;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public CarsDto moveOnce(MoveStrategy moveStrategy) {
        List<CarDto> carDtoList = new ArrayList<>();
        // ref. 일급 콜렉션에서 객체를 꺼내서 차량을 움직이는 비지니스 로직을 구현하고 있다
        //  일급 콜렉션에세 메시지를 보내 차량을 이동시키도록 바꿔볼까?
        for (Car car : cars) {
            CarDto carDto = car.moveOnce(moveStrategy);
            carDtoList.add(carDto);
        }
        return new CarsDto(carDtoList);
    }
}
