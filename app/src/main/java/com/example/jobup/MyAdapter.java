package com.example.jobup;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    private Context context;
    private Activity activity;
    private ArrayList offerId,offerTitle,offerEmail,offerPhone,offerDescription;

    MyAdapter(Context context, ArrayList offerId,ArrayList offerTitle,ArrayList offerEmail,ArrayList offerPhone ){
        this.context = context;
        this.offerId = offerId;
        this.offerTitle = offerTitle;
        this.offerEmail = offerEmail;
        this.offerPhone = offerPhone;
       // this.offerDescription = offerDescription;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.offer_card, parent, false);
        return new MyViewHolder(view);
    }

    //@RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.offer_id_txt.setText(String.valueOf(offerId.get(position)));
        holder.offer_title_txt.setText(String.valueOf(offerTitle.get(position)));
        holder.offer_email_txt.setText(String.valueOf(offerEmail.get(position)));
        holder.offer_phone_txt.setText(String.valueOf(offerPhone.get(position)));
        //holder.offer_description_txt.setText(String.valueOf(offerDescription.get(position)));


    }

    @Override
    public int getItemCount() {
        return offerTitle.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView offer_id_txt,offer_title_txt, offer_email_txt, offer_phone_txt;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            offer_id_txt = itemView.findViewById(R.id.offer_id_txt);
            offer_title_txt = itemView.findViewById(R.id.offer_title_txt);
            offer_email_txt = itemView.findViewById(R.id.offer_email_txt);
            offer_phone_txt = itemView.findViewById(R.id.offer_phone_txt);
            //offer_description_txt = itemView.findViewById(R.id.offer_description_txt);

        }

    }

}
