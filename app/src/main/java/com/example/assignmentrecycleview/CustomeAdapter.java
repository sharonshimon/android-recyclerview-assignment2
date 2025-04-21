package com.example.assignmentrecycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;


public class CustomeAdapter extends RecyclerView.Adapter<CustomeAdapter.MyViewHolder>  {
    private ArrayList<DataModel> dataSet;
    private ArrayList<DataModel> dataSetFull;
    private Context context;
    public CustomeAdapter(Context context,ArrayList<DataModel> dataSet) {
        this.context = context;
        this.dataSet = dataSet;
        this.dataSetFull = new ArrayList<>(dataSet);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewVersion;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textView);
            textViewVersion = itemView.findViewById(R.id.textView2);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    @NonNull
    @Override
    public CustomeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.character_pic, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomeAdapter.MyViewHolder holder, int position) {
        DataModel dataModel = dataSet.get(position); // Reference the current DataModel
        holder.textViewName.setText(dataModel.getName());
        holder.textViewVersion.setText(dataModel.getVersion());
        holder.imageView.setImageResource(dataModel.getImage());

        // Set an OnClickListener for the itemView
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked on: " + dataModel.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void filter(String query) {
        query = query.toLowerCase().trim();  // Clean up the query

        // If query is empty, reset the dataset to the original data
        if (query.isEmpty()) {
            dataSet.clear();
            dataSet.addAll(dataSetFull);  // Reset to the full dataset
        } else {
            ArrayList<DataModel> filteredList = new ArrayList<>();
            for (DataModel item : dataSetFull) {
                if (item.getName().toLowerCase().startsWith(query)) {
                    filteredList.add(item);  // Add item if it matches the query
                }
            }
            dataSet.clear();
            dataSet.addAll(filteredList);  // Update the dataset with the filtered data
        }

        notifyDataSetChanged();  // Notify the adapter to update the RecyclerView
    }
}