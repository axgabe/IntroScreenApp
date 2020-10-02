package ua.axgabe.introscreenapp.Intro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

import ua.axgabe.introscreenapp.R;

public class IntroViewPagerAdapter extends PagerAdapter {

    Context mContext;

    // Масив для записи обьектов
    List<IntroScreenItem> mListIntroScreen;


    public IntroViewPagerAdapter(Context mContext, List<IntroScreenItem> mListIntroScreen) {
        this.mContext = mContext;
        this.mListIntroScreen = mListIntroScreen;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutScreen = inflater.inflate(R.layout.layout_intro_screen,null);
        // Инициализируем все наши обекты с layout_intro_screen
        ImageView imgSlide = layoutScreen.findViewById(R.id.intro_img);
        TextView titleSlide = layoutScreen.findViewById(R.id.intro_title);
        TextView description = layoutScreen.findViewById(R.id.intro_description);

        // Присваиваем обекты
        titleSlide.setText(mListIntroScreen.get(position).getTitle());
        description.setText(mListIntroScreen.get(position).getDescription());
        imgSlide.setImageResource(mListIntroScreen.get(position).getScreenImg());

        container.addView(layoutScreen);

        return layoutScreen;

    }

    @Override
    public int getCount() {
        return mListIntroScreen.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object1) {

        container.removeView((View)object1);

    }
}
