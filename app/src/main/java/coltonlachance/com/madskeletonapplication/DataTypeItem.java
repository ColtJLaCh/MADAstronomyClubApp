package coltonlachance.com.madskeletonapplication;

/**DataTypeItem
 * An item for a custom list view
 * Contains a title and description
 * @author Colton LaChance
 */
public class DataTypeItem {
    private String title;
    private String desc;

    public DataTypeItem(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String toString() {
        return getTitle();
    }
}