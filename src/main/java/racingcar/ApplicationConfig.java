package racingcar;

import racingcar.repository.Track;
import racingcar.service.RacingCarService;

public class ApplicationConfig {

    public RacingCarService racingCarService() {
        return new RacingCarService(track());
    }

    private Track track() {
        return new Track();
    }
}
