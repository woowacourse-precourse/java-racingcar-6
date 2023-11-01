package Service;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingService {
    private final Repository repository;

    public RacingService() {
        this.repository = new Repository();
    }

    public void addCar(String[] s) {
        List<String> cars = repository.getCars();
        List<String> results = repository.getResults();
        cars.addAll(Arrays.asList(s));
        for (int i = 0; i < cars.size(); i++) {
            results.add(i, "");
        }
    }

    public List<String> getCar() {
        return repository.getCars();
    }

    public List<String> racing() {
        List<String> results = repository.getResults();
        for (int k = 0; k < results.size(); k++) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                results.set(k, results.get(k)+"-");
            }
        }
        return results;
    }

    public int getMaxSize() {
        List<String> results = repository.getResults();
        int maxSize = 0;
        for (String result : results) {
            if (maxSize <= result.length()) {
                maxSize= result.length();
            }
        }
        return maxSize;
    }

    public List<String> findWinner(int maxSize) {
        List<String> winner = new ArrayList<>();
        List<String> results = repository.getResults();
        List<String> cars = repository.getCars();
        for (int i = 0; i < results.size(); i++) {
            if (results.get(i).length() == maxSize) {
                winner.add(cars.get(i));
            }
        }
        return winner;
    }
}
