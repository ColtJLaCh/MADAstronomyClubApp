package coltonlachance.com.madskeletonapplication;

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
    private ArrayList<RecyclerPojo> recyclerPojos;

    //Set pojos through public constructor
    public CustomRecyclerViewAdapter(ArrayList<RecyclerPojo> recyclerPojos) {
        this.recyclerPojos = recyclerPojos;
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
        final RecyclerPojo recyclerPojo = recyclerPojos.get(position);

        //Reinitialize CustomViewHolder, casting default holder as inherited class
        final CustomViewHolder holder1 = (CustomViewHolder) holder;
        holder1.picTV.setText((recyclerPojo.getPicName()));
        holder1.picIV.setImageResource((recyclerPojo.getPicID()));

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

        public CustomViewHolder(View view) {
            super(view);
            this.picTV = view.findViewById(R.id.pictureTV);
            this.picIV = view.findViewById(R.id.pictureIV);
        }
    }
}