package com.app.shahrdarirouls;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.app.shahrdarirouls.DataBase.DataSource.tb_ShahrdariroulsDATASource;
import com.app.shahrdarirouls.DataBase.Table.tb_ShahrdariRouls;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Activity_Search_SR extends AppCompatActivity {

    static ProgressBar progressBarSE;

    LinearLayout linerFirstSearch, linerSecondSearch;
    Recycler_View_Adapter adapterSE;
    RecyclerView recyclerviewSE;
    ListView listSharhOne, lstViewShoraMashmol, lstViewShowSearch;
    EditText edtTxtSearchinTxt;
    TextView btnSearch;

    List<Data> dataSERACH;
    List<tb_ShahrdariRouls> data;
    List<tb_ShahrdariRouls> datatxt;

    String[] ListViewItemsShora = new String[]{"تهران و ری و تجریش", "شوراهای اسلامی شهرستان، استان و شورای عالی استانها", "شورای استان", "شورای اسلامی استان", "شورای بخش", "شورای تهران", "شورای روستا", "شورای روستا و بخش", "شورای روستای عشایری", "شورای شهر", "شورای شهر و روستا", "شورای شهر وروستا", "شورای شهرستان", "شورای شهرستان،استان و عالی استانها", "شورای عالی استان", "شورای عالی استانها", "شوراي عالي استانها", "کلیه شوراها", "مالی", "مالی سایر شهرداری ها", "مالی کلانشهر و مراکز استان"};
    String[] ListViewItemsSharh = new String[]{"اجاره و فروش", "اداره جلسات و اخطار مغایرت قانونی", "ادغام و انحلال و تبدیل به شهر", "ارسال مصوبات", "ارگانهای دولتی", "استفاده از درآمد", "استقراض ", "اطلاع رسانی", "افزایش و کاهش", "الزامات", "امانی", "اموال", "انتخاب شهردار", "اولین جلسه", "انتخاب", "انواع", "بودجه", "پاداش", "پاسخ گویی و استیضاح", "پلاک کوبی و ثبت", "پیشنهادات ", "تامین اعتبار بودجه شورای شهر", "تامین اعتبارات اجرای قانون نوسازی از محل درآمد 10 درصد قانون نوسازی", "تبعیت مقامات", "تجدید مناقصه", "تحقیق و تفحص", "تحلیف و سوگند", "تحویل", "تخلف و محکومیت و محرومیت و حل اختلاف", "تصرف در سپرده", "تطبیق", "تقسیط", "توازن بودجه", "تهران", "جانشین و تفویض اختیار و مسئولیت", "حد نصاب", "حساب مخصوص وصول عوارض", "حراج", "حسن انجام کار", "حسابرسی", "درآمد", "حفظ و حراست", "رسمیت و اعتبار", "دفاتر حسابداری", "سهم فرهنگ و خیریه و درمان", "شرکتهای دولتی", "شیوه عمل معاملات متوسط", "صندوق", "عوارض", "عدم حضور برندگان", "کالای انحصاری", "قرارداد", "مراحل حسابرسی", "کمیسیون", "مصرف اعتبارات در همان حوزه", "مزایده", "مفاصا حساب عوارض ملک", "معاملات", "مکان و زمان", "مناقصه محدود", "مناقصه", "موسسات وابسته", "مناقصه محدود و تجدید و ترک مناقصه", "مهلت و دوره زمانی", "میزان افزایش و کاهش", " نسبت تخصیص بودجه عمرانی", "نحوه انجام و شیوه عمل", "وصول و نگهداری", "نصاب", "هزینه", "هدف تشکیل و وظایف و اختیارات"};

    String STedtTxtSearchinTxt = "";
    String STchBoxShora_01 = null, STchBoxShora_02 = null, STchBoxShora_03 = null, STchBoxShora_04 = null, STchBoxShora_05 = null, STchBoxShora_06 = null, STchBoxShora_07 = null, STchBoxShora_08 = null, STchBoxShora_09 = null, STchBoxShora_10 = null, STchBoxShora_11 = null, STchBoxShora_12 = null, STchBoxShora_13 = null, STchBoxShora_14 = null, STchBoxShora_15 = null, STchBoxShora_16 = null, STchBoxShora_17 = null, STchBoxShora_18 = null, STchBoxShora_19 = null, STchBoxShora_20 = null, STchBoxShora_21 = null;
    String STchBoxShar_01 = null, STchBoxShar_02 = null, STchBoxShar_03 = null, STchBoxShar_04 = null, STchBoxShar_05 = null, STchBoxShar_06 = null, STchBoxShar_07 = null, STchBoxShar_08 = null, STchBoxShar_09 = null, STchBoxShar_10 = null, STchBoxShar_11 = null, STchBoxShar_12 = null, STchBoxShar_13 = null, STchBoxShar_14 = null, STchBoxShar_15 = null, STchBoxShar_16 = null, STchBoxShar_17 = null, STchBoxShar_18 = null, STchBoxShar_19 = null, STchBoxShar_20 = null, STchBoxShar_21 = null, STchBoxShar_22 = null, STchBoxShar_23 = null, STchBoxShar_24 = null, STchBoxShar_25 = null, STchBoxShar_26 = null, STchBoxShar_27 = null, STchBoxShar_28 = null, STchBoxShar_29 = null, STchBoxShar_30 = null, STchBoxShar_31 = null, STchBoxShar_32 = null, STchBoxShar_33 = null, STchBoxShar_34 = null, STchBoxShar_36 = null, STchBoxShar_37 = null, STchBoxShar_38 = null, STchBoxShar_40 = null, STchBoxShar_41 = null, STchBoxShar_42 = null, STchBoxShar_43 = null, STchBoxShar_44 = null, STchBoxShar_45 = null, STchBoxShar_46 = null, STchBoxShar_47 = null, STchBoxShar_48 = null, STchBoxShar_49 = null, STchBoxShar_51 = null, STchBoxShar_52 = null, STchBoxShar_53 = null, STchBoxShar_54 = null, STchBoxShar_55 = null, STchBoxShar_56 = null, STchBoxShar_57 = null, STchBoxShar_58 = null, STchBoxShar_59 = null, STchBoxShar_61 = null, STchBoxShar_62 = null, STchBoxShar_63 = null, STchBoxShar_64 = null, STchBoxShar_65 = null, STchBoxShar_66 = null, STchBoxShar_67 = null, STchBoxShar_68 = null, STchBoxShar_69 = null, STchBoxShar_39 = null, STchBoxShar_70 = null, STchBoxShar_71 = null, STchBoxShar_72 = null, STchBoxShar_73 = null, STchBoxShar_74 = null;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FontSize fontSize = new FontSize(this);
        fontSize.setFontSize();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_sr);


        linerFirstSearch = (LinearLayout) findViewById(R.id.linerFirstSearch);
        linerSecondSearch = (LinearLayout) findViewById(R.id.linerSecondSearch);
        listSharhOne = (ListView) findViewById(R.id.listSharhOne);
        lstViewShoraMashmol = (ListView) findViewById(R.id.lstViewShoraMashmol);
        lstViewShowSearch = (ListView) findViewById(R.id.lstViewShowSearch);
        recyclerviewSE = (RecyclerView) findViewById(R.id.recyclerview_SE);
        edtTxtSearchinTxt = (EditText) findViewById(R.id.edtTxtSearchinTxt);
        btnSearch = (TextView) findViewById(R.id.btnSearch);

        lstViewShoraMashmol.setDivider(null);
        listSharhOne.setDivider(null);

        ArrayAdapter<String> adapter_SHora = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, ListViewItemsShora);
        ArrayAdapter<String> adapter_Sharh = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, ListViewItemsSharh);
        lstViewShoraMashmol.setAdapter(adapter_SHora);
        listSharhOne.setAdapter(adapter_Sharh);


        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                ListView lv = (ListView) arg0;
                if (lv.isItemChecked(position)) {

                    Switch_Shora_Full(position);
                    Toast.makeText(getBaseContext(), ListViewItemsShora[position] + " چک شد", Toast.LENGTH_SHORT).show();
                } else {

                    Switch_Shora_Null(position);
                    Toast.makeText(getBaseContext(), ListViewItemsShora[position] + " چک برداشته شد", Toast.LENGTH_SHORT).show();
                }

            }
        };

        AdapterView.OnItemClickListener itemClickListener1 = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View arg1, int position, long id) {
                ListView lv = (ListView) adapterView;
                if (lv.isItemChecked(position)) {

                    Switch_Sharh_Full(position);
                    Toast.makeText(getBaseContext(), ListViewItemsSharh[position] + " چک شد", Toast.LENGTH_SHORT).show();
                } else {

                    Switch_Sharh_Null(position);
                    Toast.makeText(getBaseContext(), ListViewItemsSharh[position] + " چک برداشته شد", Toast.LENGTH_SHORT).show();
                }

            }
        };
        lstViewShoraMashmol.setOnItemClickListener(itemClickListener);
        listSharhOne.setOnItemClickListener(itemClickListener1);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ForbtnSearch();
            }
        });
    }

    public List<Data> fill_with_data() {
        List<Data> dataSERACH = new ArrayList<>();
        for (int i = data.size() - 1; i >= 0; i--) {
            dataSERACH.add(new Data(data.get(i).PK_Shahrdari + "", data.get(i).txtRouls + "", data.get(i).PK_Shahrdari));
        }

        return dataSERACH;
    }

    public List<Data> fill_with_data_txt(List<tb_ShahrdariRouls> dataSE) {
        List<Data> dataSERACH = new ArrayList<>();
        for (int i = dataSE.size() - 1; i >= 0; i--) {
            dataSERACH.add(new Data(dataSE.get(i).PK_Shahrdari + "", dataSE.get(i).txtRouls + "", dataSE.get(i).PK_Shahrdari));
        }

        return dataSERACH;
    }

    private void Switch_Shora_Full(int position) {

        switch (ListViewItemsShora[position]) {

            case "تهران و ری و تجریش":
                STchBoxShora_01 = ListViewItemsShora[position];
                break;
            case "شوراهای اسلامی شهرستان، استان و شورای عالی استانها":
                STchBoxShora_02 = ListViewItemsShora[position];
                break;
            case "شورای استان":
                STchBoxShora_03 = ListViewItemsShora[position];
                break;
            case "شورای اسلامی استان":
                STchBoxShora_04 = ListViewItemsShora[position];
                break;
            case "شورای بخش":
                STchBoxShora_05 = ListViewItemsShora[position];
                break;
            case "شورای تهران":
                STchBoxShora_06 = ListViewItemsShora[position];
                break;
            case "شورای روستا":
                STchBoxShora_07 = ListViewItemsShora[position];
                break;
            case "شورای روستا و بخش":
                STchBoxShora_08 = ListViewItemsShora[position];
                break;
            case "شورای روستای عشایری":
                STchBoxShora_09 = ListViewItemsShora[position];
                break;
            case "شورای شهر":
                STchBoxShora_10 = ListViewItemsShora[position];
                break;
            case "شورای شهر و روستا":
                STchBoxShora_11 = ListViewItemsShora[position];
                break;
            case "شورای شهر وروستا":
                STchBoxShora_12 = ListViewItemsShora[position];
                break;
            case "شورای شهرستان":
                STchBoxShora_13 = ListViewItemsShora[position];
                break;
            case "شورای شهرستان،استان و عالی استانها":
                STchBoxShora_14 = ListViewItemsShora[position];
                break;
            case "شورای عالی استان":
                STchBoxShora_15 = ListViewItemsShora[position];
                break;
            case "شورای عالی استانها":
                STchBoxShora_16 = ListViewItemsShora[position];
                break;
            case "شوراي عالي استانها":
                STchBoxShora_17 = ListViewItemsShora[position];
                break;
            case "کلیه شوراها":
                STchBoxShora_18 = ListViewItemsShora[position];
                break;
            case "مالی":
                STchBoxShora_19 = ListViewItemsShora[position];
                break;
            case "مالی سایر شهرداری ها":
                STchBoxShora_20 = ListViewItemsShora[position];
                break;
            case "مالی کلانشهر و مراکز استان":
                STchBoxShora_21 = ListViewItemsShora[position];
                break;
        }


    }

    private void Switch_Shora_Null(int position) {
        switch (ListViewItemsShora[position]) {

            case "تهران و ری و تجریش":
                STchBoxShora_01 = null;
                break;
            case "شوراهای اسلامی شهرستان، استان و شورای عالی استانها":
                STchBoxShora_02 = null;
                break;
            case "شورای استان":
                STchBoxShora_03 = null;
                break;
            case "شورای اسلامی استان":
                STchBoxShora_04 = null;
                break;
            case "شورای بخش":
                STchBoxShora_05 = null;
                break;
            case "شورای تهران":
                STchBoxShora_06 = null;
                break;
            case "شورای روستا":
                STchBoxShora_07 = null;
                break;
            case "شورای روستا و بخش":
                STchBoxShora_08 = null;
                break;
            case "شورای روستای عشایری":
                STchBoxShora_09 = null;
                break;
            case "شورای شهر":
                STchBoxShora_10 = null;
                break;
            case "شورای شهر و روستا":
                STchBoxShora_11 = null;
                break;
            case "شورای شهر وروستا":
                STchBoxShora_12 = null;
                break;
            case "شورای شهرستان":
                STchBoxShora_13 = null;
                break;
            case "شورای شهرستان،استان و عالی استانها":
                STchBoxShora_14 = null;
                break;
            case "شورای عالی استان":
                STchBoxShora_15 = null;
                break;
            case "شورای عالی استانها":
                STchBoxShora_16 = null;
                break;
            case "شوراي عالي استانها":
                STchBoxShora_17 = null;
                break;
            case "کلیه شوراها":
                STchBoxShora_18 = null;
                break;
            case "مالی":
                STchBoxShora_19 = null;
                break;
            case "مالی سایر شهرداری ها":
                STchBoxShora_20 = null;
                break;
            case "مالی کلانشهر و مراکز استان":
                STchBoxShora_21 = null;
                break;
        }
    }

    private void Switch_Sharh_Full(int position) {
        switch (ListViewItemsSharh[position]) {
            case "اجاره و فروش":
                STchBoxShar_01 = ListViewItemsSharh[position];
                break;
            case "اداره جلسات و اخطار مغایرت قانونی":
                STchBoxShar_02 = ListViewItemsSharh[position];
                break;
            case "ادغام و انحلال و تبدیل به شهر":
                STchBoxShar_03 = ListViewItemsSharh[position];
                break;
            case "ارسال مصوبات":
                STchBoxShar_04 = ListViewItemsSharh[position];
                break;
            case "ارگانهای دولتی":
                STchBoxShar_05 = ListViewItemsSharh[position];
                break;
            case "استفاده از درآمد":
                STchBoxShar_06 = ListViewItemsSharh[position];
                break;
            case "استقراض ":
                STchBoxShar_07 = ListViewItemsSharh[position];
                break;
            case "اطلاع رسانی":
                STchBoxShar_08 = ListViewItemsSharh[position];
                break;
            case "افزایش و کاهش":
                STchBoxShar_09 = ListViewItemsSharh[position];
                break;
            case "الزامات":
                STchBoxShar_10 = ListViewItemsSharh[position];
                break;
            case "امانی":
                STchBoxShar_11 = ListViewItemsSharh[position];
                break;
            case "اموال":
                STchBoxShar_12 = ListViewItemsSharh[position];
                break;
            case "انتخاب شهردار":
                STchBoxShar_13 = ListViewItemsSharh[position];
                break;
            case "اولین جلسه":
                STchBoxShar_14 = ListViewItemsSharh[position];
                break;
            case "انتخاب":
                STchBoxShar_15 = ListViewItemsSharh[position];
                break;
            case "انواع":
                STchBoxShar_16 = ListViewItemsSharh[position];
                break;
            case "بودجه":
                STchBoxShar_17 = ListViewItemsSharh[position];
                break;
            case "پاداش":
                STchBoxShar_18 = ListViewItemsSharh[position];
                break;
            case "پاسخ گویی و استیضاح":
                STchBoxShar_19 = ListViewItemsSharh[position];
                break;
            case "پلاک کوبی و ثبت":
                STchBoxShar_20 = ListViewItemsSharh[position];
                break;
            case "پیشنهادات ":
                STchBoxShar_21 = ListViewItemsSharh[position];
                break;
            case "تامین اعتبار بودجه شورای شهر":
                STchBoxShar_22 = ListViewItemsSharh[position];
                break;
            case "تامین اعتبارات اجرای قانون نوسازی از محل درآمد 10 درصد قانون نوسازی":
                STchBoxShar_23 = ListViewItemsSharh[position];
                break;
            case "تبعیت مقامات":
                STchBoxShar_24 = ListViewItemsSharh[position];
                break;
            case "تجدید مناقصه":
                STchBoxShar_25 = ListViewItemsSharh[position];
                break;
            case "تحقیق و تفحص":
                STchBoxShar_26 = ListViewItemsSharh[position];
                break;
            case "تحلیف و سوگند":
                STchBoxShar_27 = ListViewItemsSharh[position];
                break;
            case "تحویل":
                STchBoxShar_28 = ListViewItemsSharh[position];
                break;
            case "تخلف و محکومیت و محرومیت و حل اختلاف":
                STchBoxShar_29 = ListViewItemsSharh[position];
                break;
            case "تصرف در سپرده":
                STchBoxShar_30 = ListViewItemsSharh[position];
                break;
            case "تطبیق":
                STchBoxShar_31 = ListViewItemsSharh[position];
                break;
            case "تقسیط":
                STchBoxShar_32 = ListViewItemsSharh[position];
                break;
            case "توازن بودجه":
                STchBoxShar_33 = ListViewItemsSharh[position];
                break;
            case "تهران":
                STchBoxShar_34 = ListViewItemsSharh[position];
                break;
            case "جانشین و تفویض اختیار و مسئولیت":
                STchBoxShar_36 = ListViewItemsSharh[position];
                break;
            case "حد نصاب":
                STchBoxShar_37 = ListViewItemsSharh[position];
                break;
            case "حساب مخصوص وصول عوارض":
                STchBoxShar_38 = ListViewItemsSharh[position];
                break;
            case "حراج":
                STchBoxShar_40 = ListViewItemsSharh[position];
                break;
            case "حسن انجام کار":
                STchBoxShar_41 = ListViewItemsSharh[position];
                break;
            case "حسابرسی":
                STchBoxShar_42 = ListViewItemsSharh[position];
                break;
            case "درآمد":
                STchBoxShar_43 = ListViewItemsSharh[position];
                break;
            case "حفظ و حراست":
                STchBoxShar_44 = ListViewItemsSharh[position];
                break;
            case "رسمیت و اعتبار":
                STchBoxShar_45 = ListViewItemsSharh[position];
                break;
            case "دفاتر حسابداری":
                STchBoxShar_46 = ListViewItemsSharh[position];
                break;
            case "سهم فرهنگ و خیریه و درمان":
                STchBoxShar_47 = ListViewItemsSharh[position];
                break;
            case "شرکتهای دولتی":
                STchBoxShar_48 = ListViewItemsSharh[position];
                break;
            case "شیوه عمل معاملات متوسط":
                STchBoxShar_49 = ListViewItemsSharh[position];
                break;
            case "صندوق":
                STchBoxShar_51 = ListViewItemsSharh[position];
                break;
            case "عوارض":
                STchBoxShar_52 = ListViewItemsSharh[position];
                break;
            case "عدم حضور برندگان":
                STchBoxShar_53 = ListViewItemsSharh[position];
                break;
            case "کالای انحصاری":
                STchBoxShar_54 = ListViewItemsSharh[position];
                break;
            case "قرارداد":
                STchBoxShar_55 = ListViewItemsSharh[position];
                break;
            case "مراحل حسابرسی":
                STchBoxShar_56 = ListViewItemsSharh[position];
                break;
            case "کمیسیون":
                STchBoxShar_57 = ListViewItemsSharh[position];
                break;
            case "مصرف اعتبارات در همان حوزه":
                STchBoxShar_58 = ListViewItemsSharh[position];
                break;
            case "مزایده":
                STchBoxShar_59 = ListViewItemsSharh[position];
                break;
            case "مفاصا حساب عوارض ملک":
                STchBoxShar_61 = ListViewItemsSharh[position];
                break;
            case "معاملات":
                STchBoxShar_62 = ListViewItemsSharh[position];
                break;
            case "مکان و زمان":
                STchBoxShar_63 = ListViewItemsSharh[position];
                break;
            case "مناقصه محدود":
                STchBoxShar_64 = ListViewItemsSharh[position];
                break;
            case "مناقصه":
                STchBoxShar_65 = ListViewItemsSharh[position];
                break;
            case "موسسات وابسته":
                STchBoxShar_66 = ListViewItemsSharh[position];
                break;
            case "مناقصه محدود و تجدید و ترک مناقصه":
                STchBoxShar_67 = ListViewItemsSharh[position];
                break;
            case "مهلت و دوره زمانی":
                STchBoxShar_68 = ListViewItemsSharh[position];
                break;
            case "میزان افزایش و کاهش":
                STchBoxShar_69 = ListViewItemsSharh[position];
                break;
            case " نسبت تخصیص بودجه عمرانی":
                STchBoxShar_39 = ListViewItemsSharh[position];
                break;
            case "نحوه انجام و شیوه عمل":
                STchBoxShar_70 = ListViewItemsSharh[position];
                break;
            case "وصول و نگهداری":
                STchBoxShar_71 = ListViewItemsSharh[position];
                break;
            case "نصاب":
                STchBoxShar_72 = ListViewItemsSharh[position];
                break;
            case "هزینه":
                STchBoxShar_73 = ListViewItemsSharh[position];
                break;
            case "هدف تشکیل و وظایف و اختیارات":
                STchBoxShar_74 = ListViewItemsSharh[position];
                break;
        }
    }

    private void Switch_Sharh_Null(int position) {
        switch (ListViewItemsSharh[position]) {
            case "اجاره و فروش":
                STchBoxShar_01 = null;
                break;
            case "اداره جلسات و اخطار مغایرت قانونی":
                STchBoxShar_02 = null;
                break;
            case "ادغام و انحلال و تبدیل به شهر":
                STchBoxShar_03 = null;
                break;
            case "ارسال مصوبات":
                STchBoxShar_04 = null;
                break;
            case "ارگانهای دولتی":
                STchBoxShar_05 = null;
                break;
            case "استفاده از درآمد":
                STchBoxShar_06 = null;
                break;
            case "استقراض ":
                STchBoxShar_07 = null;
                break;
            case "اطلاع رسانی":
                STchBoxShar_08 = null;
                break;
            case "افزایش و کاهش":
                STchBoxShar_09 = null;
                break;
            case "الزامات":
                STchBoxShar_10 = null;
                break;
            case "امانی":
                STchBoxShar_11 = null;
                break;
            case "اموال":
                STchBoxShar_12 = null;
                break;
            case "انتخاب شهردار":
                STchBoxShar_13 = null;
                break;
            case "اولین جلسه":
                STchBoxShar_14 = null;
                break;
            case "انتخاب":
                STchBoxShar_15 = null;
                break;
            case "انواع":
                STchBoxShar_16 = null;
                break;
            case "بودجه":
                STchBoxShar_17 = null;
                break;
            case "پاداش":
                STchBoxShar_18 = null;
                break;
            case "پاسخ گویی و استیضاح":
                STchBoxShar_19 = null;
                break;
            case "پلاک کوبی و ثبت":
                STchBoxShar_20 = null;
                break;
            case "پیشنهادات ":
                STchBoxShar_21 = null;
                break;
            case "تامین اعتبار بودجه شورای شهر":
                STchBoxShar_22 = null;
                break;
            case "تامین اعتبارات اجرای قانون نوسازی از محل درآمد 10 درصد قانون نوسازی":
                STchBoxShar_23 = null;
                break;
            case "تبعیت مقامات":
                STchBoxShar_24 = null;
                break;
            case "تجدید مناقصه":
                STchBoxShar_25 = null;
                break;
            case "تحقیق و تفحص":
                STchBoxShar_26 = null;
                break;
            case "تحلیف و سوگند":
                STchBoxShar_27 = null;
                break;
            case "تحویل":
                STchBoxShar_28 = null;
                break;
            case "تخلف و محکومیت و محرومیت و حل اختلاف":
                STchBoxShar_29 = null;
                break;
            case "تصرف در سپرده":
                STchBoxShar_30 = null;
                break;
            case "تطبیق":
                STchBoxShar_31 = null;
                break;
            case "تقسیط":
                STchBoxShar_32 = null;
                break;
            case "توازن بودجه":
                STchBoxShar_33 = null;
                break;
            case "تهران":
                STchBoxShar_34 = null;
                break;
            case "جانشین و تفویض اختیار و مسئولیت":
                STchBoxShar_36 = null;
                break;
            case "حد نصاب":
                STchBoxShar_37 = null;
                break;
            case "حساب مخصوص وصول عوارض":
                STchBoxShar_38 = null;
                break;
            case "حراج":
                STchBoxShar_40 = null;
                break;
            case "حسن انجام کار":
                STchBoxShar_41 = null;
                break;
            case "حسابرسی":
                STchBoxShar_42 = null;
                break;
            case "درآمد":
                STchBoxShar_43 = null;
                break;
            case "حفظ و حراست":
                STchBoxShar_44 = null;
                break;
            case "رسمیت و اعتبار":
                STchBoxShar_45 = null;
                break;
            case "دفاتر حسابداری":
                STchBoxShar_46 = null;
                break;
            case "سهم فرهنگ و خیریه و درمان":
                STchBoxShar_47 = null;
                break;
            case "شرکتهای دولتی":
                STchBoxShar_48 = null;
                break;
            case "شیوه عمل معاملات متوسط":
                STchBoxShar_49 = null;
                break;
            case "صندوق":
                STchBoxShar_51 = null;
                break;
            case "عوارض":
                STchBoxShar_52 = null;
                break;
            case "عدم حضور برندگان":
                STchBoxShar_53 = null;
                break;
            case "کالای انحصاری":
                STchBoxShar_54 = null;
                break;
            case "قرارداد":
                STchBoxShar_55 = null;
                break;
            case "مراحل حسابرسی":
                STchBoxShar_56 = null;
                break;
            case "کمیسیون":
                STchBoxShar_57 = null;
                break;
            case "مصرف اعتبارات در همان حوزه":
                STchBoxShar_58 = null;
                break;
            case "مزایده":
                STchBoxShar_59 = null;
                break;
            case "مفاصا حساب عوارض ملک":
                STchBoxShar_61 = null;
                break;
            case "معاملات":
                STchBoxShar_62 = null;
                break;
            case "مکان و زمان":
                STchBoxShar_63 = null;
                break;
            case "مناقصه محدود":
                STchBoxShar_64 = null;
                break;
            case "مناقصه":
                STchBoxShar_65 = null;
                break;
            case "موسسات وابسته":
                STchBoxShar_66 = null;
                break;
            case "مناقصه محدود و تجدید و ترک مناقصه":
                STchBoxShar_67 = null;
                break;
            case "مهلت و دوره زمانی":
                STchBoxShar_68 = null;
                break;
            case "میزان افزایش و کاهش":
                STchBoxShar_69 = null;
                break;
            case " نسبت تخصیص بودجه عمرانی":
                STchBoxShar_39 = null;
                break;
            case "نحوه انجام و شیوه عمل":
                STchBoxShar_70 = null;
                break;
            case "وصول و نگهداری":
                STchBoxShar_71 = null;
                break;
            case "نصاب":
                STchBoxShar_72 = null;
                break;
            case "هزینه":
                STchBoxShar_73 = null;
                break;
            case "هدف تشکیل و وظایف و اختیارات":
                STchBoxShar_74 = null;
                break;
        }
    }

    private void ForbtnSearch() {
        STedtTxtSearchinTxt = edtTxtSearchinTxt.getText().toString();

        tb_ShahrdariroulsDATASource tb_shahrdariroulsDATASource = new tb_ShahrdariroulsDATASource(Activity_Search_SR.this);
        tb_shahrdariroulsDATASource.Open();


        if (STchBoxShar_01 != null || STchBoxShar_02 != null || STchBoxShar_03 != null || STchBoxShar_04 != null || STchBoxShar_05 != null || STchBoxShar_06 != null || STchBoxShar_07 != null || STchBoxShar_08 != null || STchBoxShar_09 != null || STchBoxShar_10 != null || STchBoxShar_11 != null || STchBoxShar_12 != null || STchBoxShar_13 != null || STchBoxShar_14 != null || STchBoxShar_15 != null || STchBoxShar_16 != null || STchBoxShar_17 != null || STchBoxShar_18 != null || STchBoxShar_19 != null || STchBoxShar_20 != null || STchBoxShar_21 != null || STchBoxShar_22 != null || STchBoxShar_23 != null || STchBoxShar_24 != null || STchBoxShar_25 != null || STchBoxShar_26 != null || STchBoxShar_27 != null || STchBoxShar_28 != null || STchBoxShar_29 != null || STchBoxShar_30 != null || STchBoxShar_31 != null || STchBoxShar_32 != null || STchBoxShar_33 != null || STchBoxShar_34 != null || STchBoxShar_36 != null || STchBoxShar_37 != null || STchBoxShar_38 != null || STchBoxShar_40 != null || STchBoxShar_41 != null || STchBoxShar_42 != null || STchBoxShar_43 != null || STchBoxShar_44 != null || STchBoxShar_45 != null || STchBoxShar_46 != null || STchBoxShar_47 != null || STchBoxShar_48 != null || STchBoxShar_49 != null || STchBoxShar_51 != null || STchBoxShar_52 != null || STchBoxShar_53 != null || STchBoxShar_54 != null || STchBoxShar_55 != null || STchBoxShar_56 != null || STchBoxShar_57 != null || STchBoxShar_58 != null || STchBoxShar_59 != null || STchBoxShar_61 != null || STchBoxShar_62 != null || STchBoxShar_63 != null || STchBoxShar_64 != null || STchBoxShar_65 != null || STchBoxShar_66 != null || STchBoxShar_67 != null || STchBoxShar_68 != null || STchBoxShar_69 != null || STchBoxShar_39 != null || STchBoxShar_70 != null || STchBoxShar_71 != null || STchBoxShar_72 != null || STchBoxShar_73 != null || STchBoxShar_74 != null || STchBoxShora_01 != null || STchBoxShora_02 != null || STchBoxShora_03 != null || STchBoxShora_04 != null || STchBoxShora_05 != null || STchBoxShora_06 != null || STchBoxShora_07 != null || STchBoxShora_08 != null || STchBoxShora_09 != null || STchBoxShora_10 != null || STchBoxShora_11 != null || STchBoxShora_12 != null || STchBoxShora_13 != null || STchBoxShora_14 != null || STchBoxShora_15 != null || STchBoxShora_16 != null || STchBoxShora_17 != null || STchBoxShora_18 != null || STchBoxShora_19 != null || STchBoxShora_20 != null || STchBoxShora_21 != null) {

            data = tb_shahrdariroulsDATASource.GetRecordByCompanyName(STchBoxShar_01, STchBoxShar_02, STchBoxShar_03, STchBoxShar_04, STchBoxShar_05, STchBoxShar_06, STchBoxShar_07, STchBoxShar_08, STchBoxShar_09, STchBoxShar_10, STchBoxShar_11, STchBoxShar_12, STchBoxShar_13, STchBoxShar_14, STchBoxShar_15, STchBoxShar_16, STchBoxShar_17, STchBoxShar_18, STchBoxShar_19, STchBoxShar_20, STchBoxShar_21, STchBoxShar_22, STchBoxShar_23, STchBoxShar_24, STchBoxShar_25, STchBoxShar_26, STchBoxShar_27, STchBoxShar_28, STchBoxShar_29, STchBoxShar_30, STchBoxShar_31, STchBoxShar_32, STchBoxShar_33, STchBoxShar_34, STchBoxShar_36, STchBoxShar_37, STchBoxShar_38, STchBoxShar_40, STchBoxShar_41, STchBoxShar_42, STchBoxShar_43, STchBoxShar_44, STchBoxShar_45, STchBoxShar_46, STchBoxShar_47, STchBoxShar_48, STchBoxShar_49, STchBoxShar_51, STchBoxShar_52, STchBoxShar_53, STchBoxShar_54, STchBoxShar_55, STchBoxShar_56, STchBoxShar_57, STchBoxShar_58, STchBoxShar_59, STchBoxShar_61, STchBoxShar_62, STchBoxShar_63, STchBoxShar_64, STchBoxShar_65, STchBoxShar_66, STchBoxShar_67, STchBoxShar_68, STchBoxShar_69, STchBoxShar_39, STchBoxShar_70, STchBoxShar_71, STchBoxShar_72, STchBoxShar_73, STchBoxShar_74, STchBoxShora_01, STchBoxShora_02, STchBoxShora_03, STchBoxShora_04, STchBoxShora_05, STchBoxShora_06, STchBoxShora_07, STchBoxShora_08, STchBoxShora_09, STchBoxShora_10, STchBoxShora_11, STchBoxShora_12, STchBoxShora_13, STchBoxShora_14, STchBoxShora_15, STchBoxShora_16, STchBoxShora_17, STchBoxShora_18, STchBoxShora_19, STchBoxShora_20, STchBoxShora_21);

            if (data != null) {
                if (!(STedtTxtSearchinTxt.equals(""))) {
                    try {
                        for (tb_ShahrdariRouls dat : data) {
                            if (dat.txtRouls.contains(STedtTxtSearchinTxt)) {
                                datatxt = new ArrayList<>();
                                datatxt.add(dat);
                            } else if (!(dat.txtRouls.contains(STedtTxtSearchinTxt))) {
                                recyclerviewSE.setAdapter(null);
                            }
                        }
                        dataSERACH = fill_with_data_txt(datatxt);
                        adapterSE = new Recycler_View_Adapter(dataSERACH, Activity_Search_SR.this);
                        recyclerviewSE.setAdapter(adapterSE);
                        recyclerviewSE.setLayoutManager(new LinearLayoutManager(Activity_Search_SR.this));
                    } catch (Exception e) {
                        Toast.makeText(Activity_Search_SR.this, "ارور در جستجو", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    try {
                        Toast.makeText(Activity_Search_SR.this, "موارد یافت شده", Toast.LENGTH_SHORT).show();
                        dataSERACH = fill_with_data();
                        adapterSE = new Recycler_View_Adapter(dataSERACH, Activity_Search_SR.this);
                        recyclerviewSE.setAdapter(adapterSE);
                        recyclerviewSE.setLayoutManager(new LinearLayoutManager(Activity_Search_SR.this));
                    } catch (Exception e) {
                        Toast.makeText(Activity_Search_SR.this, "ارور در جستجو", Toast.LENGTH_SHORT).show();
                    }
                }
            } else {
                Toast.makeText(Activity_Search_SR.this, "هیچ دیتایی وجود ندارد!", Toast.LENGTH_SHORT).show();
                recyclerviewSE.setAdapter(null);
            }

        } else if (STedtTxtSearchinTxt != null) {

            data = tb_shahrdariroulsDATASource.GetRecordByLike(STedtTxtSearchinTxt.equals("") ? null : STedtTxtSearchinTxt);
            if (data != null) {
                try {
                    Toast.makeText(Activity_Search_SR.this, "موارد یافت شده", Toast.LENGTH_SHORT).show();
                    dataSERACH = fill_with_data();
                    adapterSE = new Recycler_View_Adapter(dataSERACH, Activity_Search_SR.this);
                    recyclerviewSE.setAdapter(adapterSE);
                    recyclerviewSE.setLayoutManager(new LinearLayoutManager(Activity_Search_SR.this));
                } catch (Exception e) {
                    Toast.makeText(Activity_Search_SR.this, "ارور در جستجو", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(Activity_Search_SR.this, "هیچ دیتایی وجود ندارد!", Toast.LENGTH_SHORT).show();
                recyclerviewSE.setAdapter(null);
            }
            tb_shahrdariroulsDATASource.Close();

        }
    }
}


