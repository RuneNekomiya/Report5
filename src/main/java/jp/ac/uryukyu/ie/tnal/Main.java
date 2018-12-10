package jp.ac.uryukyu.ie.tnal;

/**
 * 異世界に転移した勇者 田中大輔、スライムとの初陣が始まる！！
 * Created by tnal on 2016/11/13. 借り物の改造品です
 */
public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero("田中 大輔", 10, 5); //「勇者勇者は道半ばで力尽きた」という謎テキストを見たのでまともな名前に変えました
        Enemy enemy = new Enemy("スライム", 6, 3);

        System.out.printf("勇者%s vs. %s\n", hero.getName(), enemy.getName());

        int turn = 0;
        while (!hero.isDead() && !enemy.isDead()) {
            turn++;
            System.out.printf("%dターン目開始！\n", turn);
            hero.attack(enemy);
            enemy.attack(hero);
        }
        System.out.println("戦闘終了");
    }
}
