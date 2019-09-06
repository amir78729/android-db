package com.example.diseases.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diseases.DiseaseInformation;
import com.example.diseases.MainActivity;
import com.example.diseases.R;
import com.example.diseases.model.Disease;

import java.util.List;

import static com.example.diseases.R.*;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<Disease> diseaseList;

    public RecyclerViewAdapter(Context context, List<Disease> diseaseList) {
        this.context = context;
        this.diseaseList = diseaseList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout.disease_row, parent, false );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Disease disease = diseaseList.get(position);

        holder.deseaseName.setText(disease.getName());
        holder.diseaseDescription.setText(disease.getDescriptiom());

    }


    @Override
    public int getItemCount() {
        return diseaseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView deseaseName;
        public TextView diseaseDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            deseaseName = itemView.findViewById(R.id.disease_name_for_row);
            diseaseDescription = itemView.findViewById(R.id.disease_description_for_row2);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Disease disease = diseaseList.get(position);
            Intent intent = new Intent(context , DiseaseInformation.class);
            intent.putExtra("name", disease.getName());
            intent.putExtra("description", disease.getDescriptiom());
            context.startActivity(intent);
        }
    }
}
