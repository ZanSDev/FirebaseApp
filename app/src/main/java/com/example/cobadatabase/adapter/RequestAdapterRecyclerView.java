package com.example.cobadatabase.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.cobadatabase.R;
import com.example.cobadatabase.model.Requests;

import java.util.List;

public class RequestAdapterRecyclerView extends RecyclerView.Adapter<RequestAdapterRecyclerView.MyViewHolder> {

    private List<Requests> requestsList;
    private Activity activityList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout linearLayout;
        public TextView textTitle, textEmail, textStatus;

        public MyViewHolder(View view) {
            super(view);

            linearLayout = view.findViewById(R.id.linear_layout);
            textTitle = view.findViewById(R.id.title_name);
            textEmail = view.findViewById(R.id.editTextEmail);
            textStatus = view.findViewById(R.id.title_Status);

        }
    }

    public RequestAdapterRecyclerView(List<Requests> List, Activity activity){
        this.requestsList = List;
        this.activityList = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_request, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Requests requests = requestsList.get(position);

        holder.textTitle.setText();
    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
