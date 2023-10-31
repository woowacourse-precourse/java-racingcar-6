package developtest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.CarFactory;
import racingcar.List;

public class CarFactoryTest {
    private CarFactory carFactory;


    @BeforeEach
    void setUp(){
        carFactory = new CarFactory();
    }


}
