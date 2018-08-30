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

        String keyPDF = getIntent().getStringExtra("KEY");

        switch (keyPDF) {
            case "first":
                pdfview.fromAsset("pdfName.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                break;
            case "second":
                pdfview.fromAsset("pdfName1.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                break;
            case "third":
                pdfview.fromAsset("pdfName2.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                break;
            case "fourth":
                pdfview.fromAsset("pdfName3.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                break;
            case "fifth":
                pdfview.fromAsset("pdfName4.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                break;
            case "sixth":
                pdfview.fromAsset("pdfName5.pdf").defaultPage(0).showMinimap(true).enableSwipe(true).load();
                break;
        }






    }
}
