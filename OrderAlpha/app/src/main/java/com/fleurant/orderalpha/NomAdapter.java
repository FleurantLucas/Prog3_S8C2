package com.fleurant.orderalpha;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class NomAdapter extends RecyclerView.Adapter<NomAdapter.ViewHolder> {

    public static List<String> localDataSet;

    RecyclerView.Adapter adapter = this;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNom;
        public ViewHolder(LinearLayout view) {
            super(view);
            tvNom = view.findViewById(R.id.lenom);

            itemView.findViewById(R.id.buttonDown).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String nom = tvNom.getText().toString();
                    int indexLeNom = localDataSet.indexOf(nom);

                    if(indexLeNom == localDataSet.size()-1)
                    {
                        localDataSet.remove(indexLeNom);
                        localDataSet.add(0,nom);
                        notifyItemMoved(indexLeNom,0);
                    }
                    else if (indexLeNom < localDataSet.size()-1) {
                        localDataSet.remove(indexLeNom);
                        localDataSet.add(indexLeNom + 1, nom);
                        notifyItemMoved(indexLeNom, indexLeNom + 1);
                    }
                }
            });

            itemView.findViewById(R.id.buttonUp).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String nom = tvNom.getText().toString();
                    int indexLeNom = localDataSet.indexOf(nom);

                    if(indexLeNom == 0)
                    {
                        localDataSet.remove(indexLeNom);
                        localDataSet.add(nom);
                        notifyItemMoved(indexLeNom,localDataSet.size()-1);
                    }
                    else if (indexLeNom > 0) {
                        localDataSet.remove(indexLeNom);
                        localDataSet.add(indexLeNom - 1, nom);
                        notifyItemMoved(indexLeNom, indexLeNom - 1);
                        EstEnOrdre(view);
                    }
                }
            });
        }
    }
    public NomAdapter() {
        localDataSet = new ArrayList<String>();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public NomAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        LinearLayout v = (LinearLayout) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.nomlayout, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        String nomCourant = localDataSet.get(position);
        viewHolder.tvNom.setText(nomCourant);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public void EstEnOrdre(View view){
        List<String> solution = new ArrayList<>(localDataSet);
        Collections.sort(solution);
        if(solution.equals(localDataSet))
        {
            RandomiseLaListe();
            Toast.makeText(view.getContext(),"BRAVO !", Toast.LENGTH_LONG).show();
        }
    }

    public void RandomiseLaListe()
    {
        List<String> laliste = new ArrayList<>(localDataSet);
        for (String nom:localDataSet
             ) {
            int nombre = new Random().nextInt(4);
            laliste.remove(nom);
            laliste.add(nombre,nom);
        }
        localDataSet = laliste;
        notifyDataSetChanged();
    }
}