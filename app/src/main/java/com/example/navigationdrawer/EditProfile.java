package com.example.navigationdrawer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditProfile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditProfile extends Fragment {
    private TextInputLayout textInputLayout,textInputLayout2,textInputLayout3,textInputLayout4;
    private TextInputEditText textInputEditText,textInputEditText2,textInputEditText3,textInputEditText4;

    Button save;

    View view;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EditProfile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EditProfile.
     */
    // TODO: Rename and change types and number of parameters
    public static EditProfile newInstance(String param1, String param2) {
        EditProfile fragment = new EditProfile();
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
        view = inflater.inflate(R.layout.fragment_edit_profile, container, false);
        textInputLayout = view.findViewById(R.id.filledTextField);
        textInputEditText = view.findViewById(R.id.edit_text);

        textInputLayout2 = view.findViewById(R.id.filledTextField2);
        textInputEditText2 = view.findViewById(R.id.edit_text2);

        textInputLayout3 = view.findViewById(R.id.filledTextField3);
        textInputEditText3 = view.findViewById(R.id.edit_text3);

        textInputLayout4 = view.findViewById(R.id.filledTextField4);
        textInputEditText4 = view.findViewById(R.id.edit_text4);

        save = view.findViewById(R.id.submit);
        // Set some text on the views
        textInputEditText.setText("Harsh Singh");
        textInputEditText2.setText("harsh00var@gmail.com");
        textInputEditText3.setText("github.com/samstyles17");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle result = new Bundle();
                result.putString("df1",textInputEditText4.getText().toString());
                result.putString("df2",textInputEditText.getText().toString());
                result.putString("df3",textInputEditText2.getText().toString());
                result.putString("df4",textInputEditText3.getText().toString());
                getParentFragmentManager().setFragmentResult("datafrom1",result);

            }
        });
        return view;
    }
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        // Find the views by ID
//
//
//
//
////        textInputLayout.setHint("Enter your name");
////        textInputEditText.setText("Hello, world!");
//    }
}