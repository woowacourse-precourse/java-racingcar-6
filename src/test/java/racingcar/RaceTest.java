package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class RaceTest {
    private Race race;
    private DriveCar car1;
    private DriveCar car2;

    @BeforeEach
    void setUp() {
        car1 = new DriveCar("Car1", 0);
        car2 = new DriveCar("Car2", 0);
        race = new Race(new DriveCar[]{car1, car2}, 5);
    }

    @Test
    void  레이스_중간_결과_확인() {
        car1.setScore(3);
        car2.setScore(5);
        race.RaceResult();
    }

    @Test
    void 레이스_최종_결과_단일_우승() {
        car1.setScore(3);
        car2.setScore(5);
        String result = race.FinalResult();

        assertThat(result).isEqualTo("최종 우승자 : Car2");
    }

    @Test
    void 레이스_최종_결과_공동_우승(){
        car1.setScore(5);
        car2.setScore(5);
        String result = race.FinalResult();

        assertThat(result).isEqualTo("최종 우승자 : Car1, Car2");
    }
}
