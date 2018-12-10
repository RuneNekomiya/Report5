package jp.ac.uryukyu.ie.tnal;

/**
 * LivingThingをスーパークラスとしたエネミーのクラス
 * --中身の変更点はwounded()のprint内容のみ
 * --各種ステータスはLivingThingを参照して、どうぞ。
 */
public class Enemy extends LivingThing {
    public Enemy(String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド
     * 変わる部分はprintln()の内容のみ。内部処理は一切変わらない。解説はLivingThingにあるのでそちらへ
     * 但し、各種private化しているパロメーターはgetter/setterによって処理されています
     */
    @Override
    public void wounded(int damage) {
        int hitPoint = getHitPoint();
        hitPoint -= damage;
        setHitPoint(hitPoint);

        if (hitPoint < 0) {
            setDead(true);
            System.out.printf("モンスター%sは倒れた。\n", super.getName());
        }
    }

}
