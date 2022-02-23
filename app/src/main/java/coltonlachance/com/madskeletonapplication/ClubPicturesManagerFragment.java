package coltonlachance.com.madskeletonapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClubPicturesManagerFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    public static final int CREATE = 1;
    public static final int UPDATE = 2;

    public static final String ACTION_TYPE = "action_type";


    public ClubPicturesManagerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_club_pictures_manager, container, false);

        EditText titleEdit = view.findViewById(R.id.pictureTitleEdit);
        EditText uriEdit = view.findViewById(R.id.pictureURIEdit);
        EditText dateEdit = view.findViewById(R.id.dateTakenEdit);
        Button addImage= view.findViewById(R.id.addImageButton);
        TextView errorText = view.findViewById(R.id.errorTV);
        ImageView testImg = view.findViewById(R.id.pictureTestIV);

        uriEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Picasso.get().load("https://clachance.scweb.ca/pictures/darlingmeteor.jpg").into(testImg);
            }
        });

        if(getArguments() != null){

            if(getArguments().getInt(ACTION_TYPE) == CREATE) {
                addImage.setText(R.string.addImage);
            }
            else{
                addImage.setText(R.string.updateImage);
            }

            addImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AstronomyDatabase db = new AstronomyDatabase(getContext());

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                    long dateInMillis = 0;
                    boolean dateValid = false;

                    try {
                        Date date = dateFormat.parse(String.valueOf(dateEdit.getText()));
                        dateInMillis = date.getTime();
                        dateValid = true;
                    }catch (Exception e) {
                        e.printStackTrace();
                        errorText.setAlpha(1);
                    }

                    if (dateValid) {
                        if (getArguments().getInt(ACTION_TYPE) == CREATE) {

                            ClubPictures clubPicture = new ClubPictures(0, String.valueOf(titleEdit.getText()), String.valueOf(uriEdit.getText()), dateInMillis);

                            db.addClubPicture(clubPicture);

                            Navigation.findNavController(view).popBackStack();

                        } else {
                            /*
                            ClubPictures clubPicture = new ClubPictures(0, String.valueOf(titleEdit.getText()), String.valueOf(uriEdit.getText()), dateInMillis);

                            db.addClubPicture(clubPicture);
                             */
                        }
                    }

                }
            });

        }
        return view;
    }
}