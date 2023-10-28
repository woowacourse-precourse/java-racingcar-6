package racingcar.verify;

import java.util.regex.Pattern;
import racingcar.service.RacingCarNameScanService;

public class RacingCarNameVerify {
    private RacingCarNameScanService racingCarNameScanService;

    public RacingCarNameVerify(RacingCarNameScanService racingCarNameScanService) {
        this.racingCarNameScanService = racingCarNameScanService;
    }

    public boolean verify() {
        if (!Pattern.matches("^[a-zA-Z0-9]{1,5}(,[a-zA-Z0-9]{1,5})+", racingCarNameScanService.getRacingCarNames())){
            return false;
        }
        return true;
    }
}
