package coltonlachance.com.madskeletonapplication;

/**Listings
 * A pojo for a recycler view adapter
 *
 * Used for the Club Pictures recycler view,
 * contains parameters for picture name and ID
 *
 * @author Colton LaChance
 */
public class ClubPictures {

    private int id;
    private String name;
    private String picURI;
    private long dateTakenInMillis; //Will convert in future to method that calculates using Java Calendar class

    public ClubPictures(int id, String name, String picURI, long dateTakenInMillis) {
        this.id = id;
        this.name = name;
        this.picURI = picURI;
        this.dateTakenInMillis = dateTakenInMillis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String picName) {
        this.name = picName;
    }

    public String getPicURI() {
        return picURI;
    }

    public void setPicURI(String picURI) {
        this.picURI = picURI;
    }

    public long getDateTakenInMillis() {
        return dateTakenInMillis;
    }

    public void setDateTakenInMillis(long dateTakenInMillis) {
        this.dateTakenInMillis = dateTakenInMillis;
    }
}
