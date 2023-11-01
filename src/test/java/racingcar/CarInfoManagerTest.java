package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarInfoManagerTest {

    private static final List<String> CAR_NAME = Arrays.asList("yujin", "minji", "zion");

    @BeforeEach
    void setUp() {
        CarInfoManager.initializeCarInfos(CAR_NAME);
    }
    @Test
    void initializeCarInfos() {
        assertEquals(CAR_NAME.size(), CarInfoManager.carInfos.size());
        for(int i=0; i<3; i++)
            assertEquals(CAR_NAME.get(i), CarInfoManager.carInfos.get(i).getName());
    }
}