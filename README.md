# WorldProtect

保護をワールド（ディメンション）単位で行う Spigot プラグイン

## 対応バージョン

-   1.21

## ダウンロード

以下のページからダウンロード  
`WorldProtect-x.y.z.jar`をダウンロードしてください

[最新](https://github.com/DiyCMD/WorldProtect/releases/latest)はこちら

-   [1.0.0](https://github.com/DiyCMD/WorldProtect/releases/v1.0.0)

## 使い方ですよ

### 現在保護されてるワールド一覧ですよ

`/wp`

### 保護を有効にしますよ

`/wp <world> on`

### 保護を無効にしますよ

`/wp <world> off`

### 保護を切り替えしますよ

`/wp <world> toggle`

## 保護により禁止される事象だよ～

-   プレイヤーによるブロック破壊
-   プレイヤーによるブロック設置
-   プレイヤーによるアイテムドロップ
-   エンティティによる爆発
-   エンティティによるアイテム回収
-   エンティティ(プレイヤー以外)によるアイテムドロップ
-   エンティティがダメージを受ける
-   エンティティがブロックを変更する(エンダーマン等)

## 未実装くん

これから作りたい機能くんたち

### 保護ワールドさんの保存

今は、インスタンスを超えて、保護されたワールドさんを保存出来ないよ  
つまり、サーバーさんを止めちゃったり、reload しちゃったりすると、保護情報が消えちゃうの  
大きな問題だね

### 事象くん毎の設定

ワールドさん毎に加えて、事象(イベント)くん毎に保護するか設定出来ると便利だよね

### メッセージくんの設定

今は、保護されたワールドさんで禁止された行動をすると、`このワールドは保護されてるよ！`ってメッセージが表示されるんだけど、このメッセージを変更したり、無効化したり出来るようにしたいね
