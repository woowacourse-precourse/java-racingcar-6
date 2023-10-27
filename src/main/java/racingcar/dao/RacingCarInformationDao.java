package racingcar.dao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RacingCarInformationDao {
    private LinkedHashMap<String, Integer> racingCarInfoDao = new LinkedHashMap<>();


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
