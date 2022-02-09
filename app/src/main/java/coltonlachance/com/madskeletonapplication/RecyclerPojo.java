package coltonlachance.com.madskeletonapplication;

/**Listings
 * A pojo for a recycler view adapter
 *
 * Used for the Club Pictures recycler view,
 * contains parameters for picture name and ID
 *
 * @author Colton LaChance
 */
public class RecyclerPojo {
    private String picName;
    private int picID;

    private long dateTakenInMillis; //Will convert in future to method that calculates using Java Calendar class

    public RecyclerPojo(String picName, int picID, long dateTakenInMillis) {
        this.picName = picName;
        this.picID = picID;
        this.dateTakenInMillis = dateTakenInMillis;
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


    public long getDateTakenInMillis() {
        return dateTakenInMillis;
    }

    public void setDateTakenInMillis(long dateTakenInMillis) {
        this.dateTakenInMillis = dateTakenInMillis;
    }
}
