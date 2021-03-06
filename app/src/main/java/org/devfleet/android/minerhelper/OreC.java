package org.devfleet.android.minerhelper;

import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;


import static android.support.v4.view.ViewCompat.jumpDrawablesToCurrentState;

public class OreC extends AppCompatActivity {

        SharedPreferences sharedPref;

        CheckBox Variants;
        CheckBox Mercoxit;
        CheckBox Arkonor;
        CheckBox Bistot;
        CheckBox Crokite;
        CheckBox Dark_Ochre;
        CheckBox Gneiss;
        CheckBox Hedbergite;
        CheckBox Hemorphite;
        CheckBox Jaspet;
        CheckBox Kernite;
        CheckBox Omber;
        CheckBox Plagioclase;
        CheckBox Pyroxeres;
        CheckBox Scordite;
        CheckBox Spodumain;
        CheckBox Veldspar;

        View v;

    Button Amarr;
    Button Caldari;
    Button Minmatar;
    Button All;
    Button Gallente;

    CheckBox s10;
    CheckBox s09;
    CheckBox s07;
    CheckBox s04;
    CheckBox s02;
    CheckBox s00;

    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ore_c);
        getViews();
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        loadViews();
    }

    public void getViews() {
        Variants = (CheckBox) findViewById(R.id.Variants);
        Mercoxit = (CheckBox) findViewById(R.id.Mercoxit);
        Arkonor = (CheckBox) findViewById(R.id.Arkonor);
        Bistot = (CheckBox) findViewById(R.id.Bistot);
        Crokite = (CheckBox) findViewById(R.id.Crokite);
        Dark_Ochre = (CheckBox) findViewById(R.id.Dark_Ochre);
        Gneiss = (CheckBox) findViewById(R.id.Gneiss);
        Hedbergite = (CheckBox) findViewById(R.id.Hedbergite);
        Hemorphite = (CheckBox) findViewById(R.id.Hemorphite);
        Jaspet = (CheckBox) findViewById(R.id.Jaspet);
        Kernite = (CheckBox) findViewById(R.id.Kernite);
        Omber = (CheckBox) findViewById(R.id.Omber);
        Plagioclase = (CheckBox) findViewById(R.id.Plagioclase);
        Pyroxeres = (CheckBox) findViewById(R.id.Pyroxeres);
        Scordite = (CheckBox) findViewById(R.id.Scordite);
        Spodumain = (CheckBox) findViewById(R.id.Spodumain);
        Veldspar = (CheckBox) findViewById(R.id.Veldspar);
    }
    public void loadViews() {
        Variants.setChecked(sharedPref.getBoolean("Variants", false));
        Mercoxit.setChecked(sharedPref.getBoolean("Mercoxit", false));
        Arkonor.setChecked(sharedPref.getBoolean("Arkonor", true));
        Bistot.setChecked(sharedPref.getBoolean("Bistot", true));
        Crokite.setChecked(sharedPref.getBoolean("Crokite", true));
        Dark_Ochre.setChecked(sharedPref.getBoolean("Dark_Ochre", true));
        Gneiss.setChecked(sharedPref.getBoolean("Gneiss", true));
        Hedbergite.setChecked(sharedPref.getBoolean("Hedbergite", true));
        Hemorphite.setChecked(sharedPref.getBoolean("Hemorphite", true));
        Jaspet.setChecked(sharedPref.getBoolean("Jaspet", true));
        Kernite.setChecked(sharedPref.getBoolean("Kernite", true));
        Omber.setChecked(sharedPref.getBoolean("Omber", true));
        Plagioclase.setChecked(sharedPref.getBoolean("Plagioclase", true));
        Pyroxeres.setChecked(sharedPref.getBoolean("Pyroxeres", true));
        Scordite.setChecked(sharedPref.getBoolean("Scordite", true));
        Spodumain.setChecked(sharedPref.getBoolean("Spodumain", true));
        Veldspar.setChecked(sharedPref.getBoolean("Veldspar", true));
    }
    public void findButtons() {
        Amarr = (Button) v.findViewById(R.id.toggleButtonA);
        Caldari = (Button) v.findViewById(R.id.toggleButtonC);
        Gallente = (Button) v.findViewById(R.id.toggleButtonG);
        Minmatar = (Button) v.findViewById(R.id.toggleButtonM);
        All = (Button) v.findViewById(R.id.toggleButtonAll);

        s10 = (CheckBox) v.findViewById(R.id.s1_0);
        s09 = (CheckBox) v.findViewById(R.id.s0_9);
        s07 = (CheckBox) v.findViewById(R.id.s0_7);
        s04 = (CheckBox) v.findViewById(R.id.s0_3);
        s02 = (CheckBox) v.findViewById(R.id.s0_1);
        s00 = (CheckBox) v.findViewById(R.id.s0_0);
    }

    public void openSelection(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(OreC.this);
        LayoutInflater inflater = this.getLayoutInflater();
        v = inflater.inflate(R.layout.orebysystem, null);
        builder.setView(v);
        dialog = builder.create();
        dialog.show();
        findButtons();
        paintOne();
        checkCheckBox();
    }

    public void selectEmpire(View view) {

        ViewCompat.setBackgroundTintList(Amarr, ColorStateList.valueOf(0xFFD6D7D7));
        ViewCompat.setBackgroundTintList(Caldari, ColorStateList.valueOf(0xFFD6D7D7));
        ViewCompat.setBackgroundTintList(Gallente, ColorStateList.valueOf(0xFFD6D7D7));
        ViewCompat.setBackgroundTintList(Minmatar, ColorStateList.valueOf(0xFFD6D7D7));
        ViewCompat.setBackgroundTintList(All, ColorStateList.valueOf(0xFFD6D7D7));
        ViewCompat.setBackgroundTintList(view, ColorStateList.valueOf(0xaaaaaaaa));
        SharedPreferences.Editor editor=sharedPref.edit();
        editor.putString("Button",whatButton(view));
        editor.commit();
    }

    public String whatButton(View view) {
        if(view==Amarr) {return "A";}
        if(view==Caldari) {return "C";}
        if(view==Gallente) {return "G";}
        if(view==Minmatar) {return "M";}
        return "All";
    }

    public void paintOne() {
        String View=sharedPref.getString("Button", "All");
        switch (View){
            case "A": ViewCompat.setBackgroundTintList(Amarr, ColorStateList.valueOf(0xaaaaaaaa)); break;
            case "C": ViewCompat.setBackgroundTintList(Caldari, ColorStateList.valueOf(0xaaaaaaaa)); break;
            case "G": ViewCompat.setBackgroundTintList(Gallente, ColorStateList.valueOf(0xaaaaaaaa)); break;
            case "M": ViewCompat.setBackgroundTintList(Minmatar, ColorStateList.valueOf(0xaaaaaaaa)); break;
            case "All": ViewCompat.setBackgroundTintList(All, ColorStateList.valueOf(0xaaaaaaaa)); break;
        }
    }

    public void checkCheckBox() {
        String box=sharedPref.getString("CB", "s00");
        switch (box) {
            case "s10": s10.setChecked(true); break;
            case "s09": s09.setChecked(true); break;
            case "s07": s07.setChecked(true); break;
            case "s04": s04.setChecked(true); break;
            case "s02": s02.setChecked(true); break;
            case "s00": s00.setChecked(true); break;
        }
    }

    public void checkButton(View view) {

        SharedPreferences.Editor editor = sharedPref.edit();
        if ((s10==view)) {editor.putString("CB","s10");}
        if ((s09==view)) {editor.putString("CB","s09");}
        if ((s07==view)) {editor.putString("CB","s07");}
        if ((s04==view)) {editor.putString("CB","s04");}
        if ((s02==view)) {editor.putString("CB","s02");}
        if ((s00==view)) {editor.putString("CB","s00");}
        editor.commit();

        s10.setChecked(false);
        s09.setChecked(false);
        s07.setChecked(false);
        s04.setChecked(false);
        s02.setChecked(false);
        s00.setChecked(false);

        if (!(s10==view)) {jumpDrawablesToCurrentState(s10);}
        if (!(s09==view)) {jumpDrawablesToCurrentState(s09);}
        if (!(s07==view)) {jumpDrawablesToCurrentState(s07);}
        if (!(s04==view)) {jumpDrawablesToCurrentState(s04);}
        if (!(s02==view)) {jumpDrawablesToCurrentState(s02);}
        if (!(s00==view)) {jumpDrawablesToCurrentState(s00);}

        ((CheckBox)view).setChecked(true);

    }

    public void apply(View view) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("Arkonor",false);
        editor.putBoolean("Bistot",false);
        editor.putBoolean("Crokite",false);
        editor.putBoolean("Dark_Ochre",false);
        editor.putBoolean("Gneiss",false);
        editor.putBoolean("Hedbergite",false);
        editor.putBoolean("Hemorphite",false);
        editor.putBoolean("Jaspet",false);
        editor.putBoolean("Kernite",false);
        editor.putBoolean("Omber",false);
        editor.putBoolean("Plagioclase",false);
        editor.putBoolean("Pyroxeres",false);
        editor.putBoolean("Scordite",false);
        editor.putBoolean("Spodumain",false);
        editor.putBoolean("Veldspar",false);
        switch (sharedPref.getString("CB","s00")) {
            case "s10":editor.putBoolean("Veldspar",true);editor.putBoolean("Scordite",true);break;
            case "s09": switch (sharedPref.getString("Button","All")) {
                case "A":
                case "C": editor.putBoolean("Veldspar",true);editor.putBoolean("Scordite",true);editor.putBoolean("Pyroxeres",true);break;
                case "M":
                case "G": editor.putBoolean("Veldspar",true);editor.putBoolean("Scordite",true);editor.putBoolean("Plagioclase",true);break;
                case "All": editor.putBoolean("Veldspar",true);editor.putBoolean("Scordite",true);editor.putBoolean("Pyroxeres",true);editor.putBoolean("Plagioclase",true);break;
            }break;
            case "s07": switch (sharedPref.getString("Button","All")) {
                case "A": editor.putBoolean("Veldspar",true);editor.putBoolean("Scordite",true);editor.putBoolean("Pyroxeres",true);editor.putBoolean("Kernite",true);break;
                case "C": editor.putBoolean("Veldspar",true);editor.putBoolean("Scordite",true);editor.putBoolean("Pyroxeres",true);editor.putBoolean("Plagioclase",true);break;
                case "M":
                case "G": editor.putBoolean("Veldspar",true);editor.putBoolean("Scordite",true);editor.putBoolean("Plagioclase",true);editor.putBoolean("Omber",true);break;
                case "All": editor.putBoolean("Veldspar",true);editor.putBoolean("Scordite",true);editor.putBoolean("Pyroxeres",true);editor.putBoolean("Plagioclase",true);editor.putBoolean("Omber",true);editor.putBoolean("Kernite",true);break;
            }break;
            case "s04": switch (sharedPref.getString("Button","All")) {
                case "A": editor.putBoolean("Veldspar",true);editor.putBoolean("Scordite",true);editor.putBoolean("Pyroxeres",true);editor.putBoolean("Kernite",true);editor.putBoolean("Jaspet",true);break;
                case "C": editor.putBoolean("Veldspar",true);editor.putBoolean("Scordite",true);editor.putBoolean("Pyroxeres",true);editor.putBoolean("Plagioclase",true);editor.putBoolean("Kernite",true);break;
                case "M": editor.putBoolean("Veldspar",true);editor.putBoolean("Scordite",true);editor.putBoolean("Plagioclase",true);editor.putBoolean("Omber",true);editor.putBoolean("Jaspet",true);break;
                case "G": editor.putBoolean("Veldspar",true);editor.putBoolean("Scordite",true);editor.putBoolean("Plagioclase",true);editor.putBoolean("Omber",true);editor.putBoolean("Kernite",true);break;
                case "All": editor.putBoolean("Veldspar",true);editor.putBoolean("Scordite",true);editor.putBoolean("Pyroxeres",true);editor.putBoolean("Plagioclase",true);editor.putBoolean("Omber",true);editor.putBoolean("Kernite",true);editor.putBoolean("Jaspet",true);break;
            }break;
            case "s02": switch (sharedPref.getString("Button","All")) {
                case "A": editor.putBoolean("Veldspar",true);editor.putBoolean("Scordite",true);editor.putBoolean("Pyroxeres",true);editor.putBoolean("Kernite",true);editor.putBoolean("Jaspet",true);editor.putBoolean("Hemorphite",true);break;
                case "C": editor.putBoolean("Veldspar",true);editor.putBoolean("Scordite",true);editor.putBoolean("Pyroxeres",true);editor.putBoolean("Plagioclase",true);editor.putBoolean("Kernite",true);editor.putBoolean("Hedbergite",true);break;
                case "M": editor.putBoolean("Veldspar",true);editor.putBoolean("Scordite",true);editor.putBoolean("Plagioclase",true);editor.putBoolean("Omber",true);editor.putBoolean("Jaspet",true);editor.putBoolean("Hemorphite",true);break;
                case "G": editor.putBoolean("Veldspar",true);editor.putBoolean("Scordite",true);editor.putBoolean("Plagioclase",true);editor.putBoolean("Omber",true);editor.putBoolean("Kernite",true);editor.putBoolean("Hedbergite",true);break;
                case "All": editor.putBoolean("Veldspar",true);editor.putBoolean("Scordite",true);editor.putBoolean("Pyroxeres",true);editor.putBoolean("Plagioclase",true);editor.putBoolean("Omber",true);editor.putBoolean("Kernite",true);editor.putBoolean("Jaspet",true);editor.putBoolean("Hemorphite",true);editor.putBoolean("Hedbergite",true);break;
            }break;
            case "s00": switch (sharedPref.getString("Button","All")) {
                case "A": editor.putBoolean("Veldspar",true);editor.putBoolean("Scordite",true);editor.putBoolean("Pyroxeres",true);editor.putBoolean("Kernite",true);editor.putBoolean("Jaspet",true);editor.putBoolean("Hemorphite",true);editor.putBoolean("Spodumain",true);editor.putBoolean("Gneiss",true);editor.putBoolean("Crokite",true);editor.putBoolean("Arkonor",true);editor.putBoolean("Bistot",true);break;
                case "C": editor.putBoolean("Veldspar",true);editor.putBoolean("Scordite",true);editor.putBoolean("Pyroxeres",true);editor.putBoolean("Plagioclase",true);editor.putBoolean("Kernite",true);editor.putBoolean("Hedbergite",true);editor.putBoolean("Dark_Ochre",true);editor.putBoolean("Crokite",true);editor.putBoolean("Spodumain",true);editor.putBoolean("Bistot",true);break;
                case "M": editor.putBoolean("Veldspar",true);editor.putBoolean("Scordite",true);editor.putBoolean("Plagioclase",true);editor.putBoolean("Omber",true);editor.putBoolean("Jaspet",true);editor.putBoolean("Hemorphite",true);editor.putBoolean("Dark_Ochre",true);editor.putBoolean("Crokite",true);editor.putBoolean("Arkonor",true);editor.putBoolean("Bistot",true);break;
                case "G": editor.putBoolean("Veldspar",true);editor.putBoolean("Scordite",true);editor.putBoolean("Plagioclase",true);editor.putBoolean("Omber",true);editor.putBoolean("Kernite",true);editor.putBoolean("Hedbergite",true);editor.putBoolean("Spodumain",true);editor.putBoolean("Gneiss",true);editor.putBoolean("Arkonor",true);editor.putBoolean("Bistot",true);break;
                case "All": editor.putBoolean("Veldspar",true);editor.putBoolean("Scordite",true);editor.putBoolean("Pyroxeres",true);editor.putBoolean("Plagioclase",true);editor.putBoolean("Omber",true);editor.putBoolean("Kernite",true);editor.putBoolean("Jaspet",true);editor.putBoolean("Hemorphite",true);editor.putBoolean("Hedbergite",true);editor.putBoolean("Gneiss",true);editor.putBoolean("Dark_Ochre",true);editor.putBoolean("Crokite",true);editor.putBoolean("Arkonor",true);editor.putBoolean("Bistot",true);editor.putBoolean("Spodumain",true);break;
            }break;
        }
        editor.commit();
        dialog.cancel();
        loadViews();
    }


    
    public void setArkonor(View mArkonor) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("Arkonor",Arkonor.isChecked());
        editor.commit();
    }
    public void setBistot(View mBistot) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("Bistot",Bistot.isChecked());
        editor.commit();
    }
    public void setCrokite(View mCrokite) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("Crokite",Crokite.isChecked());
        editor.commit();
    }
    public void setDark_Ochre(View mDark_Ochre) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("Dark_Ochre",Dark_Ochre.isChecked());
        editor.commit();
    }
    public void setGneiss(View mGneiss) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("Gneiss",Gneiss.isChecked());
        editor.commit();
    }
    public void setHedbergite(View mHedbergite) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("Hedbergite",Hedbergite.isChecked());
        editor.commit();
    }
    public void setHemorphite(View mHemorphite) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("Hemorphite",Hemorphite.isChecked());
        editor.commit();
    }
    public void setJaspet(View mJaspet) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("Jaspet",Jaspet.isChecked());
        editor.commit();
    }
    public void setKernite(View mKernite) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("Kernite",Kernite.isChecked());
        editor.commit();
    }
    public void setMercoxit(View mMercoxit) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("Mercoxit",Mercoxit.isChecked());
        editor.commit();
    }
    public void setOmber(View mOmber) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("Omber",Omber.isChecked());
        editor.commit();
    }
    public void setPlagioclase(View mPlagioclase) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("Plagioclase",Plagioclase.isChecked());
        editor.commit();
    }
    public void setPyroxeres(View mPyroxeres) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("Pyroxeres",Pyroxeres.isChecked());
        editor.commit();
    }
    public void setScordite(View mScordite) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("Scordite",Scordite.isChecked());
        editor.commit();
    }
    public void setSpodumain(View mSpodumain) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("Spodumain",Spodumain.isChecked());
        editor.commit();
    }
    public void setVariants(View mVariants) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("Variants",Variants.isChecked());
        editor.commit();
    }
    public void setVeldspar(View mVeldspar) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("Veldspar",Veldspar.isChecked());
        editor.commit();
    }



}
