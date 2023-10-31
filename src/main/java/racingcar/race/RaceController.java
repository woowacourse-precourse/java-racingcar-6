package racingcar.race;

public class RaceController {
    private static RaceViewer viewer;
    private static RaceService service;

    public RaceController(RaceViewer viewer, RaceService service) {
        this.viewer = viewer;
        this.service = service;
    }

    public void startRace(){
        service.initializeCars(viewer.getCars());
        String result = service.playRaces(viewer.nTimes());
        result += service.getWinner();
        viewer.printResult(result);
    }
}
