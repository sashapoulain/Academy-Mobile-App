package com.example.fb.tz.tez.academy;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentProfil extends Fragment {
    private EditText editTextEmail, editTextPassword;
    private Button buttonGirisYap;
    private TextView textViewUye, textViewRemember;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview =inflater.inflate(R.layout.fragment_ucuncu_profil,container,false);
        editTextEmail=rootview.findViewById(R.id.editTextEmail);
        editTextPassword=rootview.findViewById(R.id.editTextPassword);
        buttonGirisYap=rootview.findViewById(R.id.buttonGirisYap);
        textViewUye=rootview.findViewById(R.id.textViewUye);
        textViewRemember=rootview.findViewById(R.id.textViewRemember);
        buttonGirisYap.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "giriş yapıldı", Toast.LENGTH_LONG).show();
            }
        });
        textViewUye.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Intent yeniIntent = new Intent( getActivity(), UyeActivity.class );
                startActivity(yeniIntent);

            }
        });
        textViewRemember.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "şifremi unuttum tıklandı", Toast.LENGTH_LONG).show();
            }
        });
        return rootview;

    }
    /*private void registerUser(final String name, final String email, final String password) {

    String tag_string_req = "request_register";

    pDialog.setMessage("Kayıt Gerçekleştiriliyor ...");
    showDialog();

    StringRequest strReq = new StringRequest(Request.Method.POST,
            URL_REGISTER, new Response.Listener<String>() {

        @Override
        public void onResponse(String response) {

            hideDialog();

            try {
                JSONObject jObj = new JSONObject(response);
                boolean error = jObj.getBoolean("error");
                if (!error) {
                    Toast.makeText(getApplicationContext(),
                            "Başarıyla Kayıt Oldunuz!", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    String errorMsg = jObj.getString("error_msg");
                    Toast.makeText(getApplicationContext(),errorMsg, Toast.LENGTH_LONG).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }, new Response.ErrorListener() {

        @Override
        public void onErrorResponse(VolleyError error) {

            Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            hideDialog();
        }
    }) {

        @Override
        protected Map<String, String> getParams() {

            Map<String, String> params = new HashMap<String, String>();
            params.put("nameme);
            params.put("emailail);
            params.put("passwordssword);

            return params;
        }

    };

    MyApplication.getInstance().addToRequestQueue(strReq, tag_string_req);
}*/
}
