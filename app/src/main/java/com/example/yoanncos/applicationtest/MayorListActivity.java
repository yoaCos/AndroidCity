package com.example.yoanncos.applicationtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.yoanncos.applicationtest.Adapter.MayorAdapter;
import com.example.yoanncos.applicationtest.Entity.Mayor;

import java.util.ArrayList;

/**
 * Created by Yoann.Cos on 06/05/2015.
 */
public class MayorListActivity extends Activity{

    private final String EXTRA_MAYOR = "Maire";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_mayor);

        final ArrayList<Mayor> arrayListMayor = new ArrayList<>();
        initList(arrayListMayor);

        final MayorAdapter mayorAdapter = new MayorAdapter(this, R.layout.row_mayor, arrayListMayor);
        ListView listMayors = (ListView)findViewById(R.id.listMayor);
        listMayors.setAdapter(mayorAdapter);

        listMayors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Mayor selectedItem = (Mayor)mayorAdapter.getItem(position);

                Intent intent = new Intent(MayorListActivity.this, MayorActivity.class);
                intent.putExtra(EXTRA_MAYOR, selectedItem);
                startActivity(intent);
            }
        });

    }



    private void initList(ArrayList<Mayor> arrayListMayor) {

        Mayor hidalgoParis = new Mayor();
        hidalgoParis.setName("Hidalgo");
        hidalgoParis.setCity("Paris");
        hidalgoParis.setAge(55);
        hidalgoParis.setExperience(1);
        arrayListMayor.add(hidalgoParis);

        Mayor marionoRome = new Mayor();
        marionoRome.setName("Marino");
        marionoRome.setCity("Rome");
        marionoRome.setAge(80);
        marionoRome.setExperience(35);
        arrayListMayor.add(marionoRome);

        Mayor botellaMadrid = new Mayor();
        botellaMadrid.setName("Botella");
        botellaMadrid.setCity("Madrid");
        botellaMadrid.setAge(40);
        botellaMadrid.setExperience(6);
        arrayListMayor.add(botellaMadrid);

        Mayor mullerBerlin = new Mayor();
        mullerBerlin.setName("Muller");
        mullerBerlin.setCity("Berlin");
        mullerBerlin.setAge(60);
        mullerBerlin.setExperience(10);
        arrayListMayor.add(mullerBerlin);

        Mayor johnsonLondres = new Mayor();
        johnsonLondres.setName("Johnson");
        johnsonLondres.setCity("Londres");
        johnsonLondres.setAge(57);
        johnsonLondres.setExperience(6);
        arrayListMayor.add(johnsonLondres);

        Mayor costaLisbone = new Mayor();
        costaLisbone.setName("Costa");
        costaLisbone.setCity("Lisbone");
        costaLisbone.setAge(32);
        costaLisbone.setExperience(1);
        arrayListMayor.add(costaLisbone);
    }
}
