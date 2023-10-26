
# 레이싱 게임

## 객체 설계

### View

#### 출력
1. 실행 결과 출력(Cars)
2. 게임 우승자 출력(List<문자>)

#### 입력
1. 차 이름 입력 기능
2. 시도할 횟 수 입력 기능

### domain

#### Game
1. 게임을 생성한다(RandomNumberGenerator)
2. 게임을 시작한다.(Cars, tryCount)
3. 게임의 우승자를 알려준다.
    1. Car의 MaxPosition을 찾고
    2. MaxPosition의 차들의 이름을 뽑아 리턴해준다.
#### Car
1. 차를 생성한다(Name)
2. 차를 움직인다.

#### Name

1. 이름을 생성한다.
    1. 이름은 5글자 이하여야한다.