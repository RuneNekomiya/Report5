package jp.ac.uryukyu.ie.tnal;

/**
 * LivingThingをスーパークラスとした勇者のクラス。
 * 中身の変更点はwounded()のprint内容のみ。英雄だっていつか死ぬ、勇者も例外ではないのだ。
 * 各種ステータスはLivingThingを参照して、どうぞ。
 */
public class Hero extends LivingThing {
    public Hero(String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 変わる部分はprintln()の内容のみ。内部処理は一切変わらない。詳細を知りたければLivingThingを検索検索ゥ！
     * 但し、各種private化しているパロメーターはgetter/setterによって処理されています。
     */
    @Override
    public void wounded(int damage) {
        int hitPoint = getHitPoint();
        hitPoint -= damage;
        setHitPoint(hitPoint);

        if (hitPoint < 0) {
            setDead(true);
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", super.getName());
        }
    }

}
