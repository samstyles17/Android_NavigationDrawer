package com.example.navigationdrawer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    View view;
    Toast toast;
    private ImageView selectedImageView;

    ImageView img1,img2,img3,img4,img5;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        view = inflater.inflate(R.layout.fragment_home, container, false);
        img1 = view.findViewById(R.id.gallery1);
        registerForContextMenu(img1);
        img2 = view.findViewById(R.id.gallery2);
        registerForContextMenu(img2);
        img3 = view.findViewById(R.id.gallery3);
        registerForContextMenu(img3);
        img4 = view.findViewById(R.id.gallery4);
        registerForContextMenu(img4);
        img5 = view.findViewById(R.id.gallery5);
        registerForContextMenu(img5);

        img1.setOnLongClickListener(v -> {
            v.showContextMenu();
            return true;
        });
        img2.setOnLongClickListener(v -> {
            v.showContextMenu();
            return true;
        });
        img3.setOnLongClickListener(v -> {
            v.showContextMenu();
            return true;
        });
        img4.setOnLongClickListener(v -> {
            v.showContextMenu();
            return true;
        });
        img5.setOnLongClickListener(v -> {
            v.showContextMenu();
            return true;
        });

        return view;
    }
    private int getSelectedImageResource(ImageView imageView) {
        int selectedImageResource = 0;

        // Check which ImageView was clicked and assign the corresponding resource ID
        if (imageView == img1) {
            selectedImageResource = R.drawable.gallery1;
        } else if (imageView == img2) {
            selectedImageResource = R.drawable.gallery2;
        } else if (imageView == img3) {
            selectedImageResource = R.drawable.galery3;
        }
        else if (imageView == img3) {
            selectedImageResource = R.drawable.galery3;
        }
        else if (imageView == img5) {
            selectedImageResource = R.drawable.gallery5;
        }
        // Add more cases for other image views if needed

        return selectedImageResource;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = requireActivity().getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
        selectedImageView = (ImageView) v;
    }

    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_context1)
        {
            if (selectedImageView != null) {
                // Retrieve the resource ID of the selected image view
                int selectedImageResource = getSelectedImageResource(selectedImageView);

                Bundle result = new Bundle();
                // Pass the resource ID to the bundle
                result.putInt("selectedImageResource", selectedImageResource);

                // Trigger the sharing process or pass the data to the other fragment
                getParentFragmentManager().setFragmentResult("datafromgallery",result);
            }
        }

        return super.onContextItemSelected(item);
    }
}