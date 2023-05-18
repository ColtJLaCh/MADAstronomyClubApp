package coltonlachance.com.madskeletonapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**Listings
 * A pojo for a recycler view adapter
 *
 * Used for the Club Pictures recycler view,
 * contains parameters for picture name and ID
 *
 * @author Colton LaChance
 */
public class ClubPictures implements Parcelable {

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

    //Parceable stuff
    protected ClubPictures(Parcel in) {
        id = in.readInt();
        name = in.readString();
        picURI = in.readString();
        dateTakenInMillis = in.readLong();
    }

    public static final Creator<ClubPictures> CREATOR = new Creator<ClubPictures>() {
        @Override
        public ClubPictures createFromParcel(Parcel in) {
            return new ClubPictures(in);
        }

        @Override
        public ClubPictures[] newArray(int size) {
            return new ClubPictures[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(picURI);
        parcel.writeLong(dateTakenInMillis);
    }
}
