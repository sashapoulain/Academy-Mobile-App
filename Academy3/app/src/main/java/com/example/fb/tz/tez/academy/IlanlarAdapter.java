package com.example.fb.tz.tez.academy;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class IlanlarAdapter extends RecyclerView.Adapter<IlanlarAdapter.CardTasarimTutucu> {
    public Context mContext;
    public List<Ilanlar> ilanlarListe;

    public IlanlarAdapter(Context mContext, List<Ilanlar> ilanlarListe) {
        this.mContext = mContext;
        this.ilanlarListe = ilanlarListe;
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.ilan_card_tasarim, parent, false);
        return new CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Ilanlar ilan= ilanlarListe.get(position);
        holder.textViewilanbaslik.setText(ilan.getIlan_baslik());
        holder.textViewilanaltbaslik.setText(ilan.getIlan_alt_baslik());
        holder.textViewilanicerik.setText(ilan.getIlan_icerik());
        holder.imageViewilanresim.setImageResource(mContext.getResources().getIdentifier(ilan.getIlan_foto(),
                "drawable",
                mContext.getPackageName()));
        holder.ilanCard.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent( mContext, DetayActivity.class );
                intent.putExtra("nesne",ilan);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ilanlarListe.size();
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private CardView ilanCard;
        private ImageView imageViewilanresim;
        private TextView textViewilanbaslik;
        private TextView textViewilanaltbaslik;
        private TextView textViewilanicerik;

        public CardTasarimTutucu(@NonNull View itemView) {
            super(itemView);
            ilanCard=itemView.findViewById(R.id.ilanCard);
            imageViewilanresim=itemView.findViewById(R.id.imageViewilanresim);
            textViewilanbaslik=itemView.findViewById(R.id.textViewilanbaslik);
            textViewilanaltbaslik=itemView.findViewById(R.id.textViewilanaltbaslik);
            textViewilanicerik=itemView.findViewById(R.id.textViewilanicerik);

        }
    }
}
