package com.example.bottomnav.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bottomnav.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderLayout;

public class HomeFragment extends Fragment {

    SliderLayout sliderLayout;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        sliderLayout=root.findViewById(R.id.imageSlider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setScrollTimeInSec(1);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                setSliderViews();
            }
        });
        return root;
    }
    private void setSliderViews() {
        for(int i=0;i<=3;i++){
            DefaultSliderView sliderView= new DefaultSliderView(getContext());

            switch (i){
                case 0:
                    sliderView.setImageDrawable(R.drawable.img0);
                    break;
                case 1:
                    sliderView.setImageDrawable(R.drawable.img3);
                    break;
                case 2:
                    sliderView.setImageDrawable(R.drawable.img11);
                    break;
                case 3:
                    sliderView.setImageDrawable(R.drawable.img7);
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            //sliderView.setDescription("setDescription "+(i+1));
            //final int finalI=i;
            sliderLayout.addSliderView(sliderView);
        }
    }
}
