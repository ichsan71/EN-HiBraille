package id.or.codelabs.belajarbraille;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class GridRecyclerViewItemSpaces extends RecyclerView.ItemDecoration {
    private int space;

    public GridRecyclerViewItemSpaces(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        outRect.left = space;
        outRect.right = space;
        outRect.top = space;

        int itemCount = state.getItemCount();
        // Add top margin only for the first item to avoid double space between items
        if (parent.getChildLayoutPosition(view) == itemCount) {
            outRect.bottom = 0;
        } else {
            outRect.bottom = space;
        }
    }
}
