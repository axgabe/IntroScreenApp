# IntroScreenApp
Макет IntroScreen V1
Информационый блок программы.
## Изображение макета
Макет № 1 - Вступ 
![intro_maket_1](https://user-images.githubusercontent.com/20967261/94929793-3b52fa80-04ce-11eb-993b-1941c78ce843.png)
Макет  № 2 - Доп. Информация
![intro_maket_2](https://user-images.githubusercontent.com/20967261/94930001-77865b00-04ce-11eb-9fc5-ea731f869f55.png)
Макет № 3 - Финал.  - переход к программе
![intro_maket_3](https://user-images.githubusercontent.com/20967261/94930007-78b78800-04ce-11eb-9b55-9a1202c18516.png)
Макет № 4 - Программа
![intro_maket_4](https://user-images.githubusercontent.com/20967261/94930010-79501e80-04ce-11eb-83ea-eb0211624317.png)


#  Реализация - проблемы

*  Метод слайдера старой версии, максимальная поддержка  API 29.
*  Слайдер ViewPager первой версии, для пользователей #Android_X не поддерживаеться. 
*    // ViewPager устарел для 9го поколения, с выходом Х версии, используеться новая версия
*    // ViewPager2 с активити RecyclerView, наследует теперь не PagerAdapter а RecyclerView.Adapter
*    // В классе IntroViewPagerAdapter

### В исходнике

* Маленькая анимация для кнопки Get Started (начать)
* Переключатель слайдеров, кнопка Next (далее)
* Возможность локализации : Title (заголовки), Descriptions (описание), Buttons (кнопки).
