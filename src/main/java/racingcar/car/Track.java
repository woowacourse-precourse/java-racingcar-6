package racingcar.car;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class Track {
    private static final Track instance = new Track();

    private final List<Car> cars;

    private Track() {
        cars = new ArrayList<>();
    }

    public static Track getInstance() {
        return instance;
    }

    public void setCars(List<String> nameList) {
        for (String name : nameList) {
            cars.add(new Car(name));
        }
    }

    public void runCars() {
        for (Car car : cars) {
            car.jump();
        }
    }

    public void print1st(){
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        Iterator<Car> iterator = pick1st().listIterator();

        while(iterator.hasNext()){
            sb.append(iterator.next().getName());
            if(iterator.hasNext()) sb.append(",");
        }

        System.out.println(sb);
    }

    private List<Car> pick1st() {
        PriorityQueue<Car> queue =
                new PriorityQueue<>((o1, o2) -> (o2.getDist() - o1.getDist()));
        for (Car car : cars) queue.offer(car);

        assert queue.peek() != null;
        int dist1st = queue.peek().getDist();

        List<Car> result = new ArrayList<>();

        while (!queue.isEmpty() && queue.peek().getDist() == dist1st) {
            result.add(queue.poll());
        }
        return result;
    }

    public void printCars() {
        StringBuilder sb = new StringBuilder();

        for (Car car : cars) {
            sb.append(car.getName()).append(" : ").append(car.printDist()).append("\n");
        }

        System.out.println(sb);
    }
}
