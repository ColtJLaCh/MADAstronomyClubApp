package coltonlachance.com.madskeletonapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AstronomyDatabase extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "astronomyClub";


    //Tables
    public static final String TABLE_CLUB_PICTURES = "pictures";

    //Table Columns
    public static final String COLUMN_ID = "id"; //Primary key

    //Club pictures
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_URI = "picURI";
    public static final String COLUMN_DATE = "dateTakenInMillis";

    //Create table constant
    public static final String CREATE_CLUB_PICTURES_TABLE = "CREATE TABLE " +
            TABLE_CLUB_PICTURES + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_NAME + " TEXT, " +
                COLUMN_URI+ " TEXT, " +
                /*
                    I saw in your notes about the lack of date type and the documentation
                    on how to implement it, but for now I'll stick to the timeInMillis since last epoch
                 */
                COLUMN_DATE + " INTEGER " +
            ")";

    public AstronomyDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CLUB_PICTURES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addClubPicture(ClubPictures picture) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, picture.getName());
        values.put(COLUMN_URI, picture.getPicURI());
        values.put(COLUMN_DATE, picture.getDateTakenInMillis());
        db.insert(TABLE_CLUB_PICTURES, null, values);
        db.close();
    }

    public ClubPictures getClubPicture(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        ClubPictures clubPictures = null;
        Cursor cursor = db.query(TABLE_CLUB_PICTURES, new String[] {
            COLUMN_ID,
            COLUMN_URI,
            COLUMN_DATE
            },COLUMN_ID + "= ?",
        new String[]{String.valueOf(id)},null,null,null);

        if (cursor.moveToFirst()) {
            clubPictures = new ClubPictures(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getLong(3)
            );
        }
        db.close();
        return clubPictures;
    }

    public ArrayList<ClubPictures> getAllClubPictures() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_CLUB_PICTURES, null);

        ArrayList<ClubPictures> clubPictures = new ArrayList<>();
        while(cursor.moveToNext()) {
            clubPictures.add(new ClubPictures(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getLong(3)
            ));
        }

        db.close();
        return clubPictures;
    }
}
