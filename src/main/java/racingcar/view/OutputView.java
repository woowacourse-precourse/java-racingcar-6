package racingcar.view;

import java.util.List;
import racingcar.dto.OneGameResultsDto;
import racingcar.dto.ResultDto;

public class OutputView {
    private static final String HYPHEN = "-";
    private static final String RESULT_FORM = "%s : %s%n";

    public void printPlayResultText() {
        System.out.println("\n실행 결과");
    }

    public void printResult(OneGameResultsDto resultDto) {
        for (ResultDto result : resultDto.getResults()) {
            System.out.printf(RESULT_FORM, result.getName(), HYPHEN.repeat(result.getPosition()));
        }
        System.out.println();
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
