package com.example.jsonactivity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;

public class ListaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    private RecyclerView.Adapter mAdapter;
    private ArrayList<Gnomo> gnomos;
    private GnomEveris gnomosObj;
    private static final String URL_DATA = "https://api.npoint.io/bad833cb884c3bf47ca1";
    private RecyclerView recyclerView;
    // TODO: Rename and change types of parameters
    private IGnomoListener iGnomoListener;

    public ListaFragment() {
        // Required empty public constructor
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("gnomos", gnomos);
        outState.putParcelable("gnomos_everis", gnomosObj);
    }
    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            if (savedInstanceState.getBoolean("bar", false)) {
                gnomos = savedInstanceState.getParcelableArrayList("gnomos");
                gnomosObj = savedInstanceState.getParcelable("gnomos_everis");
            }
        }
    }
    // TODO: Rename and change types and number of parameters
    public static ListaFragment newInstance() {
        ListaFragment fragment = new ListaFragment();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("TAG", "OnCreate");

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //RECYCLER VIEW
        recyclerView = view.findViewById(R.id.rcView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        //GNOMOS ARRAYLIST
        gnomos = new ArrayList<>();
        //ADPATER
        mAdapter = new MyRecyclerAdapter(gnomos, getContext(), iGnomoListener);
        recyclerView.setAdapter(mAdapter);

        loadUrlData();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IGnomoListener) {
            iGnomoListener = (IGnomoListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    public void loadUrlData() {
        Context mContext = getActivity().getApplicationContext();
        final RequestQueue requestQueue = Volley.newRequestQueue(mContext);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, URL_DATA, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Gson gson = new Gson();
                        gnomosObj = gson.fromJson(response.toString(), GnomEveris.class);
                        gnomos.addAll(gnomosObj.getGnomos().subList(0, 20));
                        mAdapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                    }
                });
        requestQueue.add(jsonObjectRequest);
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.e("TAG", "OnResume");
        if (gnomos != null) {
            Log.e("TAG", "HEY");
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("TAG", "OnPause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("TAG", "OnDestroy");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("TAG", "OnStart");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("TAG", "OnStop");
    }
}
