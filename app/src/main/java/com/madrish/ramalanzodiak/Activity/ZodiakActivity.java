package com.madrish.ramalanzodiak.Activity;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.madrish.ramalanzodiak.Adapter.CardSquare;
import com.madrish.ramalanzodiak.Adapter.HarianCardViewAdapter;
import com.madrish.ramalanzodiak.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by A MADRISH on 9/10/2016
 */
public class ZodiakActivity extends AppCompatActivity{
    private RecyclerView recyclerView;
    private HarianCardViewAdapter adapter;
    private List<CardSquare> cardSquareList;
    ActionBar actionbar;
    TextView textview;
    ActionBar.LayoutParams layoutparams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ramal_harian);

        customActionBar();


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        cardSquareList = new ArrayList<>();
        adapter = new HarianCardViewAdapter(this, cardSquareList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(1), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        prepareAlbums();
    }

    private void customActionBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(//Center the textview in the ActionBar !
                ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                Gravity.CENTER);
        View viewActionBar = getLayoutInflater().inflate(R.layout.title_abs, null);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        TextView tit = (TextView)viewActionBar.findViewById(R.id.mytext);
        tit.setText(R.string.ramalan_harian);
        getSupportActionBar().setCustomView(viewActionBar, params);
    }


    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.capricorn,
                R.drawable.aquarius,
                R.drawable.pisces,
                R.drawable.aries,
                R.drawable.taurus,
                R.drawable.gemini,
                R.drawable.cancer,
                R.drawable.leo,
                R.drawable.virgo,
                R.drawable.libra,
                R.drawable.scorpio,
                R.drawable.sagitarius};

        CardSquare a = new CardSquare("Capricorn", covers[0]);
        cardSquareList.add(a);

        a = new CardSquare("Aquarius", covers[1]);
        cardSquareList.add(a);

        a = new CardSquare("Pisces", covers[2]);
        cardSquareList.add(a);

        a = new CardSquare("Aries", covers[3]);
        cardSquareList.add(a);

        a = new CardSquare("Taurus", covers[4]);
        cardSquareList.add(a);

        a = new CardSquare("Gemini", covers[5]);
        cardSquareList.add(a);

        a = new CardSquare("Cancer", covers[6]);
        cardSquareList.add(a);

        a = new CardSquare("Leo", covers[7]);
        cardSquareList.add(a);

        a = new CardSquare("Virgo", covers[8]);
        cardSquareList.add(a);

        a = new CardSquare("Libra", covers[9]);
        cardSquareList.add(a);

        a = new CardSquare("Scorpio", covers[10]);
        cardSquareList.add(a);

        a = new CardSquare("Sagitarius", covers[11]);
        cardSquareList.add(a);

        adapter.notifyDataSetChanged();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}
