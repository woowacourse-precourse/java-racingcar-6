package racingcar.verify;

import java.util.regex.Pattern;
import racingcar.service.RacingCarNameScanService;

public class RacingCarNameVerify {
    private RacingCarNameScanService racingCarNameScanService;

    public RacingCarNameVerify(RacingCarNameScanService racingCarNameScanService) {
        this.racingCarNameScanService = racingCarNameScanService;
    }

    public boolean verify() {
        return Pattern.matches("^\\w{1,5}(,\\w{1,5})+", racingCarNameScanService.getRacingCarNames());
    }
}
