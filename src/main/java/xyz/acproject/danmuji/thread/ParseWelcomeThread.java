package xyz.acproject.danmuji.thread;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

import org.apache.commons.lang3.StringUtils;

import xyz.acproject.danmuji.conf.PublicDataConf;
import xyz.acproject.danmuji.conf.set.WelcomeSet;
import xyz.acproject.danmuji.entity.danmu_data.Interact;

/**
 * @ClassName ParseThankFollowThread
 * @Description TODO
 * @author YangchenYe
 * @date 2020年12月15日，下午2:42:30
 *
 * @Copyright:2020 blogs.acproject.xyz Inc. All rights reserved.
 */
public class ParseWelcomeThread extends Thread {
    //	private Logger LOGGER = LogManager.getLogger(ParseThankFollowThread.class);
    public volatile boolean FLAG = false;
    private String welcomeString = "欢迎%uNames%～";
    private Short num = 1;
    private Long delaytime = 3000L;
    private Long timestamp;
    private HashMap<String, String> welcomeMap = new HashMap<String, String>(){
        {
            put("琳裴奶兔", "欢迎奶0奶兔");
        }
    };

    private HashSet<WelcomeSet> welcomeSets;

    @Override
    public void run() {
        String welcomeStr = null;
        StringBuilder stringBuilder = new StringBuilder(300);
        Vector<Interact> interacts = new Vector<Interact>();
        synchronized (timestamp) {
            while (!FLAG) {
                if (FLAG) {
                    return;
                }
                if(PublicDataConf.webSocketProxy!=null&&!PublicDataConf.webSocketProxy.isOpen()) {
                    return;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO 自动生成的 catch 块
                }
                long nowTime = System.currentTimeMillis();
                if (nowTime - getTimestamp() < getDelaytime()) {
                } else {
                    //do something
                    //System.out.println("Thread");
                    if(PublicDataConf.welcomeInteracts.size() > 0) {
                        //System.out.println("Thread");
                        /*interacts.addAll(PublicDataConf.welcomeInteracts);
                        for (int i = 0; i < interacts.size(); i += getNum()) {
                            for (int j = i; j < i + getNum(); j++) {
                                if (j >= interacts.size()) {
                                    break;
                                }
                                stringBuilder.append(interacts.get(j).getUname()).append(",");
                            }
                            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());

                            welcomeStr =StringUtils.replace(handleWelcomeStr(getWelcomeString()), "%uNames%", stringBuilder.toString());
                            stringBuilder.delete(0, stringBuilder.length());
                            if (PublicDataConf.sendBarrageThread != null
                                    && !PublicDataConf.sendBarrageThread.FLAG) {
                                PublicDataConf.barrageString.add(welcomeStr);
                                synchronized (PublicDataConf.sendBarrageThread) {
                                    PublicDataConf.sendBarrageThread.notify();
                                }
                            }
                            welcomeStr = null;
                        }*/

                        interacts.addAll(PublicDataConf.welcomeInteracts);
                        for (int i = 0; i < interacts.size(); i += getNum()) {
                            for (int j = i; j < i + getNum(); j++) {
                                if (j >= interacts.size()) {
                                    break;
                                }
                                stringBuilder.append(interacts.get(j).getUname()).append(",");
                            }
                            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());

                            //System.out.println(stringBuilder.toString());

                            //we will only welcome if the user is present in the customized welcome mapping
                            for (WelcomeSet set: welcomeSets){
                                if (set.is_open() && set.getUsername().equals(interacts.get(0).getUname())){
                                    welcomeStr = set.getWelcome_msg();
                                }
                            }

                            stringBuilder.delete(0, stringBuilder.length());

                            if (PublicDataConf.sendBarrageThread != null
                                    && !PublicDataConf.sendBarrageThread.FLAG) {
                                PublicDataConf.barrageString.add(welcomeStr);
                                synchronized (PublicDataConf.sendBarrageThread) {
                                    PublicDataConf.sendBarrageThread.notify();
                                }
                            }
                            welcomeStr = null;
                        }



                    }
                    interacts.clear();
                    PublicDataConf.welcomeInteracts.clear();
                    break;
                }
            }
        }

    }

    /**
     * TODO: what does this method do? Does it chooses a random name from a list of names to send the barrage?
     * TODO: If so, why?
     * @param thankStr
     * @return
     */
    public String handleWelcomeStr(String thankStr) {
        String thankFollowStrs[] = null;
        if (StringUtils.indexOf(thankStr, "\n") != -1) {
            thankFollowStrs = StringUtils.split(thankStr, "\n");
        }
        if(thankFollowStrs!=null&&thankFollowStrs.length>1) {
            return thankFollowStrs[(int) Math.ceil(Math.random() * thankFollowStrs.length)-1];
        }
        return thankStr;
    }

    public String getWelcomeString() {
        return welcomeString;
    }

    public void setWelcomeString(String string) {
        this.welcomeString = string;
    }

    public Short getNum() {
        return num;
    }

    public void setNum(Short num) {
        this.num = num;
    }

    public Long getDelaytime() {
        return delaytime;
    }

    public void setDelaytime(Long delaytime) {
        this.delaytime = delaytime;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public HashSet<WelcomeSet> getWelcomeSets(){return welcomeSets;}

    public void setWelcomeSets(HashSet<WelcomeSet> welcomeSets){
        this.welcomeSets = welcomeSets;
    }



}
