import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author lenovo
 */
public class Player {
    Player(String job, int hp, int  atk, int  def) {
        //定义各种属性
        this.job = job;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
    }
    String job;
    int hp, atk,  def;
    public void attack(Player other) {
        int hurt=atk-def;
        //攻击方式
        if (hurt <= other.def)
        {
            hurt = 0;
        }
        else {
            hurt -= other.def;
        }
        other.hp -= hurt;
        System.out.println(job + "对" + other.job + "造成了" + hurt + "点伤害");
        System.out.println(job + "当前血量为:" + hp);
        System.out.println(other.job + "当前血量为:" + other.hp);
    }
    public boolean live(Player other) {
        if (hp <= 0) {
            //判断死亡
            hp=0;
            System.out.println(job + "已死亡，" + other.job + "获得战斗胜利");
            System.out.println(other.job+"获得治愈水晶！！！");
            System.out.println(other.job+"回复生命值！！！");
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner hero=new Scanner(System.in);
        //输入相关属性
        System.out.println("please input hero‘s name:");
        String name1= hero.nextLine();
        System.out.println("please input hero‘s HP:");
        int hp1=hero.nextInt();
        System.out.println("please input hero‘s ATK:");
        int atk1=hero.nextInt();
        System.out.println("please input hero‘s DEF:");
        int def1=hero.nextInt();
        Scanner monster=new Scanner(System.in);
        System.out.println("please input monster‘s name:");
        String name2= monster.nextLine();
        System.out.println("please input monster‘s HP:");
        int hp2=monster.nextInt();
        System.out.println("please input monster‘s ATK:");
        int atk2=monster.nextInt();
        System.out.println("please input monster‘s DEF:");
        int def2=hero.nextInt();
        Player p1=new Player(name1,hp1,atk1,def1);
        //存入属性
        Player p2=new Player(name2,hp2,atk2,def2);
        ArrayList<String>list= new ArrayList<>();
        while (true) {
            p1.attack(p2);
            if (p2.live(p1)) {
                break;
            }
            p2.attack(p1);
            if (p1.live(p2)) {
                break;
            }
        }
        System.out.println("第二场开始！！");
        list.add("monster1");
        list.add("monster2");
        list.add("monster3");
        System.out.println(list.get(0)+"加入战场！");
        System.out.println(list.get(1)+"加入战场！");
        System.out.println(list.get(2)+"加入战场！");
            Player p3 = new Player(list.get(0), hp1, atk2, def1);
            Player p4 = new Player(name1, hp1, atk1, def1);
            Player p5 = new Player(list.get(1), hp2, atk1, def2);
            Player p6 = new Player(list.get(2), hp2, atk2, def2);
            while (true) {
                p3.attack(p4);
                if (p4.live(p3)) {
                    break;
                }
                p4.attack(p3);
                if (p3.live(p4)) {
                    break;
                }
                p4.attack(p5);
                if (p5.live(p4)) {
                    break;
                }
                p5.attack(p4);
                if (p4.live(p5)) {
                    break;
                }
                p6.attack(p4);
                if (p4.live(p6)) {

                    break;
                }
                p4.attack(p6);
                if (p6.live(p4)) {
                    break;
                }
            }
        }
    }