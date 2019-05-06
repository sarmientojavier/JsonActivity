package com.example.jsonactivity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

    private ArrayList<Gnomo> gnomos;
    private Context context;
    private IGnomoListener iGnomoListener;


    public MyRecyclerAdapter(ArrayList<Gnomo> gnomos, Context context, IGnomoListener iGnomoListener) {
        this.gnomos = gnomos;
        this.context = context;
        this.iGnomoListener = iGnomoListener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView txId;
        public TextView txAge;
        public TextView txName;
        public TextView txHeigth;
        public ImageView thumbnail;

        public MyViewHolder(View v) {
            super(v);
            txId = itemView.findViewById(R.id.tvId);
            txAge = itemView.findViewById(R.id.tvAge);
            txName = itemView.findViewById(R.id.tvName);
            txHeigth = itemView.findViewById(R.id.tvHeigth);
            thumbnail = itemView.findViewById(R.id.iv);
        }
    }
    @Override
    public MyRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_gnomo, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        final Gnomo gnomo = gnomos.get(position);
        holder.txId.setText(String.valueOf(gnomos.get(position).getId()));
        holder.txName.setText(gnomos.get(position).getNombre());
        holder.txAge.setText(Integer.toString(gnomos.get(position).getAge()));
        holder.txHeigth.setText(Integer.toString((int) gnomos.get(position).getHeight()));
        Log.i("LOG", gnomos.get(position).getThumbnail());
        Glide.with(context).load(gnomos.get(position).getThumbnail())
                .apply(new RequestOptions()
                        .error(R.drawable.ic_launcher_foreground)
                        .centerCrop())
                .transition(withCrossFade())
                .override(300, 300)
                .into(holder.thumbnail);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               iGnomoListener.onGnomoClickListener(gnomo);
            }
        });
    }

    @Override
    public int getItemCount() {
        return gnomos == null ? 0 : gnomos.size();
    }


}
