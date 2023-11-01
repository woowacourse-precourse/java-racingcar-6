package racingcar.model.repository;

import racingcar.model.domain.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarRepository {
   private long id = 0L;//자동차 객체 식별-고유성 보장
   private final Map<Long, Car> cars = new HashMap<>();//cars맵:자동차 객체 저장 id를 키로 사용하여 저장하고, 이를 통해 자동차 검색 가능
                                                      //cars맵은 먑 데이터 구조를 사용하여 자동차 객체 검색, 추가, 삭제
                                                      //domain.Car import

    public Long save(Car car){//자동차 객체 저장, id반환
        cars.put(id, car);
        id+=1;
        return id;
    }
    public Car findById(Long id){
        return cars.get(id);
    }

    public List<Car>findAll(){//carsValue의 값 모두 arrayList로 반환
        return  new ArrayList<>(cars.values());
    }

}
