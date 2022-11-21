package com.example.eatssu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BoardAdapter extends BaseAdapter {

    private ArrayList<Board> BoardItemList = new ArrayList<Board>() ;

    // ListViewAdapter의 생성자
    public BoardAdapter() {}


    @Override
    public int getCount() {
        return BoardItemList.size();
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

        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.board_item, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView title = (TextView) convertView.findViewById(R.id.tv_title) ;
        TextView content = (TextView) convertView.findViewById(R.id.tv_content) ;

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        //BoardItemList boardItemList = BoardItemList.get(position); 이거??????????

        // 아이템 내 각 위젯에 데이터 반영 ( Test 중 )
        //iconImageView.setImageDrawable(listViewItem.getIcon());
        //titleTextView.setText(listViewItem.getTitle());
        //descTextView.setText(listViewItem.getDesc());

        return convertView;
    }
}
