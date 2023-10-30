package racingcar;

import java.util.ArrayList;
import java.util.List;

public class ThreadManager {
    public static List<Thread> addThread(List<Car> cars) {
        List<Thread> carThreads = new ArrayList<>();

        for (Car car : cars) {
            carThreads.add(createThread(car));
        }

        return carThreads;
    }

    private static Thread createThread(Car car){
        return new Thread(new CarMover(car));
    }
}
