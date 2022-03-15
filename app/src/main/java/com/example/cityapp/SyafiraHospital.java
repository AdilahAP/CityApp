package com.example.cityapp;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

    public class SyafiraHospital extends ListActivity {
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
                    String phonenumber ="tel:62761-37947";
                    u = new Intent(Intent.ACTION_DIAL, Uri.parse(phonenumber));
                } else if (option.equals("SMS Center")) {
                    String sms ="Assalamualaikum wr.wb";
                    u = new Intent(Intent.ACTION_VIEW);
                    u.setData(Uri.parse("sms:0822-1000-3636"));
                    u.putExtra("sms_body",sms);
                } else if (option.equals("Driving Direction")) {
                    String location ="google.navigation:q=0.498400192599701, 101.45481875435007";
                    u = new Intent(Intent.ACTION_VIEW, Uri.parse(location));
                } else if (option.equals("Website")) {
                    String website ="https://www.rs-syafira.com/";
                    u = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
                } else if (option.equals("Info di Google")) {
                    u = new Intent(Intent.ACTION_WEB_SEARCH);
                    u.putExtra(SearchManager.QUERY,"Syafira Hospital");
                }
                startActivity(u);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
