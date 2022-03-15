package com.example.cityapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.constraintlayout.motion.utils.ViewSpline;

public class Hospital extends ListActivity {
    protected void onCreate (Bundle icircle) {
        super.onCreate(icircle);
        String[] listHospital = new String[] {"Syafira Hospital", "Ibnu Sina Hospital", "Tabrani Hospital"};
        this.setListAdapter(new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1,listHospital));
    }

    protected void onListItemClick (ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Object o = this.getListAdapter().getItem(position);
        String option = o.toString();
        showoption(option);
    }

    private void showoption(String option) {
        try {
            Intent u = null;
            if (option.equals("Syafira Hospital")) {
                u = new Intent(this,SyafiraHospital.class);
            } else if (option.equals("Ibnu Sina Hospital")) {
                u = new Intent(this,IbnuSinaHospital.class);
            } else if (option.equals("Tabrani Hospital")) {
                u = new Intent(this, TabraniHospital.class);
            }
                startActivity(u);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}