package com.example.eatssu;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class BoardHolder extends RecyclerView.ViewHolder {
    TextView mTitleField;
    TextView mContentField;
    TextView mLikeCountField;
    TextView mMessageCountField;
    TextView mUidField;
    TextView mDate;
    TextView mTrimUID;


    public BoardHolder(@NonNull View itemView) {
        super(itemView);
        mTitleField = itemView.findViewById(R.id.tv_title);
        mContentField = itemView.findViewById(R.id.tv_content);
        mLikeCountField = itemView.findViewById(R.id.tv_likeCount);
        mMessageCountField = itemView.findViewById(R.id.tv_messageCount);
        mTrimUID = itemView.findViewById(R.id.tv_id);
        //mUidField = itemView.findViewById(R.id.tv_id);
        mDate = itemView.findViewById(R.id.tv_time);
    }

    public void bind(@NonNull Board board) {
        mTitleField.setText(board.getTitle());
        mContentField.setText(board.getContent());
        mLikeCountField.setText(String.valueOf(board.getLikeCount()));
        mMessageCountField.setText(String.valueOf(board.getMessageCount()));
        mTrimUID.setText("ID"+board.getTrimUid());
        //mUidField.setText(board.getUid());
        mDate.setText(board.getTimestamp());
    }

}