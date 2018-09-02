package com.app.shahrdarirouls;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomGridView extends BaseAdapter {

    private Context mContext;
    private final String[] StName;
    private  int[] IntPic;

    public CustomGridView(Context c, String[] StName,int[] IntPic) {
        mContext = c;
        this.StName = StName;
        this.IntPic = IntPic;
    }

    @Override
    public int getCount() {
        return StName.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.row_grid, null);
            TextView textView = (TextView) grid.findViewById(R.id.txtGridView);
            ImageView imgGridView = (ImageView) grid.findViewById(R.id.imgGridView);

            textView.setText(StName[position]);
            imgGridView.setImageResource(IntPic[position]);

        } else {
            grid = (View) convertView;
        }

        return grid;
    }


}
