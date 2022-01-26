package coltonlachance.com.madskeletonapplication;

/**Listings
 * A pojo for a recycler view adapter
 * @author Colton LaChance
 */
public class RecyclerPojo {
    private String picName;
    private int picID;

    public RecyclerPojo(String picName, int picID) {
        this.picName = picName;
        this.picID = picID;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public int getPicID() {
        return picID;
    }

    public void setPicID(int picID) {
        this.picID = picID;
    }

}
