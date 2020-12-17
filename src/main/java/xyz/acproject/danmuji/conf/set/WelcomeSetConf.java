package xyz.acproject.danmuji.conf.set;

import java.io.Serializable;

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

    private boolean is_open = true;
    private boolean is_live_open = false;

    //num: how many user names the barrage could contain in one message
    short num = 1;

    private String welcomes = "欢迎%uNames%～";

    //发送欢迎延迟时间
    private double delaytime = 1;

    public WelcomeSetConf(){
        super();
    }

    public WelcomeSetConf(boolean is_open, boolean is_live_open, short num, String welcomes, double delaytime){
        super();
        this.is_open = is_open;
        this.is_live_open = is_live_open;
        this.num = num;
        this.welcomes = welcomes;
        this.delaytime = delaytime;
    }

    public boolean isIs_open() {
        return is_open;
    }
    public void setIs_open(boolean is_open) {
        this.is_open = is_open;
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
    public String getWelcomes() {
        return welcomes;
    }
    public void setWelcomes(String welcomes) {
        this.welcomes = welcomes;
    }
    public double getDelaytime() {
        return delaytime;
    }
    public void setDelaytime(double delaytime) {
        this.delaytime = delaytime;
    }

}
