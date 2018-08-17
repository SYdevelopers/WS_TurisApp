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
import com.santiago.ws_turisapp.adapters.RestaAdapter;
import com.santiago.ws_turisapp.data.Datos;
import com.santiago.ws_turisapp.models.Hotel;
import com.santiago.ws_turisapp.models.Restaurante;

import java.util.ArrayList;


public class RestaurantesFragment extends Fragment {

    private ArrayList<Restaurante> restaurantes;
    private Datos datos;
    private RecyclerView recyclerView;
    private RestaAdapter adapter;
    private RecyclerView.LayoutManager manager;

    private OnFragmentInteractionListener mListener;

    public RestaurantesFragment() {
        // Required empty public constructor
    }

    public static RestaurantesFragment newInstance(String param1, String param2) {
        RestaurantesFragment fragment = new RestaurantesFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        datos=new Datos(getContext());
        restaurantes=datos.listarRestaurantes();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_restaurantes, container, false);
        recyclerView=view.findViewById(R.id.reciclerRestaurantes);
        manager=new LinearLayoutManager(getContext());
        adapter=new RestaAdapter(R.layout.content_lists, restaurantes, new RestaAdapter.onItemClickListener() {
            @Override
            public void itemClick(Restaurante restaurante, int position) {

            }
        });
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
