package com.example.firstip.util;

import androidx.recyclerview.widget.RecyclerView;

public interface OnStartDragListener {
    //when user interacts,drag and drop action,viewHolder is obj being moved
    void onStartDrag(RecyclerView.ViewHolder viewHolder);
}
