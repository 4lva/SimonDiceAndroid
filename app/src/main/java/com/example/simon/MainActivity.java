package com.example.simon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,iniciar;
    TextView puntuacion;
    MediaPlayer mp1;
    String numeroRecordar;
    String numeroJugador;
    String difsel;
    String dificultadactual="facil";

    /**
     * Al iniciar la aplicacion los botones se colocaran en su posicion mediante
     * animaciones y desactivaremos los botones a la espera de que inicie el juego
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b0=findViewById(R.id.b0);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);
        b7=findViewById(R.id.b7);
        b8=findViewById(R.id.b8);
        b9=findViewById(R.id.b9);
        iniciar=findViewById(R.id.iniciar);
        puntuacion=findViewById(R.id.puntuacion);
        //botones animados para aparecer de izquierda a derecha
        AnimatorSet animadorBoton=new AnimatorSet();
        ObjectAnimator trasladar=ObjectAnimator.ofFloat(b1,"translationX",-800f,0f);
        trasladar.setDuration(2000);
        animadorBoton.play(trasladar);
        animadorBoton.start();
        trasladar=ObjectAnimator.ofFloat(b4,"translationX",-800f,0f);
        trasladar.setDuration(2000);
        animadorBoton.play(trasladar);
        animadorBoton.start();
        trasladar=ObjectAnimator.ofFloat(b7,"translationX",-800f,0f);
        trasladar.setDuration(2000);
        animadorBoton.play(trasladar);
        animadorBoton.start();
        //botones animados para aparecer de derecha a izquierda
        trasladar=ObjectAnimator.ofFloat(b3,"translationX",800f,0f);
        trasladar.setDuration(2000);
        animadorBoton.play(trasladar);
        animadorBoton.start();
        trasladar=ObjectAnimator.ofFloat(b6,"translationX",800f,0f);
        trasladar.setDuration(2000);
        animadorBoton.play(trasladar);
        animadorBoton.start();
        trasladar=ObjectAnimator.ofFloat(b9,"translationX",800f,0f);
        trasladar.setDuration(2000);
        animadorBoton.play(trasladar);
        animadorBoton.start();
        //botones animados para aparecer de arriba a abajo
        trasladar=ObjectAnimator.ofFloat(b2,"translationY",-800f,0f);
        trasladar.setDuration(2000);
        animadorBoton.play(trasladar);
        animadorBoton.start();
        trasladar=ObjectAnimator.ofFloat(b5,"translationY",-800f,0f);
        trasladar.setDuration(2000);
        animadorBoton.play(trasladar);
        animadorBoton.start();
        trasladar=ObjectAnimator.ofFloat(b8,"translationY",-800f,0f);
        trasladar.setDuration(2000);
        animadorBoton.play(trasladar);
        animadorBoton.start();
        //botones animados para aparecer de abajo a arriba
        trasladar=ObjectAnimator.ofFloat(b0,"translationY",800f,0f);
        trasladar.setDuration(2000);
        animadorBoton.play(trasladar);
        animadorBoton.start();
        trasladar=ObjectAnimator.ofFloat(iniciar,"translationY",800f,0f);
        trasladar.setDuration(2000);
        animadorBoton.play(trasladar);
        animadorBoton.start();
        trasladar=ObjectAnimator.ofFloat(puntuacion,"translationY",800f,0f);
        trasladar.setDuration(2000);
        animadorBoton.play(trasladar);
        animadorBoton.start();
        desactivarBotones();
    }

    /**
     * Desactiva los botones
     */
    private void desactivarBotones() {
        b0.setEnabled(false);
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b6.setEnabled(false);
        b7.setEnabled(false);
        b8.setEnabled(false);
        b9.setEnabled(false);
    }

    /**
     * Activa los botones
     */
    private void activarBotones() {
        b0.setEnabled(true);
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);
        b9.setEnabled(true);
    }

    /**
     * Inicia el juego emitiendo el primer sonido
     * @param v
     */
    public void iniciarJuego(View v)
    {
        desactivarBotones();
        numeroRecordar="";
        agregarUnNumeroAlFinal();
        puntuacion.setText("Puntuacion: "+numeroRecordar.length());
        numeroJugador="";
        emitirSonido(0);
    }

    /**
     * Emite el sonido de la posicion indicada segun la dificultad
     * cuando dice todos los numeros activa los botones
     * @param posicion
     */
    private void emitirSonido(int posicion) {
        if (mp1!=null)
            mp1.release();
        if(dificultadactual.equals("facil")) {
            if (numeroRecordar.charAt(posicion) == '0')
                mp1 = MediaPlayer.create(this, R.raw.zerofacil);
            if (numeroRecordar.charAt(posicion) == '1')
                mp1 = MediaPlayer.create(this, R.raw.unofacil);
            if (numeroRecordar.charAt(posicion) == '2')
                mp1 = MediaPlayer.create(this, R.raw.dosfacil);
            if (numeroRecordar.charAt(posicion) == '3')
                mp1 = MediaPlayer.create(this, R.raw.tresfacil);
            if (numeroRecordar.charAt(posicion) == '4')
                mp1 = MediaPlayer.create(this, R.raw.cuatrofacil);
            if (numeroRecordar.charAt(posicion) == '5')
                mp1 = MediaPlayer.create(this, R.raw.cincofacil);
            if (numeroRecordar.charAt(posicion) == '6')
                mp1 = MediaPlayer.create(this, R.raw.seisfacil);
            if (numeroRecordar.charAt(posicion) == '7')
                mp1 = MediaPlayer.create(this, R.raw.sietefacil);
            if (numeroRecordar.charAt(posicion) == '8')
                mp1 = MediaPlayer.create(this, R.raw.ochofacil);
            if (numeroRecordar.charAt(posicion) == '9')
                mp1 = MediaPlayer.create(this, R.raw.nuevefacil);
        }else{
            if (numeroRecordar.charAt(posicion) == '0')
                mp1 = MediaPlayer.create(this, R.raw.zerodificil);
            if (numeroRecordar.charAt(posicion) == '1')
                mp1 = MediaPlayer.create(this, R.raw.unodificil);
            if (numeroRecordar.charAt(posicion) == '2')
                mp1 = MediaPlayer.create(this, R.raw.dosdificil);
            if (numeroRecordar.charAt(posicion) == '3')
                mp1 = MediaPlayer.create(this, R.raw.tresdificil);
            if (numeroRecordar.charAt(posicion) == '4')
                mp1 = MediaPlayer.create(this, R.raw.cuatrodificil);
            if (numeroRecordar.charAt(posicion) == '5')
                mp1 = MediaPlayer.create(this, R.raw.cincodificil);
            if (numeroRecordar.charAt(posicion) == '6')
                mp1 = MediaPlayer.create(this, R.raw.seisdificil);
            if (numeroRecordar.charAt(posicion) == '7')
                mp1 = MediaPlayer.create(this, R.raw.sietedificil);
            if (numeroRecordar.charAt(posicion) == '8')
                mp1 = MediaPlayer.create(this, R.raw.ochodificil);
            if (numeroRecordar.charAt(posicion) == '9')
                mp1 = MediaPlayer.create(this, R.raw.nuevedificil);
        }
        mp1.start();
        mp1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (posicion<numeroRecordar.length()-1)
                {
                    emitirSonido(posicion+1);
                }
                else
                    activarBotones();
            }
        });
    }

    /**
     * Añade un numero a los dichos por la aplicacion para que adivine el usuario
     */
    private void agregarUnNumeroAlFinal() {
        int ale=(int)(Math.random()*10);
        switch (ale) {
            case 0:
                numeroRecordar = numeroRecordar + "0";
                break;
            case 1:
                numeroRecordar = numeroRecordar + "1";
                break;
            case 2:
                numeroRecordar = numeroRecordar + "2";
                break;
            case 3:
                numeroRecordar = numeroRecordar + "3";
                break;
            case 4:
                numeroRecordar = numeroRecordar + "4";
                break;
            case 5:
                numeroRecordar = numeroRecordar + "5";
                break;
            case 6:
                numeroRecordar = numeroRecordar + "6";
                break;
            case 7:
                numeroRecordar = numeroRecordar + "7";
                break;
            case 8:
                numeroRecordar = numeroRecordar + "8";
                break;
            case 9:
                numeroRecordar = numeroRecordar + "9";
                break;
        }
    }

    /**
     * Segun el boton pulsado añadira un numero al numero pulsado por el jugador y controlara si este es correcto
     * @param v
     */
    public void presionBoton(View v)
    {
        Button b=findViewById(v.getId());
        numeroJugador=numeroJugador+b.getText();;
        controlarSiEsCorrecto();
    }

    /**
     * Comprueba si los numeros seleccionados por el usuario
     * si lo son continuara el juego
     * si no lo son mostrara un Toast indicando que se ha perdido y se desactivaran los botones
     */
    private void controlarSiEsCorrecto() {
        if (numeroJugador.charAt(numeroJugador.length()-1)!=numeroRecordar.charAt(numeroJugador.length()-1))
        {
            Toast.makeText(this,"Perdiste",Toast.LENGTH_LONG).show();
            desactivarBotones();
        }
        else if (numeroJugador.length()==numeroRecordar.length())
        {
            desactivarBotones();
            numeroJugador="";
            agregarUnNumeroAlFinal();
            emitirSonido(0);
            puntuacion.setText("Puntuacion:"+numeroRecordar.length());
        }
    }

    /**
     * onStop Libra los recursos no necesarios
     */
    @Override
    protected void onStop() {
        super.onStop();
        if (mp1!=null)
        {
            mp1.release();
            mp1=null;
        }
    }

    /**
     * Creacion del menu
     * @param menu
     * @return
     */
        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Menu para seleccionar la dificultad del simon dice
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        /*Cuando seleccionamos el menu nos aparece un Dialogo en el cual
        podemos seleccionar facil o dificil almacenancolo en una variable para cuando le
        demos a aceptar la almacene en la dificultad actual y inicie el juego de nuevo
        Si le damos a cancelar no pasa nada y el juego sigue como iba*/
        if (item.getItemId() == R.id.dificultad) {
            String[] dificultad = {"Facil","Dificil"};
            AlertDialog.Builder dificultades = new AlertDialog.Builder(this);
            dificultades.setTitle("Dificultades");
            dificultades.setSingleChoiceItems(dificultad, 0, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    switch (i) {
                        case 0:
                            difsel="facil";
                            break;
                        case 1:
                            difsel="dificil";
                            break;
                    }
                }
            });
            dificultades.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {
                    dificultadactual=difsel;
                    iniciarJuego(iniciar);
                }
            });
            dificultades.setNegativeButton("Cancelar",null);
            dificultades.show();
        }
        return super.onOptionsItemSelected(item);
    }
}