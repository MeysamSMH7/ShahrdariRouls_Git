package com.app.shahrdarirouls;

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
    String[] asd = {"sadf","asdfa","asdfa","asdfa","asdfa","asdfa","asdfa"};
ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        final tb_FavoriteDATASource tb_favoriteDATASource = new tb_FavoriteDATASource(Activity_Favorite.this);
        tb_favoriteDATASource.Open();
        data = tb_favoriteDATASource.GetList();
        tb_favoriteDATASource.Close();



        // بشسیبشسیب

        lstFavorite = (ListView) findViewById(R.id.lstFavorite);

        final ArrayAdapter adapterFavorite = new ArrayAdapter(Activity_Favorite.this, R.layout.activity_favorite, data) {
            @NonNull
            @Override
            public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                convertView = getLayoutInflater().inflate(R.layout.row_lst_favorite, parent, false);
                TextView txtLstFav = (TextView) convertView.findViewById(R.id.txtLstFav);
                Button btnLstFav = (Button) convertView.findViewById(R.id.btnLstFav);


                txtLstFav.setText(data.get(position).IdPost+"\n");
                txtLstFav.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(Activity_Favorite.this, position + "", Toast.LENGTH_SHORT).show();
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















//        listViewPersonAdapter = new UserList(Activity_Favorite.this, data , iListSelectItemCallback, R.layout.row_lst_favorite);
//
//        lstFavorite.setAdapter(listViewPersonAdapter);


    }


//    UserList.IListSelectItemCallback iListSelectItemCallback = new UserList.IListSelectItemCallback() {
//        @Override
//        public void SelectedItemCallback(tb_Favorite info , Context context) {
//            Intent intent= new Intent(Activity_Favorite.this,Activity_Show.class);
//            intent.putExtra("KEY",info.IdPost+"");
//            context.startActivity(intent);
//        }
//
//        @Override
//        public void DirectCall_CallBack(int IdPost) {
//            tb_FavoriteDATASource tb_favoriteDATASource = new tb_FavoriteDATASource(Activity_Favorite.this);
//            tb_favoriteDATASource.Open();
//            tb_favoriteDATASource.Delete(IdPost);
//            tb_favoriteDATASource.Close();
//        }
//    };

}


//class UserList extends BaseAdapter {
//        private Context context;
//        private List<tb_Favorite> lstPI;
//        private IListSelectItemCallback _IListSelectItemCallback;
//        private int _templateResourceId;
//        private LayoutInflater inflater = null;
//
//        TextView txtLstFav;
//        Button btnLstFav;
//
//
//
//    public interface IListSelectItemCallback {
//        public void SelectedItemCallback(tb_Favorite info , Context context);
//
//        public void DirectCall_CallBack(int IdPost);
//    }
//
//    public UserList(Context activity, List<tb_Favorite> listPerson, IListSelectItemCallback iListSelectItemCallback, int templateResourceId) {
//        context = activity;
//        lstPI = listPerson;
//        _IListSelectItemCallback = iListSelectItemCallback;
//        _templateResourceId = templateResourceId;
//
//        inflater = LayoutInflater.from(context);
//    }
//
//    @Override
//    public int getCount() {
//        return lstPI.size();
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
//        final View rowView;
//        rowView = inflater.inflate(_templateResourceId, null);
//
//        txtLstFav = (TextView) rowView.findViewById(R.id.txtLstFav);
//
//        btnLstFav = (Button) rowView.findViewById(R.id.btnLstFav);
//
//
//        txtLstFav.setText(String.format("%s",
//                lstPI.get(position).IdPost));
//
//
//        btnLstFav.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (_IListSelectItemCallback != null) {
//                    _IListSelectItemCallback.DirectCall_CallBack(lstPI.get(position).IdPost);
//                    lstPI.remove(position);
//                    notifyDataSetChanged();
//                }
//            }
//        });
//
//        rowView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (_IListSelectItemCallback != null) {
//                    _IListSelectItemCallback.SelectedItemCallback(lstPI.get(position) , context);
//                }
//            }
//        });
//
//        return rowView;
//    }
//}

