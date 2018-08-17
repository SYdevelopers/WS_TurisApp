package com.santiago.ws_turisapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.santiago.ws_turisapp.R;
import com.santiago.ws_turisapp.adapters.HotelesAdapter;
import com.santiago.ws_turisapp.data.Datos;
import com.santiago.ws_turisapp.models.Hotel;
import com.santiago.ws_turisapp.models.Sitio;

import java.util.ArrayList;


public class HotelesFragment extends Fragment {
    private ArrayList<Hotel> hotels;
    private Datos datos;
    private RecyclerView recyclerView;
    private HotelesAdapter adapter;
    private RecyclerView.LayoutManager manager;

    private OnFragmentInteractionListener mListener;

    public HotelesFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static HotelesFragment newInstance(String param1, String param2) {
        HotelesFragment fragment = new HotelesFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        datos=new Datos(getContext());
        hotels=datos.listarHoteles();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_hoteles, container, false);
        recyclerView=view.findViewById(R.id.reciclerHoteles);
        manager=new LinearLayoutManager(getContext());
        adapter=new HotelesAdapter(R.layout.content_lists, hotels, new HotelesAdapter.onItemClickListener() {
            @Override
            public void itemClick(Hotel hotel, int position) {

            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
