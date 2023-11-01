package racingcar.Entity;

import racingcar.Config;
import racingcar.IO.InputOutputHelper;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Snapshot {
    private final List<Map<String, Integer>> snapshots;
    private final InputOutputHelper ioHelper;

    private Snapshot(int tryCount) {
        this.snapshots = new ArrayList<>(tryCount + 1);
        this.snapshots.add(Config.CAR_START_LOCATION, null);
        for (int i = 1; i <= tryCount; i++) {
            this.snapshots.add(i, new LinkedHashMap<>());
        }
        ioHelper = Config.getSystemIOHelper();
    }

    public static Snapshot create(int tryCount) {
        return new Snapshot(tryCount);
    }

    public void print(int order) {
        if (order < 1 || order > snapshots.size()) {
            throw new IllegalArgumentException("존재하지 않는 순서의 스냅샷입니다.");
        }

        Map<String, Integer> snapshot = get(order);
        StringBuilder sb = new StringBuilder();
        if (snapshot.keySet().size() == 0) {
            sb.append("no snapshot\n");
            ioHelper.output(sb.toString());
            return;
        }
        for (String carName : snapshot.keySet()) {
            sb.append(String.format("%s : %s\n", carName, numberToHyphen(snapshot.get(carName))));
        }
        sb.append("\n");
        ioHelper.output(sb.toString());
    }

    private String numberToHyphen(int number) {
        return "-".repeat(number);
    }

    public void printWinner(int order) {
        String winnerResult = "최종 우승자 : " + findWinner(order);
        ioHelper.output(winnerResult);
    }

    private String findWinner(int order) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> snapshot = get(order);
        int max = Collections.max(snapshot.values());
        for (String name : snapshot.keySet()) {
            if (snapshot.get(name) == max) {
                result.add(name);
            }
        }
        return String.join(", ", result);
    }

    private Map<String, Integer> get(int order) {
        return new LinkedHashMap<>(this.snapshots.get(order));
    }

    public void set(int order, List<Racer> cars) {
        // 차량 순서를 유지하기 위해 LinkedHashMap을 사용한다.
        this.snapshots.add(order, new LinkedHashMap<>());
        Map<String, Integer> snapshot = this.snapshots.get(order);
        for (Racer car : cars) {
            snapshot.put(car.getName(), car.getLocation());
        }
    }
}