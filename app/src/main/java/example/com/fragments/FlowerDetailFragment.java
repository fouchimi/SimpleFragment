package example.com.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;

import example.com.fragments.R;
import example.com.fragments.data.Flower;

/**
 * Created by LeBoss on 7/29/2015.
 */
public class FlowerDetailFragment extends Fragment {

    Flower flower;

    public FlowerDetailFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle b = getArguments();
        if(b != null && b.containsKey(Flower.FLOWER_NAME)){
            flower = new Flower(b);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.flower_detail_fragment, container, false);

        if(flower != null) {

            TextView tvName = (TextView) view.findViewById(R.id.tvFlowerName);
            tvName.setText(flower.getFlowerName());

            TextView tvInstructions = (TextView) view.findViewById(R.id.tvInstructions);
            tvInstructions.setText(flower.getInstructions());

            NumberFormat fmt = NumberFormat.getCurrencyInstance();
            TextView tvPrice = (TextView) view.findViewById(R.id.tvPrice);
            tvPrice.setText(fmt.format(flower.getPrice()));

            ImageView ivPicture = (ImageView) view.findViewById(R.id.ivFlowerImage);
            ivPicture.setImageResource(flower.getImageResource());

        }

        return view;
    }
}
