package xyz.acproject.danmuji.conf.set;

import java.io.Serializable;

/**
 * @classname: welcomeSet
 * @description: represent a welcome <user, message> pair
 * @author yangchen
 */
public class WelcomeSet implements Serializable {

    private static final long serialVersionUID = 562887876061232887L;

    private boolean is_open = false;
    private String username = null;
    private String welcome_msg = null;

    public WelcomeSet() {
        super();
        // TODO 自动生成的构造函数存根
    }

    public WelcomeSet(boolean is_open, String username, String welcome_msg){
        super();
        this.is_open = is_open;
        this.username = username;
        this.welcome_msg = welcome_msg;
    }

    public boolean isIs_open(){return is_open;}
    public void setIs_open(boolean is_open){this.is_open = is_open;}
    public String getUsername(){return username;}
    public void setUsername(String username){this.username = username;}
    public String getWelcome_msg(){return welcome_msg;}
    public void setWelcome_msg(String welcome_msg){this.welcome_msg = welcome_msg;}


}
