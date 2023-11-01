package racingcar;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.MessageType.FINAL_WINNER;

public class OutputService {
    
    private String resultMessage;
    private String winnerMessage;
    
    public void print(String message) {
        System.out.println(message);
    }
    
    public String getResultMessage(List<Car> cars) {
        makeResultMessage(cars);
        return resultMessage;
    }
    
    public String getWinnerMessage(List<Car> winners) {
        makeWinnerMessage(winners);
        return winnerMessage;
    }
    
    private void makeResultMessage(List<Car> cars) {
        StringBuilder resultMessageBuilder = new StringBuilder();
        for (Car car : cars) {
            resultMessageBuilder.append(car.name).append(" : ").append(car.getLocationStatus()).append("\n");
        }
        resultMessage = resultMessageBuilder.toString();
    }
    
    private void makeWinnerMessage(List<Car> winners) {
        StringBuilder winnerMessageBuilder = new StringBuilder();
        String winnerNames = winners.stream()
                .map(car -> car.name)
                .collect(Collectors.joining(", "));
        
        winnerMessageBuilder.append(FINAL_WINNER.getMessage()).append(" : ").append(winnerNames);
        winnerMessage = winnerMessageBuilder.toString();
    }
}
