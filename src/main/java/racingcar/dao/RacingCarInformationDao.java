package racingcar.dao;

import java.util.HashMap;
import java.util.Map;

public class RacingCarInformationDao {
    private Map<String, Integer> racingCarInfoDao = new HashMap<>();


    public void put(String name, int forward) {
        racingCarInfoDao.put(name, forward);
    }

    public int get(String name) {
        return racingCarInfoDao.get(name);
    }

    public int size() {
        return racingCarInfoDao.size();
    }

    public Map<String, Integer> getAll() {
        return racingCarInfoDao;
    }
}
