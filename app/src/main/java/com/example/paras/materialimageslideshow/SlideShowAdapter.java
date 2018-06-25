package com.example.paras.materialimageslideshow;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

public class SlideShowAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    public int[] images ={
                    R.drawable.alexa,
                    R.drawable.kajal,
                    R.drawable.nayanthara,
                    R.drawable.rakul,
                    R.drawable.rashi
    };

    public SlideShowAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = layoutInflater.inflate(R.layout.slideshow,container,false);
        final ImageView img = (ImageView) view.findViewById(R.id.imageView);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(view,"Image"+(position+1),Snackbar.LENGTH_LONG).show();
            }
        });
      //  img.setImageResource(images[position]);
        Glide.with(context).load(images[position]).into(img);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((LinearLayout)object);

    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (LinearLayout)object);
    }
}
