package com.example.jobup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jobup.domain.JobOfferDomain;

import java.util.ArrayList;

public class JobOfferAdapter extends RecyclerView.Adapter<JobOfferAdapter.viewHolder> {

    ArrayList<JobOfferDomain> offers;

    public JobOfferAdapter(ArrayList<JobOfferDomain> offers) {
        this.offers = offers;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate =LayoutInflater.from(parent.getContext()).inflate(R.layout.job_item,parent,false);
        return new viewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        holder.offerTitle.setText(offers.get(position).getOfferTitle());
        holder.offerEmail.setText(offers.get(position).getOfferEmail());
        holder.offerPhone.setText(offers.get(position).getOfferPhone());
        holder.offerViewDetailsButton.setId(offers.get(position).getOfferId());

        holder.offerViewDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("details clikced on : "+offers.get(holder.getAdapterPosition()).getOfferTitle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return offers.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        ConstraintLayout layout;
        TextView offerTitle,offerEmail,offerPhone;
        Button offerViewDetailsButton;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            offerTitle = itemView.findViewById(R.id.JobItemTitle);
            offerEmail = itemView.findViewById(R.id.JobItemEmail);
            offerPhone = itemView.findViewById(R.id.JobItemPhone);
            offerViewDetailsButton = itemView.findViewById(R.id.JobItemButton);


            layout = itemView.findViewById(R.id.JobItemConstraintLayout);
        }
    }
}
