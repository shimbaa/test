# 1단계: <카드 맞추기 게임> 기본 로직 구현하기

## 준비
카드 덱에는 `1, 2, 3, 4, 5, 6, 7, 8` 8장의 카드가 각 세 장씩 총 24장이 들어있다.

게임을 시작하면 카드 덱의 카드를 랜덤하게 섞는다.

카드를 섞어둔 덱에서 카드 18장을 `순서대로` 뽑아와서 3행 6열로 배치한다.

## 플레이
### 1. 초기 시작
게임을 시작하면 화면에는 카드를 뒤집어져 있는 상태로 출력한다. 뒤집힌 마크는 X`로 표시한다. 카드 사이는 공백으로 표시한다.
```
X X X X X X
X X X X X X
X X X X X X
```

### 2. 입력 메뉴
콘솔에는 `시도 횟수`, `남은 카드`, `입력 메시지`를 표시한다.

플레이어는 `(1, 1) ~ (3, 6)` 까지 카드 위치에 해당하는 좌표를 두 번 입력한다.
```
<시도 1, 남은 카드: 16> 좌표를 두 번 입력하세요.
입력 1? (1, 1)
입력 2? (3, 6)
```
### 3. 카드 출력
플레이어가 입력한 자리에 있는 카드를 뒤집어서 카드의 종류를 보여준다.
```
5 X X X X X
X X X X X X
X X X X X 5
```
### 4. 일치한 카드 제거
만약 두 카드가 일치하면 해당 카드를 제거하고 다음 화면을 출력한다.
```
  X X X X X
X X X X X X
X X X X X
```
### 5. 종료 조건
모든 카드를 맞추거나 더 이상 남은 짝이 없을 경우 축하메시지를 출력하고 종료한다.


### 6. 반복하기
게임이 끝나지 않았을 경우 1부터 반복한다.



## 코딩 요구사항
- 반드시 컴파일 또는 실행이 가능해야 한다.

- gist는 하위 폴더 구조를 지원하지 않기 때문에 컴파일 또는 실행에 필요한 소스 코드는 모두 포함하고, 프로젝트 파일 등은 포함하지 않아도 된다.

- 자기만의 기준으로 최대한 간결하게 코드를 작성한다.

- gist에는 `README.md` 파일을 추가하고 단계별 풀이 과정 및 코드 설명, 실행 방법과 실행 결과를 서술한다.