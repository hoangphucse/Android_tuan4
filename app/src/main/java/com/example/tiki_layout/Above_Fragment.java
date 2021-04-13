package com.example.tiki_layout;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Above_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Above_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private int qualified;
    private SendingData sendingData;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        sendingData = (SendingData) context;
    }

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Above_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Above_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Above_Fragment newInstance(String param1, String param2) {
        Above_Fragment fragment = new Above_Fragment();
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
        final View viewAbove = inflater.inflate(R.layout.fragment_above_, container, false);
        ImageButton imgAdd = viewAbove.findViewById(R.id.imgAdd);
        final TextView tvQualified = viewAbove.findViewById(R.id.tvQualified);
        qualified = Integer.parseInt(tvQualified.getText().toString());
        ImageButton imgMinus = viewAbove.findViewById(R.id.imgMinus);

        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qualified++;
                tvQualified.setText(String.valueOf(qualified));
             //   Toast.makeText(this, "asdjkfh", Toast.LENGTH_SHORT).show();
                sendingData.SendData(String.valueOf(qualified));

            }
        });

        imgMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(qualified < 1){

                    Toast.makeText(getActivity(), "error", Toast.LENGTH_SHORT).show();
                    return;
                }

                qualified--;
                tvQualified.setText(String.valueOf(qualified));
                sendingData.SendData(String.valueOf(qualified));
            }
        });


        return viewAbove;
    }
}