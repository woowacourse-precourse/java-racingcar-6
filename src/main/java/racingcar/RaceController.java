package racingcar;

public class RaceController {

    private static RaceViewer viewer;
    private String result = "실행 결과\n";
    private String[] cars;
    private int N ;

    public RaceController(RaceViewer viewer) {
        this.viewer = viewer;
    }

    public void startRace(){
        cars = viewer.getCars();
        N = viewer.nTimes();
        playRaces();
        viewer.printResult(result);
    }

    private void playRaces() {
        // Todo : Logic Implementation
        for(int i = 0 ; i < N ; i++){
           addResult();
        }
    }

    private void addResult(){
        result += calcResult();
    }

    private String calcResult() {
        // Todo : Implement Calculating Result
        return "\n";
    }

    String getResult() {
        return result;
    }


}
