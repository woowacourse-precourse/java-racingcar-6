
## ✏️ 구현할 기능 목록

---

### [ Domain ]
- [ ] 자동차는 움직일 수 있다.
    - [ ] 전진한다. Car#go
    - [ ] 멈춘다. Car#stop
- [ ] 무작위 값을 만든다. Random#createNumber
- [ ] 우승자를 판별한다. Referee#judgeWinner
    - [ ] 자동차의 움직임을 판단한다. Referee#judgeCarMovement
      - [ ] 값이 4이상인지 4미만인지 판단한다. Referee#judgeNumber
- [ ] 우승자를 알릴 수 있다. Announcer#announceWinner
    - [ ] 안내 멘트를 만들 수 있다. Announcer#createAnnouncement
        - [ ] 우승자를 쉼표로 구분할 수 있다. seperateWithSymbol

![자동차 경주](https://github.com/ay-eonii/ProblemSolving/assets/110026001/132efa0a-0b17-4e3a-97d5-e720368b5f52)

---
### [ View ]
#### INPUT
- [ ] 경주 할 자동차 이름을 입력받는다.
- [ ] 시도할 횟수를 입력받는다.

#### OUTPUT
- [ ] 각 차수별 실행 결과를 출력한다.
- [ ] 우승자 안내 문구를 출력한다.
---
### [ Controller ]
- [ ] 경주를 시작한다.

---
### [ Validator ]
- [ ] 입력받은 값에 대해 유효성 검사를 한다.

<br>

---
## 📢 확장성
 - [ ] 전진 조건 x (x >= `4`) → `N`
 - [ ] 무작위 수 범위 `0` <= x <= `9` → `N` <= x <= `M` (단, `N` < `M`)
 - [ ] 자동차 이름 구분 기준 `,` → 다른 기호
 - [ ] 최종 우승자 구분 기준 `,` → 다른 기호