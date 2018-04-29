package com.example.miafandi.foody;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by MIAfandi on 07/12/2017.
 */

public class SliderIntromanagerActivity {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;

    public SliderIntromanagerActivity(Context context){
        this.context = context;
        this.pref = context.getSharedPreferences("first", 0);
        this.editor = pref.edit();
    }

    public void setFirst(boolean isFirst){
        editor.putBoolean("check",isFirst);
        editor.commit();
    }

    public boolean Check(){
        return pref.getBoolean("check",true);
    }
}
