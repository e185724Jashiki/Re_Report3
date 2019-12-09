package jp.ac.uryukyu.ie.e185724;

public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * コンストラクタ。名前、HP、攻撃力を指定する。
     * @param name 名前
     * @param hitPoint HP
     * @param attack 攻撃力
     */
    LivingThing (String name, int hitPoint, int attack) {
        this.name = name;
        this.hitPoint = hitPoint;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, hitPoint, attack);
    }

    /* セッター，ゲッター類 */
    public void setName(String name) { this.name = name; }
    public String getName() { return this.name; }

    public void setHitPoint(int hitPoint) { this.hitPoint = hitPoint; }
    public int getHitPoint() { return this.hitPoint; }

    public void setAttack(int attack) { this.attack = attack; }
    public int getAttack() { return this.attack; }

    public void setDead(boolean dead) { this.dead = dead; }
    public boolean isDead() { return this.dead; }

    /**
     * LivingThingへ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、opponent.wounded()によりダメージ処理を実行。
     * @param opponent 攻撃対象
     */
    public void attack(LivingThing opponent) {
        int damage = (int)(Math.random() * attack);

        if (dead != true) { //死亡していない時だけ
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage) {
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }
}
