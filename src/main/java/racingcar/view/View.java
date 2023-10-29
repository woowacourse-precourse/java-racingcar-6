package racingcar.view;

import java.util.List;
import racingcar.service.OneGameResultDto;

public class View {
    public void printGameStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printAttemptCountsQuestionMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printPlayResultText() {
        System.out.println("\n실행 결과");
    }

    public void printResult(OneGameResultDto resultDto) {
        String result = convertToResultForm(resultDto);
        System.out.println(result);
    }

    private String convertToResultForm(OneGameResultDto resultDto) {
        StringBuilder resultForm = new StringBuilder();
        for (int idx = 0; idx < resultDto.getNames().size(); idx++) {
            String name = resultDto.getNames().get(idx);
            long moveCount = resultDto.getTotalMoveCounts().get(idx);
            resultForm.append(name).append(" : ").append(convertMoveCountsToHyphens(moveCount)).append("\n");
        }
        return resultForm.toString();
    }

    private String convertMoveCountsToHyphens(long moveCount) {
        StringBuilder hyphens = new StringBuilder();
        while (moveCount-- > 0) {
            hyphens.append("-");
        }
        return hyphens.toString();
    }

    public void printFinalWinners(List<String> winners) {
        String finalWinnerResultForm = convertToFinalWinnerResultForm(winners);
        System.out.println(finalWinnerResultForm);
    }

    private static String convertToFinalWinnerResultForm(List<String> winners) {
        StringBuilder finalWinnerResultForm = new StringBuilder("최종 우승자 : ");
        for (int idx = 0; idx < winners.size(); idx++) {
            finalWinnerResultForm.append(winners.get(idx));
            if (idx == winners.size() - 1) {
                break;
            }
            finalWinnerResultForm.append(", ");
        }
        return finalWinnerResultForm.toString();
    }
}
