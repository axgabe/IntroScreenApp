package ua.axgabe.introscreenapp.Intro;

public class IntroScreenItem {

    public int Title,Description, ScreenImg;

    // Создаем к объектам конструктор и к нему же обявляем перемные Getter amd Setter.
    public IntroScreenItem(int title, int description, int screenImg) {
        Title = title;
        Description = description;
        ScreenImg = screenImg;
    }

    public int getTitle() {
        return Title;
    }

    public void setTitle(int title) {
        Title = title;
    }

    public int getDescription() {
        return Description;
    }

    public void setDescription(int description) {
        Description = description;
    }

    public int getScreenImg() {
        return ScreenImg;
    }

    public void setScreenImg(int screenImg) {
        ScreenImg = screenImg;
    }
}
