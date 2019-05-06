package com.example.jsonactivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class GnomoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_GNOMO = "gnomo";
    private Gnomo gnomo;

    // TODO: Rename and change types of parameters
    public TextView txId;
    public TextView txAge;
    public TextView txName;
    public TextView txHeigth;
    public TextView txHairColor;
    public ImageView thumbnail;
    public TextView txProfessions;
    public TextView txFriends;



    public GnomoFragment() {
        // Required empty public constructor
    }

    public static GnomoFragment newInstance(Gnomo gnomo) {
        GnomoFragment fragment = new GnomoFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_GNOMO, gnomo);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            gnomo = getArguments().getParcelable(ARG_GNOMO);
        }
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txId = view.findViewById(R.id.txId);
        txAge = view.findViewById(R.id.txAge);
        txName = view.findViewById(R.id.txName);
        txHeigth = view.findViewById(R.id.txHeigth);
        txHairColor = view.findViewById(R.id.txHairColor);
        txProfessions= view.findViewById(R.id.tvProfessions);
        txFriends= view.findViewById(R.id.tvFriends);
        thumbnail= view.findViewById(R.id.imageView);

        txId.setText(String.valueOf(gnomo.getId()));
        txName.setText(gnomo.getNombre());
        txAge.setText(String.valueOf(gnomo.getAge()));
        txHeigth.setText(Integer.toString((int)gnomo.getHeight()));
        txHairColor.setText(gnomo.getHair_color());

        for(int x=0;x<gnomo.getProfessions().size();x++) {
            txProfessions.append(gnomo.getProfessions().get(x) +"\n");
        }

        for(int x=0;x<gnomo.getFriends().size();x++) {
            txFriends.append(gnomo.getFriends().get(x) +"\n");
        }
        Glide.with(thumbnail.getContext()).load(gnomo.getThumbnail())
                .apply(new RequestOptions()
                        .error(R.drawable.ic_launcher_background)
                        .centerCrop())
                .transition(withCrossFade())
                .override(300,300)
                .into(thumbnail);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gnomo, container, false);
    }
    @Override
    public void onDetach() {
        super.onDetach();
    }
}
