package ua.axgabe.introscreenapp.Intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import ua.axgabe.introscreenapp.MainActivity;
import ua.axgabe.introscreenapp.R;

public class IntroActivity extends AppCompatActivity {

    // ViewPager устарел для 9го поколения, с выходом Х версии, используеться новая версия
    // ViewPager2 с активити RecyclerView, наследует теперь не PagerAdapter а RecyclerView.Adapter
    // В классе IntroViewPagerAdapter
    private ViewPager screenPager;

    IntroViewPagerAdapter introViewPagerAdapter;
    TabLayout tabIntroIndicator;
    Button btnIntroNext;
    Button btnIntroGetStarted;
    private int position = 0;
    Animation btnAnim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Активити на весь экран
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Делаем проверку было ли раньше у пользователя окно приведствия
        if (restorePrefData()){
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            finish();
        }


        setContentView(R.layout.activity_intro);

        // Cкрываем панель действий
        getSupportActionBar().hide();



        // Инцилизируем обьекты
        btnIntroGetStarted = findViewById(R.id.btn_ingro_getstarted);
        btnIntroNext = findViewById(R.id.btn_intro_next);
        tabIntroIndicator = findViewById(R.id.intro_tab_indicator);
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.btn_anim);


        //Заполнить экран списка
        final List<IntroScreenItem> mList = new ArrayList<>();
        // Присваиваем элементы к инцилизированым объектам
        mList.add(new IntroScreenItem(R.string.one_intro_title,R.string.one_intro_description,R.drawable.coming_soon_1));
        mList.add(new IntroScreenItem(R.string.two_intro_title,R.string.two_intro_description,R.drawable.coming_soon_2));
        mList.add(new IntroScreenItem(R.string.three_intro_title,R.string.three_intro_description,R.drawable.coming_soon_3));



        //Установка viewpager (slider)
        screenPager = findViewById(R.id.introViewPager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this, mList);
        screenPager.setAdapter(introViewPagerAdapter);

        //Устанавливаем tablayout c viewpager
        tabIntroIndicator.setupWithViewPager(screenPager);


        // Кнопка "Далее" действие

        btnIntroNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                position = screenPager.getCurrentItem();
                if(position < mList.size()){

                    position++;
                    screenPager.setCurrentItem(position);
                }

                if(position == mList.size()-1){
                    // когда мы переходим к последнему экрану
                    // TODO: показать кнопку GETSTARTED (начать) и скрыть индикатор и следующую кнопку

                    loaddLastScreen();

                }

            }

        });


        // tablayout добавить слушателя изменений
        tabIntroIndicator.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == mList.size()-1){

                    loaddLastScreen();

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        // GETSTARTED обработаем нажатие кнопки
        btnIntroGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Откроем Main.Activity
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                // сохраним логическое значение в хранилище что бы в следуйщий раз пользователю не открывалось окно приведствия

                // Метод для хранения в кеше
                savePrefsData();
                finish();


            }
        });

    }

    private boolean restorePrefData (){

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        Boolean isIntroActivityOpenedBefore = pref.getBoolean("isIntroOpened", false);
        return isIntroActivityOpenedBefore;

    }

    private void savePrefsData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpened",true);
        editor.commit();
    }

    // Показать кнопку GETSTARTED (начать) и скрыть индикатор и следующую кнопку
    private void loaddLastScreen() {
        btnIntroNext.setVisibility(View.INVISIBLE);
        btnIntroGetStarted.setVisibility(View.VISIBLE);
        tabIntroIndicator.setVisibility(View.INVISIBLE);
        // TODO: Добавить анимацию для кнопки GETSTARTED
        // Создадим анимацию кнопки, установим анимацию
        btnIntroGetStarted.setAnimation(btnAnim);




    }

}