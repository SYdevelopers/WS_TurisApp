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
import com.santiago.ws_turisapp.adapters.SitiosAdpater;
import com.santiago.ws_turisapp.data.Datos;
import com.santiago.ws_turisapp.models.Sitio;

import java.util.ArrayList;

public class SitiosFragment extends Fragment {
    private ArrayList<Sitio>sitios;
    private Datos datos;
    private RecyclerView recyclerView;
    private SitiosAdpater adpater;
    private RecyclerView.LayoutManager manager;

    private OnFragmentInteractionListener mListener;

    public SitiosFragment() {
        // Required empty public constructor
    }

    public static SitiosFragment newInstance(String param1, String param2) {
        SitiosFragment fragment = new SitiosFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        datos=new Datos(getContext());
        sitios=datos.listarSitios();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=  inflater.inflate(R.layout.fragment_sitios, container, false);
        recyclerView=view.findViewById(R.id.reciclerSitios);
        manager=new LinearLayoutManager(getContext());
        adpater=new SitiosAdpater(R.layout.content_lists, sitios, new SitiosAdpater.onItemClickListener() {
            @Override
            public void itemClick(Sitio sitio, int positio) {

            }
        });
        recyclerView.setAdapter(adpater);
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

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
