package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtilService {
	private StringUtilService() {
	}

	private static class StringUtilServiceHolder {
		private static final StringUtilService STRING_UTIL_SERVICE = new StringUtilService();
	}

	public static StringUtilService getInstance() {
		return StringUtilServiceHolder.STRING_UTIL_SERVICE;
	}

	public List<String> splitByComma(String strInput) {
		if (strInput.indexOf(",") == -1) return new ArrayList<>(Arrays.asList(strInput.trim()));
		List<String> stringList = new ArrayList<>();
		for (String strEach : strInput.split(",")) {
			stringList.add(strEach.trim());
		}

		return stringList;
	}
}
