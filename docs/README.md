# Mission 2 - 자동차 경주 💨

## 👑 승리 조건
#### 마지막 시도까지의 전진 수가 가장 많은 플레이어가 승리!
#### 최종 우승자는 여러 명일 수 있다.

-----

## 👾 게임 방법
#### 1. 경주할 자동차 이름을 입력한다.
#### 2. 시도할 횟수를 입력한다.
#### 3. 각 차수 별로 전잔하면 `-`가 출력된다.
#### 4. 마지막 차수에서 `-`의 수가 가장 많은 자동차가 승리한다.

-----

## 🙋 유저 입력
### &emsp;🏎️ 경주 자동차 이름 입력
#### &emsp;&emsp;  🔸 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 이용한다.
##### &emsp;&emsp; 🚫다음 경우에 `IllegalArgumentException`
```
1. 입력한 이름이 5글자가 넘을 때
2. 
```

### &emsp;🔢 시도할 횟수 입력  
#### &emsp;&emsp; 🔸 `camp.nextstep.edu.missionutils.Console`의 `readLine()`으로 입력받은 `String`을 정수로 변환한다. 

##### &emsp;&emsp;🚫다음 경우에 `IllegalArgumentException`
```
1. 입력한 형식이 숫자가 아닐 때
2. 
```

-----

## 🚥 전진 or 정지
#### 🔹 무작위로 생성한 0에서 9사이의 숫자가 4 이상일 경우 **전진**
##### &emsp;&emsp;🚫다음 경우에 `IllegalArgumentException`
```
1. 입력한 형식이 숫자가 아닐 때
2. 
```


