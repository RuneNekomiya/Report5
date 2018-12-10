package jp.ac.uryukyu.ie.tnal;

//申し訳ないがEnemyTestとして作成しようとしても作成できなかったのでごり押ししました
//ゴリ押しできた原因も朧げながら分かってるからいいわよね...?(再現できるとは言ってない)
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 「死者は動かず」
 *  エネミーを死亡判定にした上で攻撃を多数行わせ、ダメージ判定が発生しないことを確認したいと言う趣旨のテスト
 *  具体的にコード内容を説明するなら...
 *  1.エネミーの体力を0に、生死判定をDead側にする
 *  2.スライムに勇者を10回ほど殴らせる(乱数ダメで0~29ダメージを10回判定を行うため、防御力固杉→ダメージ入らない問題は宝くじ一等レベルで発生しない)
 *  3.assertEquals()で体力が当初と同じか調べる(=減少したか確認)。変わっていなかったらセーフ
 */
class EnemyTest {

    @Test
    public void attack() {
        System.out.println("テストするぞい(^^)");

        int heroHP = 1;
        Hero hero = new Hero("テスト勇者", heroHP, 5);
        Enemy enemy = new Enemy("テストスライム", 0, 30);
        enemy.setDead(true);
        for (int i = 0; i < 10; i++) {
            enemy.attack(hero); //乱数で0ダメージとなることもあるため、複数回実行してみる
        }
        assertEquals(heroHP, hero.getHitPoint());
    }

}