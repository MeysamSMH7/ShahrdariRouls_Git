package com.app.shahrdarirouls;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.shahrdarirouls.DataBase.DataSource.tb_FavoriteDATASource;
import com.app.shahrdarirouls.DataBase.DataSource.tb_ShahrdariroulsDATASource;
import com.app.shahrdarirouls.DataBase.Table.tb_Favorite;
import com.app.shahrdarirouls.DataBase.Table.tb_ShahrdariRouls;

import java.util.List;

public class Activity_Favorite extends AppCompatActivity {

    List<tb_Favorite> data;
    ListView lstFavorite;
    //List<tb_ShahrdariRouls> dataShar;
    //tb_ShahrdariroulsDATASource tb_shahrdariroulsDATASource;


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


//        tb_shahrdariroulsDATASource = new tb_ShahrdariroulsDATASource(Activity_Favorite.this);
//
//
//        tb_shahrdariroulsDATASource.Open();
//
//
//        for (tb_Favorite dat : data) {
//            dataShar = tb_shahrdariroulsDATASource.GetRecordBySubPostsForFavorite(dat.IdPost);
//        }
//
//
//        tb_shahrdariroulsDATASource.Close();


        lstFavorite = (ListView) findViewById(R.id.lstFavorite);


        final ArrayAdapter adapterFavorite = new ArrayAdapter(Activity_Favorite.this, R.layout.activity_favorite, data) {
            @NonNull
            @Override
            public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                convertView = getLayoutInflater().inflate(R.layout.row_lst_favorite, parent, false);
                TextView txtLstFav = (TextView) convertView.findViewById(R.id.txtLstFav);
                TextView description = (TextView) convertView.findViewById(R.id.description);
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

//    UserList.IListSelectItemCallback iListSelectItemCallback = new UserList.IListSelectItemCallback() {
//        @Override
//        public void SelectedItemCallback(tb_ShahrdariRouls info) {
//            Intent intent = new Intent(Activity_Favorite.this, Activity_Show.class);
//            intent.putExtra("KEY", info.PK_Shahrdari + "");
//            startActivity(intent);
//        }
//
//        @Override
//        public void DirectCall_CallBack(int id) {
//            tb_FavoriteDATASource tb_favoriteDATASource1 = new tb_FavoriteDATASource(Activity_Favorite.this);
//            tb_favoriteDATASource1.Open();
//            tb_favoriteDATASource1.Delete(id);
//            tb_favoriteDATASource1.Close();
//        }
//    };


//class UserList extends BaseAdapter {
//    private Context context;
//    private List<tb_ShahrdariRouls> lstfavorite;
//    private IListSelectItemCallback _IListSelectItemCallback;
//    private int _templateResourceId;
//    private LayoutInflater inflater = null;
//
//
//    TextView txtLstFav;
//    Button btnLstFav;
//
//
//    public interface IListSelectItemCallback {
//        public void SelectedItemCallback(tb_ShahrdariRouls info);
//
//        public void DirectCall_CallBack(int id);
//    }
//
//    public UserList(Activity activity, List<tb_ShahrdariRouls> favorites, IListSelectItemCallback iListSelectItemCallback, int templateResourceId) {
//        context = activity;
//        lstfavorite = favorites;
//        _IListSelectItemCallback = iListSelectItemCallback;
//        _templateResourceId = templateResourceId;
//
//
//        inflater = LayoutInflater.from(context);
//    }
//
//    @Override
//    public int getCount() {
//        return lstfavorite.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return position;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//
//    @Override
//    public View getView(final int position, View convertView, ViewGroup parent) {
//        View rowView;
//        rowView = inflater.inflate(_templateResourceId, null);
//
//        txtLstFav = (TextView) rowView.findViewById(R.id.txtLstFav);
//        btnLstFav = (Button) rowView.findViewById(R.id.btnLstFav);
//
//
//        txtLstFav.setText(String.format("%s",
//                lstfavorite.get(position).RoulsNAme));
//
//
//        btnLstFav.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (_IListSelectItemCallback != null) {
//                    _IListSelectItemCallback.DirectCall_CallBack(lstfavorite.get(position).PK_Shahrdari);
//                }
//            }
//        });
//
//        rowView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (_IListSelectItemCallback != null) {
//                    _IListSelectItemCallback.SelectedItemCallback(lstfavorite.get(position));
//                }
//            }
//        });
//
//        return rowView;
//    }
//}
