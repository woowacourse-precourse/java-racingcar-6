package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerServiceTest {
    
    private WinnerService winnerService;
    
    @BeforeEach
    void setUp() {
        winnerService = new WinnerService();
    }
    
    @DisplayName("가장 멀리 전진한(`-`개수가 가장 많은) 자동차가 우승자이다.")
    @Test
    void isWinnerWithMostDistanceString() {
        // given
        List<Car> cars = getThreeCars(3, 4, 5);
        
        // when
        List<Car> winners = winnerService.getWinners(cars);
        
        // then
        assertThat(winners).hasSize(1)
                .extracting("name")
                .containsExactly("Young");
    }
    
    @DisplayName("가장 멀리 전진한(`-`개수가 가장 많은) 자동차가 여러 대일 경우, 공동 우승자이다.")
    @Test
    void areManyWinnersWithMostDistanceString() {
        // given
        List<Car> cars = getThreeCars(3, 6, 6);
        
        // when
        List<Car> winners = winnerService.getWinners(cars);
        
        // then
        assertThat(winners).hasSize(2)
                .extracting("name")
                .containsExactly("Jae", "Young");
    }
    
    private List<Car> getThreeCars(int time1, int time2, int time3) {
        Car car = new Car("Bang");
        goCarSeveralTimes(car, time1);
        
        Car car2 = new Car("Jae");
        goCarSeveralTimes(car2, time2);
        
        Car car3 = new Car("Young");
        goCarSeveralTimes(car3, time3);
        
        return List.of(car, car2, car3);
    }
    
    private void goCarSeveralTimes(Car car, int times) {
        for (int i = 0; i < times; i++) {
            car.go(5);
        }
    }
}
