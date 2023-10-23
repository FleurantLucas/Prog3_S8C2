package com.fleurant.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class BingoAdapter extends RecyclerView.Adapter<BingoAdapter.ViewHolder> {

        public List<BingoData> localDataSet;

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public TextView tvlettre;

            public TextView tvNoTirer;

            public TextView tvNoTirage;

            public ViewHolder(LinearLayout view) {
                super(view);
                tvlettre = view.findViewById(R.id.rec_textviewLettre);
                tvNoTirage = view.findViewById(R.id.rec_textviewNoTirage);
                tvNoTirer = view.findViewById(R.id.rec_textviewNoTirer);
            }
        }
        public BingoAdapter() {
            localDataSet = new ArrayList<BingoData>();
        }

        // Create new views (invoked by the layout manager)
        @Override
        public BingoAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            // Create a new view, which defines the UI of the list item
            LinearLayout v = (LinearLayout) LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.bingolayout, viewGroup, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }


    // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder viewHolder, final int position) {

            // Get element from your dataset at this position and replace the
            // contents of the view with that element
            BingoData bingoCourant = localDataSet.get(position);
            viewHolder.tvlettre.setText(""+bingoCourant.lettre);
            viewHolder.tvNoTirage.setText("Tirage#" + bingoCourant.NoTirage);
            viewHolder.tvNoTirer.setText("Numéro Tiré : " + bingoCourant.NoTirer);
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return localDataSet.size();
        }
    }
