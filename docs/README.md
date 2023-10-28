# ****❗ 기본 제약****

---

1. 모든 변수는 private
    1. 모든 변수는 SET/GET으로만 접근 가능하다.
2. 모든 메서드는 public
3. indent(인덴트, 들여쓰기) depth 3 미만이다.
    1. ex) while문 안에 if 문 들어있으면 depth는 2
    2. 메서드를 분리해보기
4. 3항 연산자를 사용하지 않는다.
5. 메서드가 한가지 일만 하도록 작게 만든다.
6. JUnit 5 / AssertJ 이용해서 본인이 정리한 ****🛠기능목록****이 정상 동작함을 테스트 코드로 확인한다.
    1. `test/java/study` 참고하여 테스트 도구 사용법 학습 후 테스트 구현

# ****🛠 기능 목록****

---

## 🏎 Car `Class Car`

- 변수
    - `String name`
    - `int position`
- 메서드
    - `void move(int distance)`
        - 차 위치 이동

## 🎮 Game `Class Game`

- 변수
    - `int trial`
    - `List <Car> cars`
- 메서드
    - 경주 자동차 이름 입력받기
    - 시도횟수 입력받기
    - 시도 횟수만큼 실행하기
    - 각 차수 별 실행 결과 출력하기
    - 우승자 판별
    - 우승자 출력하기

# ****📝 피드백****