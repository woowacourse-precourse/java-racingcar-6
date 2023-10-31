package racingcar.view;

import racingcar.core.GenerateHighScores;
import racingcar.core.GenerateRacer;
import racingcar.entity.*;
import racingcar.tool.InputTool;

import java.util.Arrays;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        OutputView.outputForRaceStart();
        raceBefore();
    }

    private static void raceBefore(){
        conductRace(racerNameForm(),raceCountForm());
    }
    private static void conductRace(List<String> racerNameList,RaceCount raceCount){
        for (int i = 0; i<raceCount.inputRaceCount(); i++){
            race(racerNameList);
        }
        raceDone();
    }
    private static void raceDone(){
        generateRacingResult();
        generateHighScoreRacer();
    }

    private static void race(List<String> racerNameList){
        generateRacer(racerNameList);
        for (String racerName:racerNameList){
            Racer currentRacer = Racer.getInstance(racerName);
            Racing racing = new Racing(currentRacer);
            racing.racingByRacer();
            generateOutputRoundResult(currentRacer);
        }
        RoundResult.writeLineBreak();
    }

    private static void generateOutputRoundResult(Racer racer){
        RoundResult.writeRoundResult(racer);
    }

    private static List<String> racerNameForm(){
        String inputRacerNameList = InputTool.readLineByConsole();
        RacerNameList racerValidate = new RacerNameList(inputRacerNameList);
        racerValidate.validateRacerNameList();
        return Arrays.asList(inputRacerNameList.split(","));
    }

    private static RaceCount raceCountForm(){
        OutputView.outputForRaceCount();
        String raceCountInput = InputTool.readLineByConsole();
        OutputView.outputForLineBreak();
        RaceCount.validateRaceCount(raceCountInput);
        return new RaceCount(Integer.parseInt(raceCountInput));
    }

    private static void generateRacer(List<String> racerNameList){
        racerNameList
                .forEach(racerName->{
                    generateRacerByInputValue().generateRacerByInputValue(racerName);
                });
    }
    private static GenerateRacer generateRacerByInputValue(){
        return Racer::getInstance;
    }

    private static void generateRacingResult(){
        OutputView.outputForRacingResult(RoundResult.getResultOfRound().toString());
    }

    private static void generateHighScoreRacer(){
        List<Racer> racersWithHighScore = RaceStatus.racersWithHighScore();
        GenerateHighScores highScoreRacers = new GenerateHighScores(racersWithHighScore);
        OutputView.outputForHighScoreRacers(highScoreRacers.generateHighScoresByRacerList());
    }
}
