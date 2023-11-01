package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputServiceTest {
    
    private OutputService outputService;
    
    @BeforeEach
    void setUp() {
        outputService = new OutputService();
    }
    
    @DisplayName("각 자동차들의 이름과 전진 거리가 출력될 문자열을 구한다.")
    @Test
    void getResultMessage() {
        // given
        List<Car> cars = getThreeCars(3, 3, 6);
        
        String expectedResultMessage =
                        """
                        Bang : ---
                        Jae : ---
                        Young : ------
                        """
                        ;
        
        // when
        String actualResultMessage = outputService.getResultMessage(cars);
        
        // then
        assertThat(actualResultMessage).isEqualTo(expectedResultMessage);
    }
    
    @DisplayName("단독 우승 자동차들의 이름이 출력될 문자열을 구한다.")
    @Test
    void getOneWinnerMessage() {
        // given
        List<Car> winners = List.of(new Car("Bang"));
        String expectedWinnerMessage = "최종 우승자 : Bang";
        
        // when
        String actualWinnerMessage = outputService.getWinnerMessage(winners);
        
        // then
        assertThat(actualWinnerMessage).isEqualTo(expectedWinnerMessage);
    }
    
    @DisplayName("공동 우승 자동차들의 이름이 출력될 문자열을 구한다.")
    @Test
    void getManyWinnerMessage() {
        // given
        List<Car> winners = List.of(
                new Car("Bang"),
                new Car("Jae")
        );
        
        String expectedWinnersMessage = "최종 우승자 : Bang, Jae";
        
        // when
        String actualWinnersMessage = outputService.getWinnerMessage(winners);
        
        // then
        assertThat(actualWinnersMessage).isEqualTo(expectedWinnersMessage);
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
