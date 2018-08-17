package com.santiago.ws_turisapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
        hotels=getAllHoteles();
        if (datos.guardarHoteles(hotels)){
            Toast.makeText(getContext(), "guardo", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getContext(), "no guardo", Toast.LENGTH_SHORT).show();
        }

    }

    private ArrayList<Hotel> getAllHoteles() {
        return new ArrayList<Hotel>(){{
            add(new Hotel("Hotel Bolivar Plaza",getString(R.string.bolivar_plaza_CORTA),"Dirección: Calle 21a No. 14-17, Armenia",getString(R.string.bolivar_plaza_LARGA),4.45234778794663,-75.78196047823484,R.drawable.h_bolivar_plaza));
            add(new Hotel("Allure Aroma Mocawa Hotel",getString(R.string.mocawa_CORTA),"Dirección: Carrera 14 No. 9N-00, Armenia",getString(R.string.mocawa_LARGA),4.447555758701706,-75.78938483278806,R.drawable.h_mocawa));
            add(new Hotel("Armenia Hotel",getString(R.string.armenia_CORTA),"Dirección: Avenida Bolivar 8",getString(R.string.armenia_LARGA),4.624838213794354,-75.762595160852,R.drawable.h_armenia));
            add(new Hotel("Hotel Zuldemayda",getString(R.string.zuldemayda_CORTA),"Dirección: Calle 20 15-38 Armenia",getString(R.string.zuldemayda_LARGA),4.637932138866702,-75.57060538862306,R.drawable.h_zuldemayda));
            add(new Hotel("Hotel Decameron Panaca",getString(R.string.panaca_hotel_CORTA),"Dirección: Km. 7 Vereda Kerman | Parque Nacional de la Cultura Agropecuaria, Quimbaya, Colombia ",getString(R.string.panaca_hotel_LARGA),4.622357223916545,-75.76650045717768,R.drawable.h_decameron));
            add(new Hotel("Decameron Las Heliconias",getString(R.string.heliconias_CORTA),"Dirección: Km 2 Vía a Panaca, Vereda Kerman, Quimbaya ",getString(R.string.heliconias_LARGA),4.621929466163072,-75.76083563173823,R.drawable.h_heliconias));
            add(new Hotel("Hotel Arrayanes del Quindio",getString(R.string.arrayanes_CORTA),"Dirección: Km 1 Vía Montenegro-Parque del Cafe, Montenegro",getString(R.string.arrayanes_LARGA),4.5659102936329115,-75.75595653681637,R.drawable.h_arrayanes));
            add(new Hotel("Finca Hotel La Esperanza",getString(R.string.esperanza_CORTA),"Dirección: Vereda la esperanza, Montenegro, Colombia ",getString(R.string.esperanza_LARGA),4.566295305869581,-75.75057066111447,R.drawable.h_la_esperanza));
        }};


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_hoteles, container, false);
        recyclerView=view.findViewById(R.id.reciclerSitios);

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
