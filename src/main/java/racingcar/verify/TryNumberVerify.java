package racingcar.verify;

import java.util.regex.Pattern;
import racingcar.service.TryNumberScanService;

public class TryNumberVerify {

    private TryNumberScanService tryNumberScanService;

    public TryNumberVerify(TryNumberScanService tryNumberScanService) {
        this.tryNumberScanService = tryNumberScanService;
    }

    public boolean verify() {
        return Pattern.matches("^\\d+$", tryNumberScanService.getStringTryNumber());
    }
}
