package example.com.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import example.com.fragments.data.Flower;
import example.com.fragments.data.FlowerData;

/**
 * Created by LeBoss on 7/27/2015.
 */
public class FlowerListFragment extends ListFragment {

    List<Flower> flowers = new FlowerData().getFlowers();
    public Callbacks activity;

    public FlowerListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FlowerArrayAdapter adapter = new FlowerArrayAdapter(getActivity(), R.layout.flower_listitem, flowers);
        setListAdapter(adapter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.flower_list_fragment, container, false);
        return rootView;
    }

    public interface Callbacks {
        public void onItemSelected(Flower flower);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Flower flower = flowers.get(position);
        activity.onItemSelected(flower);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = (Callbacks) activity;
    }
}
