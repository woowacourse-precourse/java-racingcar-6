package racingcar.dao;

import java.util.ArrayList;
import java.util.List;

public class WinnerInformationDao {
    private List<String> winnerInformationDao = new ArrayList<>();

    public void add(String name) {
        winnerInformationDao.add(name);
    }

    public String get(int number) {
        return winnerInformationDao.get(number);
    }

    public int size() {
        return winnerInformationDao.size();
    }

    public List<String> getAll() {
        return winnerInformationDao;
    }
}
