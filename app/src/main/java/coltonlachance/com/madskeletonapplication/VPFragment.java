package coltonlachance.com.madskeletonapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**VPFragment
 * A fragment to be instantiated through a ViewPager2
 * Uses "CustomViewPageAdapter.java" by default to initialize with specified parameters
 * @author Colton LaChance
 */
public class VPFragment extends Fragment {

    final static int MERCURY = 0;
    final static int VENUS = 1;
    final static int MARS = 2;
    final static int JUPITER = 3;
    final static int SATURN = 4;
    final static int URANUS = 5;
    final static int NEPTUNE = 6;

    public ListView list;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PLANET_NUM = "0";
    private static final String ARG_PLANET_NAME = "planet_name";
    private static final String ARG_PLANET_PICTURE = "planet_picture";

    // TODO: Rename and change types of parameters
    private int mPlanetNum;
    private String mPlanetName;
    private int mPlanetPicture;

    public VPFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param mPlanetNum Parameter 1
     * @param mPlanetName  Parameter 2
     * @param mPlanetPicture  Parameter 3
     * @return A new instance of fragment VPFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VPFragment newInstance(int mPlanetNum, String mPlanetName, int mPlanetPicture) {
        VPFragment fragment = new VPFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PLANET_NUM, mPlanetNum);
        args.putString(ARG_PLANET_NAME, mPlanetName);
        args.putInt(ARG_PLANET_PICTURE, mPlanetPicture);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPlanetNum = getArguments().getInt(ARG_PLANET_NUM);
            mPlanetName = getArguments().getString(ARG_PLANET_NAME);
            mPlanetPicture = getArguments().getInt(ARG_PLANET_PICTURE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_v_p, container, false);

        list = view.findViewById(R.id.dataTypeList);

        ArrayList<DataTypeItem> dataTypeList = new ArrayList<DataTypeItem>();

        switch(mPlanetNum) {
            case MERCURY:
                dataTypeList.add(new DataTypeItem("Image on homepage", "Created using Paint.net."));
                dataTypeList.add(new DataTypeItem("TIP #1 Image", "From https://pixabay.com/photos/dark-rain-windows-glass-windows-1850684/, edited."));
                dataTypeList.add(new DataTypeItem("TIP #2 Image", "From https://pixabay.com/photos/baseball-field-sports-field-1495657/, edited."));
                dataTypeList.add(new DataTypeItem("TIP #3 Image", "From https://pixabay.com/photos/construction-site-construction-worker-3279650/, edited."));
                dataTypeList.add(new DataTypeItem("Concrete Buddy App", "Created solely by Colton LaChance."));
            break;

            case VENUS:

            break;
        }

        CustomListAdapter adapter = new CustomListAdapter(getContext(), dataTypeList);

        list.setAdapter(adapter);

        //Insert param info into resources like TextViews here
        //EXAMPLE: if (mParam1 != null) titleTV.setText(mParam1);

        TextView planetNameTV = view.findViewById(R.id.planetNameTV);
        ImageView planetIV = view.findViewById(R.id.planetIV);

        if (mPlanetName != null) planetNameTV.setText(mPlanetName);
        if (mPlanetPicture != -1) planetIV.setImageResource(mPlanetPicture);

        return view;
    }

    public class CustomListAdapter extends ArrayAdapter<DataTypeItem> {
        public CustomListAdapter(Context context, ArrayList<DataTypeItem> items) {
            super(context,0,items);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            DataTypeItem item = getItem(position);

            /*

            ---------------COMMENT AND UNCOMMENT HERE!-----------------

            */
            if (convertView == null) {
                //convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_view,parent,false);
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_view,parent,false);
            }

            TextView name = (TextView) convertView.findViewById(R.id.listTitle);
            name.setText(item.getTitle());
            TextView desc = (TextView) convertView.findViewById(R.id.listDesc);
            desc.setText(item.getDesc());

            return convertView;
        }
    }
}