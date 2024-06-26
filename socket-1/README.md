## 概要

シェフ(サーバー)に注文をすると料理が返ってくるプログラム

## 動作内容
serverとclientでポート番号を入力する。
```
ポートを入力してください(5000など) → 5050
localhostの5050番ポートに接続を要求します
接続されました
```

clientは注文するメニュー名と、シェフに伝えたいことを自由に入力する。
```
< 注文を送りましょう！お会計をする場合は"checkout"と入力してください！
< 注文する料理を入力してください(例:オムライス) ↓
カレー
< シェフへのメッセージをどうぞ！(例:美味しく作ってね) ↓
中辛でチーズトッピングお願いします
```

ランダムな時間経過が示され、料理が届く。料理の完成度は三段階ありランダムで決まる。
```
シェフ( -ω-){ "中辛でチーズトッピングお願いします"？そうか、私に任せなさい！
...(18分後)...
シェフ( -ω-)_旦{ 完成だ！
〈とっても美味しそうなカレー〉を受け取りました！
```
```
〈ふつうのカレー〉を受け取りました！
```
```
〈丸焦げのカレー〉を受け取りました！
```

繰り返し注文ができる。
```
シェフ( -ω-){ 他にご注文は？
< 注文を送りましょう！お会計をする場合は"checkout"と入力してください！
< 注文する料理を入力してください(例:オムライス) ↓
...繰り返し
```

終了するときはお会計を表す"checkout"と入力。
```
< 注文する料理を入力してください(例:オムライス) ↓
checkout
< ご来店ありがとうございました！
< シェフ( -ω-){ また来てね
```

## 動作結果
ChefTCPClient.java
```
ポートを入力してください(5000など) → 5050
localhostの5050番ポートに接続を要求します
接続されました
< 注文を送りましょう！お会計をする場合は"checkout"と入力してください！
< 注文する料理を入力してください(例:オムライス) ↓
カレー
< シェフへのメッセージをどうぞ！(例:美味しく作ってね) ↓
中辛でチーズトッピングお願いします

シェフ( -ω-){ "中辛でチーズトッピングお願いします"？そうか、私に任せなさい！
...(18分後)...
シェフ( -ω-)_旦{ 完成だ！
〈とっても美味しそうなカレー〉を受け取りました！

シェフ( -ω-){ 他にご注文は？
< 注文を送りましょう！お会計をする場合は"checkout"と入力してください！
< 注文する料理を入力してください(例:オムライス) ↓
checkout
< ご来店ありがとうございました！
< シェフ( -ω-){ また来てね
```
ChefTCPServer.java
```
ポートを入力してください(5000など) → 5050
localhostの5050番ポートで待機します
接続しました。相手の入力を待っています......
注文料理名：カレー
届いたメッセージ：中辛でチーズトッピングお願いします
```