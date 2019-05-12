package com.example.recyclerwithgrid;

import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

   private LinearLayout linearLayout;
    private String[] data;
    private  int images[];

    public MyAdapter(String[] data, int[] images ,LinearLayout linearLayout) {
        this.data = data;
        this.images = images;
        this.linearLayout = linearLayout;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.card_view,viewGroup,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i ) {
       String title = data[i];
       myViewHolder.imageView.setImageResource(images[i]);
       myViewHolder.textView.setText(title);
       myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Snackbar snackbar = Snackbar.make(linearLayout,"snackbar displayed",Snackbar.LENGTH_LONG);
               snackbar.show();

           }
       });

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
         ImageView imageView;
         TextView textView;
         CardView cardView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textview);
            imageView = itemView.findViewById(R.id.imageview);
            cardView = itemView.findViewById(R.id.card_view);

        }
    }
}
