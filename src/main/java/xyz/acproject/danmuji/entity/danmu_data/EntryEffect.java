package xyz.acproject.danmuji.entity.danmu_data;

import java.io.Serializable;

/**
 * This class represents the Entry_Effect packet received from the Bilibili Server, which
 * shows the entry animation of guards.
 */
public class EntryEffect implements Serializable {

    private static final long serialVersionUID = 434378178226926992L;

    private String copy_writing;
    private int privilege_type;

    public EntryEffect(String copy_writing, int privilege_type){
        this.copy_writing = copy_writing;
        this.privilege_type = privilege_type;
    }

    public String getCopy_writing(){
        return copy_writing;
    }

    public void setCopy_writing(String copy_writing){
        this.copy_writing = copy_writing;
    }

    public int getPrivilege_type() {
        return privilege_type;
    }

    public void setPrivilege_type(int privilege_type) {
        this.privilege_type = privilege_type;
    }

    public String getUname(){
        return copy_writing.substring(copy_writing.indexOf('%')+1,copy_writing.lastIndexOf('%'));
    }
}
