package com.example.fb.tz.tez.academy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class QrFragment extends Fragment {
    private Button button_qr;
    private TextView txt_sonuc;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.qr_fragment,container, false);
        button_qr=rootview.findViewById(R.id.button_qr);
        txt_sonuc=rootview.findViewById(R.id.txt_sonuc);


        button_qr.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator= new IntentIntegrator(getActivity());
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(true);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });
        return rootview;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result=IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null){

            txt_sonuc.setText("QR kod bulunamadı");

        }else {
            Log.d("QrFragment", "Scanned");

            txt_sonuc.setText(result.getContents());

        }


        super.onActivityResult(requestCode, resultCode, data);
    }
}
