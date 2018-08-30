package com.app.shahrdarirouls;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomGridView extends BaseAdapter {

    private Context mContext;
    private final String[] StName;

    public CustomGridView(Context c, String[] StName) {
        mContext = c;
        this.StName = StName;
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
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.row_grid, null);
            TextView textView = (TextView) grid.findViewById(R.id.txtGridView);
            textView.setText(StName[position]);
        } else {
            grid = (View) convertView;
        }

        return grid;
    }


}
