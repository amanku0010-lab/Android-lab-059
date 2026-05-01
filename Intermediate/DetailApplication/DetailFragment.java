package com.example.masterdetail;

import android.os.Bundle;
import android.view.*;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment {

    static DetailFragment newInstance(int i) {
        DetailFragment f = new DetailFragment();
        Bundle b = new Bundle();
        b.putInt("id", i);
        f.setArguments(b);
        return f;
    }

    public View onCreateView(LayoutInflater i, ViewGroup g, Bundle b) {
        View v = i.inflate(R.layout.fragment_detail, g, false);

        TextView t = v.findViewById(R.id.txt);

        int id = getArguments().getInt("id");
        t.setText(Data.details[id]);

        return v;
    }
}
