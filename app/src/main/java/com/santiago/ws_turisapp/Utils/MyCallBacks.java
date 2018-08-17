package com.santiago.ws_turisapp.Utils;

import com.santiago.ws_turisapp.fragments.HotelesFragment;
import com.santiago.ws_turisapp.fragments.InicioFragment;
import com.santiago.ws_turisapp.fragments.RestaurantesFragment;
import com.santiago.ws_turisapp.fragments.SitiosFragment;

public interface MyCallBacks extends
        InicioFragment.OnFragmentInteractionListener,
        SitiosFragment.OnFragmentInteractionListener,
        HotelesFragment.OnFragmentInteractionListener,
        RestaurantesFragment.OnFragmentInteractionListener {
}
