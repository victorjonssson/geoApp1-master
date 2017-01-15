package com.example.victor.geoapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ProblemActivity extends AppCompatActivity {

    // koppla ihop textrutorna från layouten
    EditText mailAdress, mailsubject, mailMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem);
        //koppla edit text till koden
        mailAdress = (EditText)findViewById(R.id.editComment);
        mailAdress = (EditText)findViewById(R.id.editProblem);
        //mailAdress = (EditText)findViewById(R.id.editMail);
    }

    //metod för att ta oss tillbaka till main
    public void actback (View view){
        // intent för att anropa aktivitet
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    //metod för att reagera på klickhändelase
    protected void report (View v){
        //felhantering ifall enheten inte har någon epostprovider
        try {
            //skapa en intent för att skicka mail
            Intent reportP = new Intent(Intent.ACTION_SEND);
            //SKICKA MED MAILADRESSEN
            reportP.putExtra(Intent.EXTRA_EMAIL, new String[]{
                    //här ska alla miladresser ligga
                    //hämta från vår editTextView
                    mailAdress.getText().toString()
            });
            //skicka med ämnet på vårt problem
            reportP.putExtra(Intent.EXTRA_SUBJECT, mailsubject.getText().toString());

            //skicka med meddelandet
            reportP.putExtra(Intent.EXTRA_TEXT, mailMessage.getText().toString());

            //typen för att skicka epost är rfc822
            reportP.setType("message/rfc822");

            //kör denna intent
            startActivity(reportP);
        }catch (ActivityNotFoundException anfe){
            //felmeddelande
            //skapa en macka som är ett meddelande som blinkar fram i android enheter
            Toast toast = Toast.makeText(this, "Sorry E-mail eas not sent", Toast.LENGTH_LONG);
            //visa mackan i rutan
            toast.show();
        }

    }


}
