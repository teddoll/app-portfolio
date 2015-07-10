package com.teddoll.appportfolio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String toastFormat = getString(R.string.toast_format);

        //TODO better way to get device locale?
        Locale locale = Locale.getDefault();

        //Populating Strings from strings.xml once onCreate.
        final String[] toasts = new String[]{
                String.format(locale, toastFormat, getString(R.string.title_streamer)),
                String.format(locale, toastFormat, getString(R.string.title_super_duo_one)),
                String.format(locale, toastFormat, getString(R.string.title_super_duo_two)),
                String.format(locale, toastFormat, getString(R.string.title_build_bigger)),
                String.format(locale, toastFormat, getString(R.string.title_xyz_reader)),
                String.format(locale, toastFormat, getString(R.string.title_capstone)),
        };

        final int[] ids = new int[]{
                R.id.button_steamer,
                R.id.button_duo_one,
                R.id.button_duo_two,
                R.id.button_bigger,
                R.id.button_xyz,
                R.id.button_capstone
        };


        setButtonListeners(toasts, ids);
    }

    private void setButtonListeners(final String[] toasts, final int[] ids) {
        for(int i = 0; i < ids.length; i++) {
            final int position = i;
            //findViewById per button will only be called once during onCreate.
            findViewById(ids[position]).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showToast(toasts[position]);
                }
            });
        }
    }

    private void showToast(String title) {
        Toast.makeText(this, title, Toast.LENGTH_LONG).show();
    }

}
