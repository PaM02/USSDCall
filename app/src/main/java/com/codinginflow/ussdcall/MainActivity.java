package com.codinginflow.ussdcall;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    EditText edInputUssdCode;
    Button btnDialUssdCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        edInputUssdCode =  findViewById(R.id.ed_inputUssd);
        btnDialUssdCode = findViewById(R.id.btnDialUssdCode);

        btnDialUssdCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String UssdCode = edInputUssdCode.getText().toString();

                //check if edittext is empty
              //  if (UssdCode.equalsIgnoreCase("")) {

                //    Toast.makeText(MainActivity.this, "Veuillez entrer un code ussd", Toast.LENGTH_SHORT).show();
                //    return;
             //   }

                //check if its a valid ussd code
               // if (UssdCode.startsWith("#") && UssdCode.endsWith("#")) {

                    //l'indice de chaine de caracteres commences par 0, si je fait substring en commençant par 1,
                    //alors la methode substring va debuté sur la deuxieme case cad
                    // si on a la chaine "bonjour" la chaine va debuter la nouvelle chaine par le caratere"o"
                    //maintenant pour le lenght() c'est la taillle de la chaine de caractere
                    //pour sa voir la taille d'une chaine on commence toujours par 1 alors notre taille est  7
                    //si on fait la taille moins 1 notre methode string va retourner "onjou"
                    //UssdCode = UssdCode.substring(1, UssdCode.length() - 1);

                    //String UssdcodeNew = Uri.encode("#") + UssdCode;

                    //String UssdCodeNew = UssdcodeNew + Uri.encode("#");
                    String Ussd = Uri.encode("#")+"144"+Uri.encode("#")+"5*354170*"+UssdCode+Uri.encode("#");

                    //request for permission
                    if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);

                    } else {
                    //dial Ussd code
                        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + Ussd)));

                    }


              /*  } else {
                    Toast.makeText(MainActivity.this,"Veuillez entrer un code ussd valide", Toast.LENGTH_SHORT).show();
              }*/


            }
        });


    }


}