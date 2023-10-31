package racingcar.interceptors;

import java.util.List;

public class CarNameInitInterceptor implements Interceptor<String, List<String>> {
    @Override
    public List<String> handling(String targetObject) throws IllegalArgumentException {
        // 입력 받은 값이 빈 문자열 인 경우
        if (targetObject.isEmpty()) {
            throw new IllegalArgumentException();
        }

        // 하나의 자동차만 입력 받는 경우
        if (!targetObject.contains(",")) {
            throw new IllegalArgumentException();
        }

        // 마지막 입력이 ','인 경우
        if (targetObject.charAt(targetObject.length() - 1) == ',') {
            throw new IllegalArgumentException();
        }

        // ','를 기준으로 문자열 스플릿
        return List.of(targetObject.split(","));
    }
}
