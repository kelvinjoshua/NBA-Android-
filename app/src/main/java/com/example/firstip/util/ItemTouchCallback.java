package com.example.firstip.util;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

//enables gestures in recycler view
public class ItemTouchCallback  extends ItemTouchHelper.Callback {
    private final ItemTouchHelperAdapter Adapter;

    public ItemTouchCallback(ItemTouchHelperAdapter gestAdapter) {
        this.Adapter = gestAdapter;
    }

    // informs the ItemTouchHelper which movement directions are supported.
    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        return 0;
    }

    //when moved-drag,drop movement
    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    //on dismiss,eventually deleting individual saved team
    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Adapter.onItemDismiss(viewHolder.getAdapterPosition());
    }
}
