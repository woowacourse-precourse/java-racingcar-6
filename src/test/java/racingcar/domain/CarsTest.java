package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {
    final int STAY = 3;
    final int MOVE = 5;
    @Test
    void 각차수에_차들을_이동() {
        final int TRY_NUM = 5;

        final int EXPECTED_GO_CAR_LOCATION = 5;
        final int EXPECTED_STAY_CAR_LOCATION = 0;

        final int GO_ALWAYS = 5;
        final int STAY_ALWAYS = 3;

        final int GO_CAR_INDEX = 0;
        final int STAY_CAR_INDEX = 1;

        List<Car> carList = new ArrayList<>();

        Car goCar = new Car(new CarName("go")){
            @Override
            protected int getRandomNumber(){
                return GO_ALWAYS;
            }
        };
        Car stayCar = new Car(new CarName("stay")){
            @Override
            protected int getRandomNumber(){
                return STAY_ALWAYS;
            }
        };
        carList.add(goCar);
        carList.add(stayCar);

        Cars cars = new Cars(carList);

        for (int i = 0; i < TRY_NUM; i++) {
            cars.moveCars();
        }

        assertEquals(EXPECTED_GO_CAR_LOCATION, cars.getCars().get(GO_CAR_INDEX).getLocationValue());
        assertEquals(EXPECTED_STAY_CAR_LOCATION, cars.getCars().get(STAY_CAR_INDEX).getLocation().getLocation());
    }

    @Test
    void 이동거리가_최대인_차가_최종우승자() {
        List<Car> carlist = new ArrayList<>();
        Car pobiCar = new Car(new CarName("pobi")){
            @Override
            protected int getRandomNumber(){
                return MOVE;
            }
        };
        Car woniCar = new Car(new CarName("woni")){
            @Override
            protected int getRandomNumber(){
                return MOVE;
            }
        };

        pobiCar.move();
        pobiCar.move();
        woniCar.move();

        carlist.add(pobiCar);
        carlist.add(woniCar);
        Cars cars = new Cars(carlist);

        List<Car> winners = cars.findWinners();

        assertEquals(pobiCar, winners.get(0));
        assertEquals(1, winners.size());
    }

    @Test
    void 공동우승_가능() {
        List<Car> carlist = new ArrayList<>();
        Car pobiCar = new Car(new CarName("pobi")){
            @Override
            protected int getRandomNumber(){
                return MOVE;
            }
        };
        Car woniCar = new Car(new CarName("woni")){
            @Override
            protected int getRandomNumber(){
                return MOVE;
            }
        };

        pobiCar.move();
        pobiCar.move();
        woniCar.move();
        woniCar.move();

        carlist.add(pobiCar);
        carlist.add(woniCar);
        Cars cars = new Cars(carlist);

        List<Car> winners = cars.findWinners();

        assertEquals(pobiCar, winners.get(0));
        assertEquals(woniCar, winners.get(1));
        assertEquals(2, winners.size());
    }
}