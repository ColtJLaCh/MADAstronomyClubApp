package coltonlachance.com.madskeletonapplication;

import android.content.Context;
import android.content.Intent;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**CustomRecyclerViewAdapter
 * Used to create a custom recycler view list using,
 *
 * - A .xml for each cell/row in the list (DEFAULT: "recycler_row.xml")
 * - A pojo containing the data in each cell. title, description, amount, etc... (DEFAULT: "RecyclerPojo.java")
 * - A host fragment (DEFAULT: "RecyclerFragment.java")
 *
 * @author Colton LaChance
 */
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter {

    //Create the array list that holds the Pojos
    private ArrayList<ClubPictures> recyclerPojos;
    private Context context;

    //Set pojos through public constructor
    public CustomRecyclerViewAdapter(ArrayList<ClubPictures> recyclerPojos, Context context) {
        this.recyclerPojos = recyclerPojos;
        this.context = context;
    }

    //Set ViewHolder layout parameters, and return as view
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row,null,false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layoutParams);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;

    }

    //Load recycler view cell in current position
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        final ClubPictures recyclerPojo = recyclerPojos.get(position);

        //Reinitialize CustomViewHolder, casting default holder as inherited class
        final CustomViewHolder holder1 = (CustomViewHolder) holder;
        holder1.picTV.setText((recyclerPojo.getName()));
        //holder1.picIV.setImageResource((recyclerPojo.getPicID()));

        //Begin calendar intent on clickable image view
        holder1.calendarIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.Events.TITLE, recyclerPojo.getName() + " - Club Pic was taken")
                .putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,recyclerPojo.getDateTakenInMillis())
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME,recyclerPojo.getDateTakenInMillis()+1); //Fix glitch where end time was before start time

                context.startActivity(i);
            }
        });
    }

    //Return ViewHolder size and println for debugging purposes
    @Override
    public int getItemCount() {
        System.out.println("MY LISTINGS SIZE : " + recyclerPojos.size());
        return recyclerPojos.size();
    }

    //Get resource data and store it in sub class
    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView picTV;
        protected ImageView picIV;
        protected ImageView calendarIcon;

        public CustomViewHolder(View view) {
            super(view);
            this.picTV = view.findViewById(R.id.pictureTV);
            this.picIV = view.findViewById(R.id.pictureIV);
            this.calendarIcon = view.findViewById(R.id.calendarIcon);
        }
    }
}