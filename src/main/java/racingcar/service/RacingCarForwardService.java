package racingcar.service;

import java.util.Map.Entry;
import racingcar.dao.RacingCarInformationDao;

public class RacingCarForwardService {
    private RacingCarInformationDao racingCarInformationDao;

    public RacingCarForwardService(RacingCarInformationDao racingCarInformationDao) {
        this.racingCarInformationDao = racingCarInformationDao;
    }

    public void forward() {
        for(Entry<String, Integer> entry : racingCarInformationDao.getAll().entrySet()) {
            RandomNumberPickService randomNumberPickService = new RandomNumberPickService();
            randomNumberPickService.pick();
            if(randomNumberPickService.getRandomNumber() > 4){
                entry.setValue(entry.getValue() + 1);
            }

        }
    }


}
