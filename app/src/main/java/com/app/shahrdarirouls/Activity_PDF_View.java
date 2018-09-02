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

        switch (keyPDF) {
            case "کتاب1":
                pdfview.fromAsset("pdfName.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                break;
            case "کتاب2":
                pdfview.fromAsset("pdfName1.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                break;
            case "کتاب3":
                pdfview.fromAsset("pdfName2.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                break;
            case "کتاب4":
                pdfview.fromAsset("pdfName3.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                break;
            case "کتاب5":
                pdfview.fromAsset("pdfName4.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                break;
            case "کتاب6":
                pdfview.fromAsset("pdfName5.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                break;
            case "کتاب7":
                pdfview.fromAsset("pdfName5.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                break;
            case "کتاب8":
                pdfview.fromAsset("pdfName5.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                break;
            case "کتاب9":
                pdfview.fromAsset("pdfName5.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                break;
            case "کتاب10":
                pdfview.fromAsset("pdfName5.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                break;
            case "کتاب11":
                pdfview.fromAsset("pdfName5.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                break;


        }


    }
}
