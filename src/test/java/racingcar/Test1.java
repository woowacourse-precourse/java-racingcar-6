package racingcar;

import static org.junit.jupiter.api.Assertions.*;
import domain.Car;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Test1 {
    @Test
    void Test1(){
        Car car=new Car("geonwoo");
        assertEquals(car.getName(), "geonwoo");
        assertEquals(car.getPosition(),0);
        car.go();
        assertEquals(car.getPosition(), 1);
    }



}
