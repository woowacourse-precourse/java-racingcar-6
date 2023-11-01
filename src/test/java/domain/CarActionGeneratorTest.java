package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarActionGeneratorTest {
    private CarActionGenerator carActionGenerator;
    public static final int FORWARD = 4;
    public static final int STOP = 3;

    @BeforeEach
    public void setUp() {
        carActionGenerator = new CarActionGenerator();
    }

    @AfterEach
    public void tearDown() {
        carActionGenerator = null;
    }

    @Test
    void getDriveorHalt_기능동작() {
        assertThat(carActionGenerator.getDriveorHalt(FORWARD))
                .isEqualTo(true);
        assertThat(carActionGenerator.getDriveorHalt(STOP))
                .isEqualTo(false);
    }

    @Test
    void getRandomNumber_기능동작() {
        int number;

        for (int i = 0; i < 10; i++) {
            carActionGenerator.getRandomNumber();
        }
    }
}
