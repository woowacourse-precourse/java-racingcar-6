package racingcar.service;

import racingcar.verify.TryNumberVerify;

public class TryNumberStringToIntService {
    public static int tryNumber = 0;
    private TryNumberScanService tryNumberScanService;

    public TryNumberStringToIntService(TryNumberScanService tryNumberScanService) {
        this.tryNumberScanService = tryNumberScanService;
    }

    public int stringToInt(String stringTryNumber) {
        TryNumberVerify tryNumberVerify = new TryNumberVerify(tryNumberScanService);
        if (tryNumberVerify.verify()) {
            return Integer.parseInt(stringTryNumber);
        }
        return 0;
    }

    public void execute() {

        tryNumber = stringToInt(tryNumberScanService.getStringTryNumber());
    }
}
