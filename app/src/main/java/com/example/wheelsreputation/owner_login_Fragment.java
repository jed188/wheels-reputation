package com.example.wheelsreputation;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link owner_login_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class owner_login_Fragment extends Fragment {


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public owner_login_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment owner_login_Fragment.
     */
    //  Rename and change types and number of parameters
    public static owner_login_Fragment newInstance(String param1 , String param2) {
        owner_login_Fragment fragment = new owner_login_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1 , param1);
        args.putString(ARG_PARAM2 , param2);
        fragment.setArguments(args);
        return fragment;
    }

    Button logIn ;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container ,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_owner_login_ , container , false);


        logIn =view.findViewById(R.id.login_button1);
        TextView register = view.findViewById(R.id.register_textView61);

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Find_driver_activity.class);
                startActivity(intent);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),registration_page_0ne.class);
                startActivity(intent);
            }
        });

        return view;
    }


}