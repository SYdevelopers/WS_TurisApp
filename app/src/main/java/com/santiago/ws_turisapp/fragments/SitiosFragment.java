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
        sitios=getAllSitios();

        if (datos.guardarSitio(sitios)) {
            Toast.makeText(getContext(), "guardo", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "no guardo", Toast.LENGTH_SHORT).show();
        }

    }

    private ArrayList<Sitio> getAllSitios() {
        return new ArrayList<Sitio>(){{
            add(new Sitio("Centro comercial portal del quindio",getString(R.string.portal_del_Quindío_CORTA),"Dirección: Av Bolivar # 19 Norte 46 Armenia",getString(R.string.portal_del_Quindío_LARGA),4.545695136892776,-75.67256734597161,R.drawable.s_portal_del_quindio));
            add(new Sitio("Unicentro Armenia",getString(R.string.unicentro_CORTA),"Avenida Bolívar con Calle 4B",getString(R.string.unicentro_LARGA),4.537481262607865,-75.66655919777826,R.drawable.s_unicentro));
            add(new Sitio("Calima Centro Comercial Armenia",getString(R.string.calima_CORTA),"Avenida Centenario # 3 - 180. Armenia",getString(R.string.calima_LARGA),4.5268715367044985,-75.68767354714349,R.drawable.s_calima));
            add(new Sitio("Parque del Café",getString(R.string.parque_cafe_CORTA),"Montenegro Quindio",getString(R.string.parque_cafe_LARGA),4.569482343671689,-75.74745929865719,R.drawable.s_parque_cafe));
            add(new Sitio("Panaca",getString(R.string.panaca_CORTA),"Kilometro 7, Vía Vereda Kerman Quimbaya, Quindío.",getString(R.string.panaca_LARGA),4.622357223916545,-75.76650045717768,R.drawable.s_panaca));
            add(new Sitio("Salento",getString(R.string.salento_CORTA),"Municipio en Colombia",getString(R.string.salento_LARGA),4.621929466163072,-75.76083563173823,R.drawable.s_salento));
            add(new Sitio("Eco Parque Peñas Blancas",getString(R.string.peñas_blancas_CORTA),"Corregimiento la virginia en Calarcá",getString(R.string.peñas_blancas_LARGA),4.62470988694496,-75.7556428750854,R.drawable.s_penas_blancas));
            add(new Sitio("La Pequeña Granja de Mamá Lulú",getString(R.string.mama_lulu_CORTA),"Quimbaya Quindio",getString(R.string.mama_lulu_LARGA),4.640840820686086,-75.56895314786989,R.drawable.s_granja_mama_lulu));
            add(new Sitio("Parque Los Arrieros ",getString(R.string.arrieros_CORTA),"Quimbaya Quindio",getString(R.string.arrieros_LARGA),4.531577482735009,-75.64214036690667,R.drawable.s_los_arrieros));
        }};

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
