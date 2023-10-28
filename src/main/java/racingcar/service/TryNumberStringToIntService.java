package racingcar.service;

public class TryNumberStringToIntService {
    public static int tryNumber = 0;
    private TryNumberScanService tryNumberScanService;

    public TryNumberStringToIntService(TryNumberScanService tryNumberScanService) {
        this.tryNumberScanService = tryNumberScanService;
    }

    public int stringToInt(String stringTryNumber) {
        return Integer.parseInt(stringTryNumber);
    }

    public void execute() {

        tryNumber = stringToInt(tryNumberScanService.getStringTryNumber());
    }
}
