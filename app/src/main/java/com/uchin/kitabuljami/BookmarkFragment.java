package com.uchin.kitabuljami;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import static com.uchin.kitabuljami.R.layout.bookmark_layout;

/**
 * Created by Mukhlasin on 7/18/2017.
 */

public class BookmarkFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(bookmark_layout, null);
    }
}
