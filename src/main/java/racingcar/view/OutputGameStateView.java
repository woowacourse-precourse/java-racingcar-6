package racingcar.view;

public class OutputGameStateView {

	private OutputGameStateView() {
	}

	private static class OutputGameStateViewHolder {
		private static final OutputGameStateView OUTPUT_GAME_STATE_VIEW = new OutputGameStateView();
	}

	public static OutputGameStateView getInstance() {
		return OutputGameStateViewHolder.OUTPUT_GAME_STATE_VIEW;
	}

	public void printCarRacing(String result) {
		System.out.println(result);
	}
}
