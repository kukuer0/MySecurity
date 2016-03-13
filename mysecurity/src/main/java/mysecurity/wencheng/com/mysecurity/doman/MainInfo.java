package mysecurity.wencheng.com.mysecurity.doman;

/**
 * Created by wang on 2016/3/12.
 */
public class MainInfo {
    private int icon;
    private String title;

    public MainInfo(int icon, String title) {
        this.icon = icon;
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
