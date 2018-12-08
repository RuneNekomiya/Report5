package jp.ac.uryukyu.ie.tnal;

/**
 * キャラクタークラス。各種ステータスや行動判定を導入。
 * String name;    //本キャラクターの名前
 * int hitPoint;   //HP
 * int attack;     //攻撃力
 * boolean dead;   //生死状態(true=死亡)
 * Created by tnal on 2016/11/13. 借り物の改造品です。
 */
public class LivingThing {

    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     *
     * @param name      名前
     * @param maximumHP HP
     * @param attack    攻撃力
     */
    public LivingThing(String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, hitPoint, attack);
    }

    /**
     * getter and setter. ゲートの内容は特に無い。
     * isDead()はgetterメソッドと同等。生死をboolean表現しているためメソッド名をisDead()とした。
     */
    public String getName() {
        return name;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    /**
     * 敵へ攻撃するメソッド。神敵に無慈悲な刃を翳すことは宗主が命によって正当化されます。
     * attack*(0~100%)の乱数ダメージを算出し、opponent.wounded()によりダメージ処理を実行。
     *
     * @param opponent 敵のクラス
     */
    public void attack(LivingThing opponent) {
        if (!dead) { //「死んでいる奴が動く訳はないよなぁ？」攻撃する者が生きていたら攻撃を実行します。
            int damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * 但し、本クラスは死亡時メッセージが汎用的ーー簡素ーーなため、使われないことが望まれます。
     *
     * @param damage 受けたダメージ
     */
    public void wounded(int damage) {
        hitPoint -= damage;
        if (hitPoint < 0) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }

}
