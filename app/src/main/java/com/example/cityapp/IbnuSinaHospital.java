package com.example.cityapp;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class IbnuSinaHospital extends ListActivity {
    protected void onCreate (Bundle icircle) {
        super.onCreate(icircle);
        String[] listAct = new String[] {"Call Center", "SMS Center", "Driving Direction", "Website", "Info di Google", "Exit"};
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listAct));
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
            if (option.equals("Call Center")) {
                String phonenumber ="tel:0761-24242";
                u = new Intent(Intent.ACTION_DIAL, Uri.parse(phonenumber));
            } else if (option.equals("SMS Center")) {
                String sms ="Assalamualaikum wr.wb";
                u = new Intent(Intent.ACTION_VIEW);
                u.setData(Uri.parse("sms:082287607366"));
                u.putExtra("sms_body",sms);
            } else if (option.equals("Driving Direction")) {
                String location ="google.navigation:q=0.525700436987654, 101.437094717691";
                u = new Intent(Intent.ACTION_VIEW, Uri.parse(location));
            } else if (option.equals("Website")) {
                String website ="https://www.rsi-ibnusina.com/";
                u = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
            } else if (option.equals("Info di Google")) {
                u = new Intent(Intent.ACTION_WEB_SEARCH);
                u.putExtra(SearchManager.QUERY,"Ibnu Sina Hospital Pekanbaru");
            }
            startActivity(u);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}