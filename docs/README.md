# 자동차 경주 게임

## 구현 기능
### 게임 시작
> 사용자 입력
- [x] n개의 자동차 이름
    - [x] 쉼표(,)를 기준으로 구분
    - [x] [예외 처리] 5자를 초과한 경우
- [x] 시도 횟수

### 게임 진행
> 자동차
- [x] 전진: 0에서 9 사이의 무작위 값이 4 이상일 경우
  - [x] 각 자동차의 무작위 값 생성
  - [x] 값이 4 이상일 경우 전진
- [x] 정지: 그 외
> 출력
```text
car1 : --
car2 : ----
car3 : ---
```
- [ ] 현재 레이싱 상황 출력

### 게임 종료
> 출력
- [ ] 우승자
    - [ ] 두 명 이상인 경우, 쉼표로 구분

### 예외
- [x] 사용자가 잘못된 값을 입력할 경우, IllegalArgumentException 발생 & 애플리케이션 종료

### 기타
- [x] MVC 패턴 적용

<br>

---
## 프로그래밍 요구사항
- JDK 17 ver.
- build.gradle 변경 X
- 외부 라이브러리 사용 X
- 프로그램 종료 시 System.exit() 호출 X
- 구현 완료 후 ApplicationTest의 모든 테스트 통과해야 함
- indent(들여쓰기) depth가 2 이하여야 함
    - ex. while () { for() { ... } } -> depth 2
    - 함수를 분리하라
- 3항 연산자 사용 X
- 메서드는 한 가지 일만 하도록 최대한 작게 구현
- 테스트 코드를 작성하여 기능의 정상 동작 확인

### 라이브러리
`camp.nextstep.edu.missionutils`에서 제공하는 Randoms 및 Console API를 사용
- Random 값 추출: camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용
- 사용자가 입력하는 값: camp.nextstep.edu.missionutils.Console의 readLine()을 활용