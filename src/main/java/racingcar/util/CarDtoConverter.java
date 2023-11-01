package racingcar.util;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.CarDto;
import racingcar.model.Car;
import racingcar.model.Cars;

//현재 Dto를 View로 보내야 하는 상황인데,
//Model에서 Dto변환함수를 만드는 것은 별로인 것 같다.
//일단 Model에 의존한다는 점이 있고
//두 번째로는 Model이 Dto의 타입까지 알아야 한다는 불상사가 발생하고
//세 번째로는 Model의 역할이 늘어나기 때문이다.
//따라서 컨트롤러에서 Dto로 변환하는 게 맞다고 생각했는데, (사실 Spring MVC패턴에서도 Dispatcher Servlet이 View -> Dto해줌.
public class CarDtoConverter {
    public static List<CarDto> convertCarsToCarDtoList(Cars cars) {
        List<CarDto> carDtoList = new ArrayList<>();

        for (int i=0; i<cars.size(); i++) {
            Car car = cars.get(i);
            carDtoList.add(new CarDto(car));
        }

        return carDtoList;
    }
}
