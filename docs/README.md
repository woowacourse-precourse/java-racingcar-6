# Java-racingcar

## Game 패키지
### Game
- `void run()`
  - 게임을 시작합니다.
- `List<Player> setPlayers()`
  - 플레이어 이름을 입력 받고 저장합니다.
  - , 를 기준으로 플레이어를 구분합니다.
- `boolean checkNameLength(String userName)`
  - 앞뒤 공백은 제거합니다.
  - 1자 이상 5자 이하인 경우 true, 아니면 false를 반환합니다.
- `boolean isForward()`
  - 전진 여부를 판단합니다.
  - 0~9 사이의 난수를 뽑아 4 이상인 경우 true, 아니면 false를 반환합니다.
- `List<Player> getChampions( List<Player> players )`
  - 플레이어 중 가장 먼 거리를 이동한 플레이어들을 반환합니다.
---
### Message
- `String distanceOfPlayer( Player player )`
  - 플레이어의 이동 거리 메시지를 생성하여 반환합니다.
- `String champions( List<Player> champions )`
  - 우승자 메시지를 생성하여 반환합니다.
---

### Player
- `String getName()`
  - 플레이어의 이름을 반환합니다.
- `int getDistance()`
  - 플레이어가 이동한 거리를 반환합니다.
- `void forward()`
  - 플레이어가 이동한 거리가 1 증가합니다.