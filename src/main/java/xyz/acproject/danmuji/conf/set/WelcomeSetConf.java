package xyz.acproject.danmuji.conf.set;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @Classname WelcomeSetConf
 * @Description TODO
 * @Author YangchenYe
 * @date 2020:12:15 下午3:10:20
 *
 */
public class WelcomeSetConf implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -418947096102064217L;

    private HashSet<WelcomeSet> welcomeSets;
    private boolean open = true;
    private boolean is_live_open = false;
    //map username to customized welcome message
    /*private HashMap<String, String> welcomeMap = new HashMap<String, String>(){
        {
            put("琳裴奶兔", "欢迎奶兔酱");
        }
    };*/

    //num: how many user names the barrage could contain in one message
    short num = 1;

    //private String welcomes = "欢迎%uNames%～";

    //发送欢迎延迟时间
    private double delaytime = 0;

    public WelcomeSetConf(){
        super();
    }

    public boolean isOpen() {
        return open;
    }
    public void setIs_open(boolean open) {
        this.open = open;
    }
    public boolean isIs_live_open() {
        return is_live_open;
    }
    public void setIs_live_open(boolean is_live_open) {
        this.is_live_open = is_live_open;
    }
    public short getNum() {
        return num;
    }
    public void setNum(short num) {
        this.num = num;
    }
    public double getDelaytime() {
        return delaytime;
    }
    public void setDelaytime(double delaytime) {
        this.delaytime = delaytime;
    }
    public HashSet<WelcomeSet> getWelcomeSets(){return welcomeSets;}

    public void setWelcomeSets(HashSet<WelcomeSet> welcomeSets){
        this.welcomeSets = welcomeSets;
    }

}
