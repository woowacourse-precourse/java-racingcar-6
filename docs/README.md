
## ✏️ 구현할 기능 목록

---

### [ Domain ]
#### Car
- [X] 자동차는 움직일 수 있다. Car#go
#### Random
- [X] 무작위 값을 만든다. Random#createNumber
#### Referee
- [X] 우승자를 판별한다. Referee#judgeWinner
- [X] 값이 4이상인지 4미만인지 판단한다. Referee#judgeNumber
#### Announcer
- [X] 우승자 알림 멘트를 만들 수 있다. Announcer#generateWinnerAnnouncement
- [X] 안내 멘트를 만들 수 있다. Announcer#generateLocationAnnouncement

![자동차 경주](https://github.com/WE-ARE-RACCOONS/postgraduate-back/assets/110026001/2514227b-3a74-4176-ad5d-9aa84d1212b2)

---
### [ View ]
#### INPUT
- [X] 경주 할 자동차 이름을 입력받는다.
- [X] 시도할 횟수를 입력받는다.

#### OUTPUT
- [X] 각 차수별 실행 결과를 출력한다.
- [X] 우승자 안내 문구를 출력한다.
---
### [ Controller ]
- [X] 경주를 시작한다.

---
### [ Validator ]
- [X] 입력받은 자동차 이름의 길이가 5이하인지 검사한다.
- [X] 자동차 이름이 비어있거나 공백으로만 이루어져 있는지 검사한다.
- [X] 이름이 중복되는지 검사한다.
- [X] 입력받은 실행 횟수가 int의 양수 범위인지 검사한다.
- [X] 입력 받은 실행 횟수가 숫자인지 검사한다.

<br>

---
## 📢 확장성
 - [X] 전진 조건 x (x >= `4`) → `N`
 - [X] 무작위 수 범위 `0` <= x <= `9` → `N` <= x <= `M` (단, `N` < `M`)
 - [X] 자동차 이름 구분 기준 `,` → 다른 기호
 - [X] 최종 우승자 구분 기준 `,` → 다른 기호