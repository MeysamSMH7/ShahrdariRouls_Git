package com.app.shahrdarirouls;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.joanzapata.pdfview.PDFView;

public class Activity_PDF_View extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);

        PDFView pdfview = (PDFView) findViewById(R.id.pdfview);

        String keyPDF = getIntent().getStringExtra("KeyPDF");
//        String keyPDF2 = getIntent().getStringExtra("KeyPDF2");
//        String keyPDF3 = getIntent().getStringExtra("KeyPDF3");

//        if (keyPDF1 == "KeyPDF1"){
            switch (keyPDF) {
                case "1-1":
                    pdfview.fromAsset("1-1.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                    break;
                case "1-2":
                    pdfview.fromAsset("1-2.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                    break;
                case "1-3":
                    pdfview.fromAsset("1-3.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                    break;
                case "1-4":
                    pdfview.fromAsset("1-4.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                    break;
                case "1-5":
                    pdfview.fromAsset("1-5.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                    break;
                case "1-6":
                    pdfview.fromAsset("1-6.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                    break;
                case "1-7":
                    pdfview.fromAsset("1-7.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                    break;
                case "1-8":
                    pdfview.fromAsset("1-8.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                    break;
                case "1-9":
                    pdfview.fromAsset("1-9.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                    break;

                case "2-1":
                    pdfview.fromAsset("2-1.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                    break;
                case "2-2":
                    pdfview.fromAsset("2-2.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                    break;
                case "2-3":
                    pdfview.fromAsset("2-3.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                    break;
                case "2-4":
                    pdfview.fromAsset("2-4.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                    break;

                case "3-1":
                    pdfview.fromAsset("3-1.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                    break;
                case "3-2":
                    pdfview.fromAsset("3-2.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                    break;
                case "3-3":
                    pdfview.fromAsset("3-3.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                    break;
                case "3-4":
                    pdfview.fromAsset("3-4.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                    break;
            }

    }
}
