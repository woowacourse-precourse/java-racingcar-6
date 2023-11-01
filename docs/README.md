## :car: 미션 - 자동차 게임
### 📜 게임 진행
- 게임 시작
- 사용자가 N개의 차 생성
- 차 마다의 난수 생성
- 난수가 4이상일 때 한 칸 전진
- 사용자가 시도 횟수 입력
- 자동차의 이동 판별
- 실행 결과 출력
- 게임의 총 우승자 출력

### 📜 기능 요구 사항
1. 입력문을 출력
2. (사용자 입력) N개의 차 생성
    - 예외처리
        - 이름의 길이가 0자 초과, 5자 이하가 맞는지
        - 중복되는 이름이 있는지
        - NULL 혹은 빈 문자열인지
        - 이름 구분은 쉼표 인지
3. 자동차마다 0~9의 난수를 생성
4. 생성된 난수가 4이상일 때 한 칸 전진
5. (사용자 입력) 자동차의 이동 시도 횟수(loop)를 입력
    - 예외처리
        - 양의 정수인지
        - NULL 혹은 빈 문자열인지
6. loop 마다 자동차의 이동 판별
7. loop 마다 실행 결과를 출력
    - 형식 : "{자동차 이름} : {- * 이동 횟수}"
    - 각 회차별로 모든 자동차에 대한 실행 결과 출력
8. 게임이 끝나면 우승자 출력
    - 형식 : "최종 우승자 : {우승자}"
    - 최종 우승자가 여러 명이면, 쉼표를 기준으로 구분하여 출력

### 📜 출력 서식
1. 게임 최초 실행 시 아래 메세지를 출력
- "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"

2. 사용자 입력을 받기 전 아래 메세지를 출력
- "시도할 회수는 몇회인가요?"

3. 결과 출력
- "{자동차 이름} : {- * 이동 횟수}"
- "최종 우승자 : {우승자}"


### 📜 프로그래밍 요구 사항
라이브러리
- camp.nextstep.edu.missionutils'에서 제공하는 Randoms 및 Console API를 사용하여 구현
- 난수 생성은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용
- 사용자 입력값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용
- 프로그램 구현이 완료되면 ApplicationTest의 모든 테스트가 성공해야 함

### 📜 과제 진행 요구 사항
기능 구현 전 docs/README.md에 구현할 기능 목록을 정리

### 📜 MVC
- Controller
  - RaceGameController
- Model
  - Car
  - RacingCars
  - Result
- Util
  - Validator
- View
  - InputView
  - OutputView
- Utils
  - Validator