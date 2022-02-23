package coltonlachance.com.madskeletonapplication;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**RecyclerFragment
 * This fragment is used to host and populate the Recycler List View by initializing a series of Pojos (DEFAULT: RecyclerPojo.java)
 * As well as adding any ItemDecorations or other modifications to the RecyclerView within the onCreateView method
 *
 * @author Colton LaChance
 */
public class RecyclerFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RecyclerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecyclerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecyclerFragment newInstance(String param1, String param2) {
        RecyclerFragment fragment = new RecyclerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_recycler, container, false);


            //Pull arrayList from the database
            AstronomyDatabase db = new AstronomyDatabase(getContext());
            ArrayList<ClubPictures> recyclerPojos = db.getAllClubPictures();
            db.close();

            //Create recycler cells/rows
        /*
            recyclerPojos.add(new ClubPictures("Full Moon", R.drawable.fullmoon,1640062800000L));
            recyclerPojos.add(new ClubPictures("Midday Meteor", R.drawable.darlingmeteor,1631764800000L));
            recyclerPojos.add(new ClubPictures("Comet Debris", R.drawable.shootingstar,1625284800000L));
            recyclerPojos.add(new ClubPictures("Milky Way", R.drawable.stars,1614574800000L));
            recyclerPojos.add(new ClubPictures("Moon - Day", R.drawable.moonsky,1610254800000L));
         */

            //Get the view
            RecyclerView recyclerView = view.findViewById(R.id.recycler);

            //Modify recycler view with ItemDecorations or functionality

            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            DividerItemDecoration divider = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
            divider.setDrawable(ContextCompat.getDrawable(recyclerView.getContext(), R.drawable.rectdiv));
            recyclerView.addItemDecoration(divider);

            //Instantiate adapter and set
            CustomRecyclerViewAdapter adapter = new CustomRecyclerViewAdapter(recyclerPojos,getContext());
            recyclerView.setAdapter(adapter);

            return view;
    }
}