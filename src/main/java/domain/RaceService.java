package domain;

import view.InputView;

public class RaceService {
    private final InputView inputView;
    private final RanNumService ranNumService;

    RaceService() {
        inputView = new InputView();
        ranNumService = new RanNumService();
    }

}
