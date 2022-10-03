package com.example.edorotechnologies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerAdpater extends RecyclerView.Adapter<RecyclerAdpater.ViewHolder> {

    List<Datum> list;
    Context context;

    public RecyclerAdpater(List<Datum> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdpater.ViewHolder holder, int position) {
        holder.id.setText(String.valueOf(list.get(position).getId()));
        holder.email.setText(list.get(position).getEmail());
        holder.fName.setText(list.get(position).getFirstName());
        holder.lName.setText(list.get(position).getLastName());
        Glide.with(context).load(list.get(position).getAvatar()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView id,email,fName,lName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.avatar);
            id = itemView.findViewById(R.id.id);
            email = itemView.findViewById(R.id.email);
            fName = itemView.findViewById(R.id.first_name);
            lName = itemView.findViewById(R.id.last_name);
        }
    }
}
