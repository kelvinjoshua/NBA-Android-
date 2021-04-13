package com.example.firstip.util;

public interface ItemTouchHelperAdapter {
    //move ,swipe events
    boolean onItemMove(int fromPosition, int toPosition);
    void onItemDismiss(int position);
}
