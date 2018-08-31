package com.app.shahrdarirouls;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.shahrdarirouls.DataBase.DataSource.tb_FavoriteDATASource;
import com.app.shahrdarirouls.DataBase.Table.tb_Favorite;

import java.util.List;

public class Activity_Favorite extends AppCompatActivity {

    List<tb_Favorite> data;
    ListView lstFavorite;
    //    UserList listViewPersonAdapter;
    String[] asd = {"sadf", "asdfa", "asdfa", "asdfa", "asdfa", "asdfa", "asdfa"};
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        final tb_FavoriteDATASource tb_favoriteDATASource = new tb_FavoriteDATASource(Activity_Favorite.this);
        tb_favoriteDATASource.Open();
        data = tb_favoriteDATASource.GetList();
        tb_favoriteDATASource.Close();


        lstFavorite = (ListView) findViewById(R.id.lstFavorite);

        final ArrayAdapter adapterFavorite = new ArrayAdapter(Activity_Favorite.this, R.layout.activity_favorite, data) {
            @NonNull
            @Override
            public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                convertView = getLayoutInflater().inflate(R.layout.row_lst_favorite, parent, false);
                TextView txtLstFav = (TextView) convertView.findViewById(R.id.txtLstFav);
                Button btnLstFav = (Button) convertView.findViewById(R.id.btnLstFav);


                txtLstFav.setText(data.get(position).IdPost + "\n");
                txtLstFav.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Activity_Favorite.this, Activity_Show.class);
                        intent.putExtra("KEY", data.get(position).IdPost + "");
                        startActivity(intent);
                    }
                });

                btnLstFav.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tb_FavoriteDATASource tb_favoriteDATASource1 = new tb_FavoriteDATASource(Activity_Favorite.this);
                        tb_favoriteDATASource1.Open();
                        tb_favoriteDATASource1.Delete(data.get(position).IdPost);
                        tb_favoriteDATASource1.Close();
                        data.remove(position);
                        notifyDataSetChanged();
                    }
                });

                return convertView;
            }
        };
        lstFavorite.setAdapter(adapterFavorite);

    }
}