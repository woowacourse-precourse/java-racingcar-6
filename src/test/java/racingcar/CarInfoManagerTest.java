package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarInfoManagerTest {

    private static final List<String> CAR_NAME = Arrays.asList("yujin", "minji", "zion");

    @Test
    void initializeCarInfos() {
        CarInfoManager.initializeCarInfos(CAR_NAME);

        assertEquals(CAR_NAME.size(), CarInfoManager.carInfos.size());
        for(int i=0; i<3; i++)
            assertEquals(CAR_NAME.get(i), CarInfoManager.carInfos.get(i).getName());
    }
}