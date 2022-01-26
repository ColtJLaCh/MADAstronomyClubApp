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
 *
 * Contains a title, image asset and custom ListView initialized in the onCreateViewMethod
 *
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

        //Find the ListView resource
        list = view.findViewById(R.id.dataTypeList);

        //Instantiate the ArrayList used to insert into the ListView
        ArrayList<DataTypeItem> dataTypeList = new ArrayList<DataTypeItem>();

        //Populate the list based on the current ViewPager position, through the mPlanetNum parameter
        switch(mPlanetNum) {
            case MERCURY:
                dataTypeList.add(new DataTypeItem("DISTANCE:", "77 million km"));

                dataTypeList.add(new DataTypeItem("MORNING-RANGE", "Oct. 3 - Oct. 17"));
                dataTypeList.add(new DataTypeItem("MORNING-TIME", "~1h < Sunrise"));
                dataTypeList.add(new DataTypeItem("MORNING-DIR", "EAST"));

                dataTypeList.add(new DataTypeItem("EVENING-RANGE", "April 18 - May 10"));
                dataTypeList.add(new DataTypeItem("EVENING-TIME", "~1h > Sunset"));
                dataTypeList.add(new DataTypeItem("EVENING-DIR", "WEST"));
            break;

            case VENUS:
                dataTypeList.add(new DataTypeItem("DISTANCE:", "61 million km"));

                dataTypeList.add(new DataTypeItem("MORNING-RANGE", "Jan. 17 - Aug. 27"));
                dataTypeList.add(new DataTypeItem("MORNING-TIME", "~1:30h < Sunrise"));
                dataTypeList.add(new DataTypeItem("MORNING-DIR", "EAST"));

                dataTypeList.add(new DataTypeItem("EVENING-RANGE", "Dec. 20 - Dec. 31"));
                dataTypeList.add(new DataTypeItem("EVENING-TIME", "~1h > Sunset"));
                dataTypeList.add(new DataTypeItem("EVENING-DIR", "WEST"));
            break;

            case MARS:
                dataTypeList.add(new DataTypeItem("DISTANCE:", "54.6 million km"));

                dataTypeList.add(new DataTypeItem("MORNING-RANGE", "Jan. 1 - Dec. 7"));
                dataTypeList.add(new DataTypeItem("MORNING-TIME", "~0:30m < Sunrise"));
                dataTypeList.add(new DataTypeItem("MORNING-DIR", "EAST"));

                dataTypeList.add(new DataTypeItem("EVENING-RANGE", "Dec. 8 - Dec. 31"));
                dataTypeList.add(new DataTypeItem("EVENING-TIME", "~1h > Sunset"));
                dataTypeList.add(new DataTypeItem("EVENING-DIR", "WEST"));
            break;

            case JUPITER:
                dataTypeList.add(new DataTypeItem("DISTANCE:", "588 million km"));

                dataTypeList.add(new DataTypeItem("MORNING-RANGE", "Mar. 26 - Sept. 25"));
                dataTypeList.add(new DataTypeItem("MORNING-TIME", "~1:30m < Sunrise"));
                dataTypeList.add(new DataTypeItem("MORNING-DIR", "EAST"));

                dataTypeList.add(new DataTypeItem("EVENING-RANGE", "Sept. 26 - Dec. 31"));
                dataTypeList.add(new DataTypeItem("EVENING-TIME", "~0:40m < Sunset"));
                dataTypeList.add(new DataTypeItem("EVENING-DIR", "WEST"));
            break;

            case SATURN:
                dataTypeList.add(new DataTypeItem("DISTANCE:", "1.2 billion km"));

                dataTypeList.add(new DataTypeItem("MORNING-RANGE", "Feb. 22 - Aug. 13"));
                dataTypeList.add(new DataTypeItem("MORNING-TIME", "~1h < Sunrise"));
                dataTypeList.add(new DataTypeItem("MORNING-DIR", "EAST"));

                dataTypeList.add(new DataTypeItem("EVENING-RANGE", "Aug. 14 - Dec. 31"));
                dataTypeList.add(new DataTypeItem("EVENING-TIME", "~1h > Sunset"));
                dataTypeList.add(new DataTypeItem("EVENING-DIR", "WEST"));
            break;

            case URANUS:
                dataTypeList.add(new DataTypeItem("DISTANCE:", "2.6 billon km"));

                dataTypeList.add(new DataTypeItem("MORNING-RANGE", "May. 22 - Nov. 8"));
                dataTypeList.add(new DataTypeItem("MORNING-TIME", "~3h < Sunrise"));
                dataTypeList.add(new DataTypeItem("MORNING-DIR", "EAST"));

                dataTypeList.add(new DataTypeItem("EVENING-RANGE", "Jan. 1 - April. 18"));
                dataTypeList.add(new DataTypeItem("EVENING-TIME", "~3h > Sunset"));
                dataTypeList.add(new DataTypeItem("EVENING-DIR", "WEST"));
            break;

            case NEPTUNE:
                dataTypeList.add(new DataTypeItem("DISTANCE:", "4.3 billon km"));

                dataTypeList.add(new DataTypeItem("MORNING-RANGE", "March. 29 - Sept. 15"));
                dataTypeList.add(new DataTypeItem("MORNING-TIME", "~3h < Sunrise"));
                dataTypeList.add(new DataTypeItem("MORNING-DIR", "EAST"));

                dataTypeList.add(new DataTypeItem("EVENING-RANGE", "Jan. 1 - Feb. 25"));
                dataTypeList.add(new DataTypeItem("EVENING-TIME", "~3h > Sunset"));
                dataTypeList.add(new DataTypeItem("EVENING-DIR", "WEST"));
            break;
        }

        //Instantiate and set the adapter
        CustomListAdapter adapter = new CustomListAdapter(getContext(), dataTypeList);

        list.setAdapter(adapter);

        //Insert param info into resources like TextViews here
        //EXAMPLE: if (mParam1 != null) titleTV.setText(mParam1);

        //Find VP resources, and reinitialize them with parameter values
        TextView planetNameTV = view.findViewById(R.id.planetNameTV);
        ImageView planetIV = view.findViewById(R.id.planetIV);

        if (mPlanetName != null) planetNameTV.setText(mPlanetName);
        if (mPlanetPicture != -1) planetIV.setImageResource(mPlanetPicture);

        return view;
    }

    /**CustomListAdapter
     * A custom adapter for ListView used to grab resource info from the list.xml,
     * and initialize it with an ArrayList<DataTypeItem>
     * @author Colton LaChance
     */
    public class CustomListAdapter extends ArrayAdapter<DataTypeItem> {
        public CustomListAdapter(Context context, ArrayList<DataTypeItem> items) {
            super(context,0,items);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            DataTypeItem item = getItem(position);

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