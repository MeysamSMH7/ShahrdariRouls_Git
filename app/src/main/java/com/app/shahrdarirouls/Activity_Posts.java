package com.app.shahrdarirouls;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.shahrdarirouls.DataBase.DataSource.tb_FavoriteDATASource;
import com.app.shahrdarirouls.DataBase.DatabaseManagement;
import com.app.shahrdarirouls.DataBase.MyDateBase;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Activity_Posts extends AppCompatActivity {
    private static final int Time_Between_Two_Back = 2000;
    private long TimeBackPressed;
    //    private MyDateBase db;
    private DatabaseManagement db;

    //    String[] lstNameMain = {"تهران و ری و تجریش", "شورای استان", "شورای اسلامی استان", "شورای بخش", "شورای تهران", "شورای روستا", "شورای روستا و بخش", "شورای روستای عشایری", "شورای شهر", "شورای شهر و روستا", "شورای شهر وروستا", "شورای شهرستان", "شورای شهرستان،استان و عالی استانها", "شورای عالی استان", "شورای عالی استانها", "شوراي عالي استانها", "کلیه شوراها", "مالی", "مالی سایر شهرداری ها", "مالی کلانشهر و مراکز استان"};
    ArrayList<String> lstNameMain = new ArrayList<String>();


    int[] lstPicMain = {
            R.drawable.add, R.drawable.about_us, R.drawable.bookmark, R.drawable.building,
            R.drawable.building_icon, R.drawable.cityscape, R.drawable.contact, R.drawable.ebook,
            R.drawable.menu, R.drawable.logout, R.drawable.share, R.drawable.share,
            R.drawable.add, R.drawable.about_us, R.drawable.bookmark, R.drawable.building,
            R.drawable.building_icon, R.drawable.cityscape, R.drawable.contact, R.drawable.ebook,
            R.drawable.menu, R.drawable.logout, R.drawable.search, R.drawable.search
    };

    String[] pdfNames1 = {"پی دی اف یک", "پی دی اف دو", "پی دی اف سه", "پی دی اف چهار", "پی دی اف پنج", "پی دی اف شش" , "پی دی اف هفت" , "پی دی اف هشت" , "پی دی اف نه"};
    String[] pdfNames2 = {"پی دی اف یک", "پی دی اف دو", "پی دی اف سه", "پی دی اف چهار"};
    String[] pdfNames3 = {"پی دی اف یک", "پی دی اف دو", "پی دی اف سه", "پی دی اف چهار"};

    AlertDialog pdf_selector, about_connect_us;
    DrawerLayout drawerLayout_sr;
    NavigationView navigationview_sr;


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FontSize fontSize = new FontSize(this);
        fontSize.setFontSize();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        if (!(Build.VERSION.SDK_INT < 23)) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
        }

        db = new DatabaseManagement(Activity_Posts.this);

        Toolbar toolbar_sr = (Toolbar) findViewById(R.id.toolbar_sr);
        drawerLayout_sr = (DrawerLayout) findViewById(R.id.drawerLayout_sr);
        navigationview_sr = (NavigationView) findViewById(R.id.navigationview_sr);


        setSupportActionBar(toolbar_sr);

        final ListView lstGVMain = (ListView) findViewById(R.id.lstGVMain);
//        CustomGridView customGridView = new CustomGridView(Activity_Posts.this, lstNameMain, lstPicMain);
//        lstGVMain.setAdapter(customGridView);

        lstGVMain.setDivider(null);


        lstNameMain.add("قوانین مرتبط با شوراها");
        lstNameMain.add("قوانین مرتبط با مالی");
        lstNameMain.add("قوانین مرتبط با شهرداری و املاک");
        lstNameMain.add("جستجوی موضوعی قوانین");


        final ArrayAdapter adapterFavorite = new ArrayAdapter(Activity_Posts.this, R.layout.activity_posts, lstNameMain) {
            @NonNull
            @Override
            public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                convertView = getLayoutInflater().inflate(R.layout.row_list_of_posts_activity, parent, false);

                TextView title = (TextView) convertView.findViewById(R.id.title);


                title.setText(lstNameMain.get(position) + "\n");
                title.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (lstNameMain.get(position) == "جستجوی موضوعی قوانین") {
                            Intent intentSerach = new Intent(Activity_Posts.this, Activity_Search_SR.class);
                            startActivity(intentSerach);
                        } else {
//                            Intent intent = new Intent(Activity_Posts.this, Activity_PDF_View.class);
//                            intent.putExtra("KEY", lstNameMain.get(position) + "");
//                            startActivity(intent);
                            if (lstNameMain.get(position) == "قوانین مرتبط با شوراها"){
                                AlertDialogPDF1();
                            }else if (lstNameMain.get(position) == "قوانین مرتبط با مالی"){
                                AlertDialogPDF2();
                            }else if (lstNameMain.get(position) == "قوانین مرتبط با شهرداری و املاک"){
                                AlertDialogPDF3();
                            }
                        }
                    }
                });


                return convertView;
            }
        };
        lstGVMain.setAdapter(adapterFavorite);


//        lstGVMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
////                Intent intent = new Intent(Activity_Posts.this, Activity_SubPosts.class);
//
//                if (i == 22) {
//                    Intent intentSerach = new Intent(Activity_Posts.this, Activity_Search_SR.class);
//                    startActivity(intentSerach);
//                } else {
//                    Intent intent = new Intent(Activity_Posts.this, Activity_PDF_View.class);
//                    intent.putExtra("KeyPDF", lstNameMain[i] + "");
//                    startActivity(intent);
//                }
//
//
//            }
//        });


        navigationview_sr.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                Switch_NV_Items(id);
                drawerLayout_sr.closeDrawer(Gravity.RIGHT);
                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {


        }
        if (id == R.id.menu_dr) {
            drawerLayout_sr.openDrawer(Gravity.RIGHT);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    //pdf AlertDialogs ***********************************************


    private void AlertDialogPDF1() {

        AlertDialog.Builder builder_pdfSelector = new AlertDialog.Builder(Activity_Posts.this);
        LinearLayout linearLayout_pdfSelector = (LinearLayout) getLayoutInflater().inflate(R.layout.pdf_selector, null, false);
        final ListView listPDFSelector = linearLayout_pdfSelector.findViewById(R.id.listPDFSelector);
        ArrayAdapter arrayAdapterPDF = new ArrayAdapter(Activity_Posts.this, android.R.layout.simple_list_item_1, pdfNames1);
        listPDFSelector.setAdapter(arrayAdapterPDF);
        listPDFSelector.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intentPDF = new Intent(Activity_Posts.this, Activity_PDF_View.class);
                switch (pdfNames1[i]) {
                    case "پی دی اف یک":
                        intentPDF.putExtra("KeyPDF", "1-1");
                        break;
                    case "پی دی اف دو":
                        intentPDF.putExtra("KeyPDF", "1-2");
                        break;
                    case "پی دی اف سه":
                        intentPDF.putExtra("KeyPDF", "1-3");
                        break;
                    case "پی دی اف چهار":
                        intentPDF.putExtra("KeyPDF", "1-4");
                        break;
                    case "پی دی اف پنج":
                        intentPDF.putExtra("KeyPDF", "1-5");
                        break;
                    case "پی دی اف شش":
                        intentPDF.putExtra("KeyPDF", "1-6");
                        break;

                    case "پی دی اف هفت":
                        intentPDF.putExtra("KeyPDF", "1-7");
                        break;

                    case "پی دی اف هشت":
                        intentPDF.putExtra("KeyPDF", "2-8");
                        break;

                    case "پی دی اف نه":
                        intentPDF.putExtra("KeyPDF", "2-9");
                        break;
                }
                startActivity(intentPDF);
                pdf_selector.dismiss();
            }
        });

        builder_pdfSelector.setView(linearLayout_pdfSelector);
        pdf_selector = builder_pdfSelector.create();
        pdf_selector.show();

    }

    private void AlertDialogPDF2() {

        AlertDialog.Builder builder_pdfSelector = new AlertDialog.Builder(Activity_Posts.this);
        LinearLayout linearLayout_pdfSelector = (LinearLayout) getLayoutInflater().inflate(R.layout.pdf_selector, null, false);
        final ListView listPDFSelector = linearLayout_pdfSelector.findViewById(R.id.listPDFSelector);
        ArrayAdapter arrayAdapterPDF = new ArrayAdapter(Activity_Posts.this, android.R.layout.simple_list_item_1, pdfNames2);
        listPDFSelector.setAdapter(arrayAdapterPDF);
        listPDFSelector.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intentPDF = new Intent(Activity_Posts.this, Activity_PDF_View.class);
                switch (pdfNames2[i]) {
                    case "پی دی اف یک":
                        intentPDF.putExtra("KeyPDF", "2-1");
                        break;
                    case "پی دی اف دو":
                        intentPDF.putExtra("KeyPDF", "2-2");
                        break;
                    case "پی دی اف سه":
                        intentPDF.putExtra("KeyPDF", "2-2");
                        break;
                    case "پی دی اف چهار":
                        intentPDF.putExtra("KeyPDF", "2-2");
                        break;
                }
                startActivity(intentPDF);
                pdf_selector.dismiss();
            }
        });

        builder_pdfSelector.setView(linearLayout_pdfSelector);
        pdf_selector = builder_pdfSelector.create();
        pdf_selector.show();

    }


    private void AlertDialogPDF3() {

        AlertDialog.Builder builder_pdfSelector = new AlertDialog.Builder(Activity_Posts.this);
        LinearLayout linearLayout_pdfSelector = (LinearLayout) getLayoutInflater().inflate(R.layout.pdf_selector, null, false);
        final ListView listPDFSelector = linearLayout_pdfSelector.findViewById(R.id.listPDFSelector);
        ArrayAdapter arrayAdapterPDF = new ArrayAdapter(Activity_Posts.this, android.R.layout.simple_list_item_1, pdfNames3);
        listPDFSelector.setAdapter(arrayAdapterPDF);
        listPDFSelector.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intentPDF = new Intent(Activity_Posts.this, Activity_PDF_View.class);
                switch (pdfNames3[i]) {
                    case "پی دی اف یک":
                        intentPDF.putExtra("KeyPDF", "3-1");
                        break;
                    case "پی دی اف دو":
                        intentPDF.putExtra("KeyPDF", "3-2");
                        break;
                    case "پی دی اف سه":
                        intentPDF.putExtra("KeyPDF", "3-3");
                        break;
                    case "پی دی اف چهار":
                        intentPDF.putExtra("KeyPDF", "3-4");
                        break;
                }
                startActivity(intentPDF);
                pdf_selector.dismiss();
            }
        });

        builder_pdfSelector.setView(linearLayout_pdfSelector);
        pdf_selector = builder_pdfSelector.create();
        pdf_selector.show();

    }


    //pdf AlertDialogs ***********************************************



    private void AlertDialogConnectUS() {
        AlertDialog.Builder builder_َACUS2 = new AlertDialog.Builder(Activity_Posts.this);
        LinearLayout linearLayout_ACUS2 = (LinearLayout) getLayoutInflater().inflate(R.layout.about_connect_us, null, false);
        TextView txtView_ACUS2 = (TextView) linearLayout_ACUS2.findViewById(R.id.txtView_ACUS);
//        txtView_ACUS2.setText("این ارتباط با ماست");
        txtView_ACUS2.setText(Html.fromHtml(getString(R.string.StringAboutUs)));
        builder_َACUS2.setView(linearLayout_ACUS2);
        about_connect_us = builder_َACUS2.create();
        about_connect_us.getWindow().setBackgroundDrawableResource(R.color.transparent);
        about_connect_us.show();

    }

    private void AlertDialogAboutUs() {

        AlertDialog.Builder builder_َACUS1 = new AlertDialog.Builder(Activity_Posts.this);
        LinearLayout linearLayout_ACUS1 = (LinearLayout) getLayoutInflater().inflate(R.layout.about_connect_us, null, false);
        TextView txtView_ACUS1 = (TextView) linearLayout_ACUS1.findViewById(R.id.txtView_ACUS);
        txtView_ACUS1.setText("این درباره ی ماست");
        builder_َACUS1.setView(linearLayout_ACUS1);
        about_connect_us = builder_َACUS1.create();
        about_connect_us.getWindow().setBackgroundDrawableResource(R.color.transparent);
        about_connect_us.show();


    }

    private void ImportExelData() {


        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/Backup/dastan123.xls";

        File file = new File(directory_path);
        if (!file.exists()) {
            return;
        }


        ExcelToSQLite excelToSQLite = new ExcelToSQLite(getApplicationContext(), MyDateBase.DATABASE_NAME, true);
        // Import EXCEL FILE to SQLite
        excelToSQLite.importFromFile(directory_path, new ExcelToSQLite.ImportListener() {
            @Override
            public void onStart() {

            }

            @Override
            public void onCompleted(String dbName) {
                Toast.makeText(Activity_Posts.this, "کامل شد", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(Activity_Posts.this, "با مشکل روبه رو شد!", Toast.LENGTH_SHORT).show();
                Log.d("mamad", e.getMessage());
            }
        });

    }

    private void Switch_NV_Items(int id) {
        switch (id) {


            case R.id.Search:
                Intent intentSerach = new Intent(Activity_Posts.this, Activity_Search_SR.class);
                startActivity(intentSerach);
                break;
//            case R.id.PDFs:
//                AlertDialogPDF();

//                break;
            case R.id.AddXLS:
                ImportExelData();

                break;
            case R.id.Setting:
                Intent intentSetting = new Intent(Activity_Posts.this, Activity_Setting.class);
                startActivity(intentSetting);

                break;
            case R.id.Favorit:
                Intent intent = new Intent(Activity_Posts.this, Activity_Favorite.class);
                startActivity(intent);

                break;
            case R.id.AboutUs:
                AlertDialogAboutUs();

                break;
            case R.id.ConnectUS:
                AlertDialogConnectUS();

                break;
            case R.id.Exit:
                finish();
                break;


        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout_sr.isDrawerOpen(Gravity.RIGHT)) {
            drawerLayout_sr.closeDrawer(Gravity.RIGHT);
        } else {
            if (TimeBackPressed + Time_Between_Two_Back > System.currentTimeMillis()) {
                super.onBackPressed();
                return;
            } else {
                Toast.makeText(getBaseContext(), "برای خروج دوباره کلیک کنید", Toast.LENGTH_SHORT).show();
            }
            TimeBackPressed = System.currentTimeMillis();

            //   super.onBackPressed();
        }
    }

}
