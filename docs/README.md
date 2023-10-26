# 출력

## 게임 상태에 대한 출력(OutputView)

- `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`
- `시도할 회수는 몇회인가요?`
- `실행 결과`
- 실행 과정
    - `car1.name : -`
    - `car2.name : --`
- `최종 우승자 : car1.name, car2.name`

## 입력에 대한 예외처리

- `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`
    - 예외)
    - 문자열 초과 예외
    - 공백인 경우
    - 5자 초과인 경우

- `시도할 회수는 몇회인가요?`
    - 예외)
    - 문자열 초과 예외
    - 숫자가 아닌 경우 예외
    - 범위 예외
        - 음수인 경우 예외
        - 양수여도, 자료형 int 최대 값 넘으면 예외
        - 0도 예외로 작성, 모두에게 우승 상을 줄 수는 없음
    - 소수 예외

---

# 시나리오

1. `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)` + “\n” (출력)
2. 사용자 자동차 이름 입력 받기 (입력)
    1. 입력을 split(”,”)으로 나눠서 List<String> 리턴
    2. Car 객체를 만들어서 List<String> 이름을 부여

3. `시도할 회수는 몇회인가요?` + “\n” (출력)

1. 사용자 시도할 회수 입력 받기 (입력)
    1. **Racing**에 회수 저장
2. `Randoms.pickNumberInRange(0,9)` 를 이용해서 시도할 회수 반복
3. `최종 우승자 : car1.name, [car2.name](http://car2.name)` ( 출력) - 공동 우승자 있을 수 있음

---

# 클래스 구성

## 컨트롤러(Controller)

- **CarRacingController**
    - 도메인과 도메인. 도메안과 뷰를 상호작용 시키는 클래스

## 도메인(Domain)

- **Car**
    - 각각의 자동차 객체, 자동차의 이름이 같을 수 있으므로, ID를 붙인다.
    - int **id** - 자동차 id, 이름이 같을 수 있으므로 구분한다.
    - String **name** - 자동차 이름
    - int **forwardCount** - 전진 횟수
- **NumberGenerator**
    - 랜덤 숫자를 생성하는 객체
    - static 매서드, **generateRandomNumber**() - 0에서 9까지의 정수 중 한 개의 정수 반환
- **Racing**
    - 자동차들을 가지고, Racing 하는 객체
    - int **id** - 무슨 경주인지 알 수 있도록, 고유한 번호
    - List<Car> **cars** - 경주에 참여하는 자동차 들
    - int **raceCount -** 경주를 하는 횟수
    - public void **runCarRace**()
        - NumberGenerator로 부터 랜덤 숫자를 가져와서 레이싱을 사용자가 요구한 회수 만큼 하는 매서드
- **Judgement**
    - Racing이 끝나면 결과를 판단하는 객체
    - public List<Car> determineWinner(List<Car> cars)
        - 이긴 자동차들을 리턴
        - 컨트롤러를 통해 outView 에 넘겨주면 출력

## 뷰(View)

- **InputView** : 게임에 필요한 데이터를 가져온다. (입력)
- **OutputView** : 사용자에게 출력을 담당한다. (출력)
    - `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`
    - `시도할 회수는 몇회인가요?`
    - `실행 결과`
    - 실행 과정
        - `car1.name : -`
        - `car2.name : --`
    - `최종 우승자 : car1.name, car2.name`