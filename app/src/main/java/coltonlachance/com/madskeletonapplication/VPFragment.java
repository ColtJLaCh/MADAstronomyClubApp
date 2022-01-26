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

    public ListView list;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public VPFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VPFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VPFragment newInstance(String param1, String param2) {
        VPFragment fragment = new VPFragment();
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
        View view = inflater.inflate(R.layout.fragment_v_p, container, false);

        list = view.findViewById(R.id.dataTypeList);

        ArrayList<DataTypeItem> dataTypeList = new ArrayList<DataTypeItem>();

        dataTypeList.add(new DataTypeItem("Image on homepage","Created using Paint.net."));
        dataTypeList.add(new DataTypeItem("TIP #1 Image", "From https://pixabay.com/photos/dark-rain-windows-glass-windows-1850684/, edited."));
        dataTypeList.add(new DataTypeItem("TIP #2 Image", "From https://pixabay.com/photos/baseball-field-sports-field-1495657/, edited."));
        dataTypeList.add(new DataTypeItem("TIP #3 Image", "From https://pixabay.com/photos/construction-site-construction-worker-3279650/, edited."));
        dataTypeList.add(new DataTypeItem("Concrete Buddy App", "Created solely by Colton LaChance."));

        CustomListAdapter adapter = new CustomListAdapter(getContext(), dataTypeList);

        list.setAdapter(adapter);

        //Insert param info into resources like TextViews here
        //EXAMPLE: if (mParam1 != null) titleTV.setText(mParam1);

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
            return convertView;
        }
    }
}