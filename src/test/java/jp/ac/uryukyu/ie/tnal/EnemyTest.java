package jp.ac.uryukyu.ie.tnal;

//申し訳ないがEnemyTestとして作成しようとしても作成できなかったのでごり押ししました。
//ゴリ押しできた原因も朧げながら分かってるからいいわよね...?(再現できるとは言ってない)
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {

    @Test
    public void attack() {
        System.out.println("テストするぞい(^^)");

        /**
         *  エネミーを死亡判定にした上で攻撃を10回行わせます。
         *  理想は勇者がダメージを喰らわない状態(assertEquals()によって判定)
         */
        int heroHP = 1;
        Hero hero = new Hero("テスト勇者", heroHP, 5);
        Enemy enemy = new Enemy("テストスライム", 0, 30);
        enemy.setDead(true);
        for (int i = 0; i < 10; i++) {
            enemy.attack(hero); //乱数で0ダメージとなることもあるため、複数回実行してみる。
        }
        assertEquals(heroHP, hero.getHitPoint());
    }

}