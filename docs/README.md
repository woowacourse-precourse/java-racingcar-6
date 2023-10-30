# 학습이 필요한 부분
### annotation, collection, Junit & assertJ

# 기능구현

## 0. 초기 입력값처리
경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun

-> string으로 받고 trim, split을 사용하여 처리한다.

- Error case 생각해보기
1. 5글자 이하인지.
2. 입력글자가 없을경우

시도할 회수 : 5
-> string으로 받고 trim. 

- Error case 생각해보기 
1. 숫자가 아닌경우(공백, 숫자가 아닌 문자)
2. 숫자의 범위 처리(음수).

## 1. 자동차 이름과 자동차의 현재 위치 상태를 담을 Car라는 객체를 만든다.
Car의 역할과 책임은 Game객체와 협력하여 이동을 하게 된다. 

## 2. random number를 만들어주는 Game클래스의 객체를 만든다. 
Game의 역할은 랜덤넘버를 생성하고 입력값과 비교하여 Car객체에게 행동에 관한 message를 전달한다. 
-> isequal이라는 String의 기본 method를 사용할 것.

모든 이동이 끝나면 Game객체는 Car객체들과의 상호작용을 통해 결과를 출력해준다.

## 3. message를 처리해주는 Message클래스의 객체를 만든다.
Message의 역할과 책임은 메시지 출력 요청이 오면 화면에 출력해준다. 