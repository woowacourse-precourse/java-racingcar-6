package racingcar.dao;

import java.util.LinkedHashMap;
import java.util.Map;

public class RacingCarInformationDao {
    private LinkedHashMap<String, Integer> racingCarInformationDao = new LinkedHashMap<>();


    public void put(String name, int forward) {
        racingCarInformationDao.put(name, forward);
    }

    public int get(String name) {
        return racingCarInformationDao.get(name);
    }

    public int size() {
        return racingCarInformationDao.size();
    }

    public Map<String, Integer> getAll() {
        return racingCarInformationDao;
    }
}
