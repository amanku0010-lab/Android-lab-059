package com.example.masterdetail;

import android.content.Context;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment {

    interface OnSelect {
        void onItem(int i);
    }

    OnSelect listener;

    public void onAttach(Context c) {
        super.onAttach(c);
        listener = (OnSelect) c;
    }

    public View onCreateView(LayoutInflater i, ViewGroup g, Bundle b) {
        View v = i.inflate(R.layout.fragment_list, g, false);

        ListView lv = v.findViewById(R.id.list);

        ArrayAdapter<String> a = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                Data.names
        );

        lv.setAdapter(a);

        lv.setOnItemClickListener((p,view,pos,id)->{
            listener.onItem(pos);
        });

        return v;
    }
}
